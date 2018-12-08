package com.mercadopago.core;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.net.HttpMethod;
import com.mercadopago.utils.ResponseError;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpRequestBase;

/**
 * Mercado Pago SDK MPBase response class
 *
 * Created by Eduardo Paoletta on 11/17/16.
 */
public class MPApiResponse implements Cloneable {

	private HttpRequestBase _httpRequest;
	private JsonObject _requestPayload;
	private HttpResponse _httpResponse;
	private long _responseMillis;

	private String method;
	private String url;
	private String payload;

	private int statusCode;
	private String reasonPhrase;

	private String stringResponse;

	private JsonElement jsonElementResponse;

	private ResponseError responseError;

	public Boolean fromCache = Boolean.FALSE;

	public MPApiResponse(HttpMethod httpMethod, HttpRequestBase request, JsonObject payload, HttpResponse response,
			long responseMillis) throws MPException {
		this._httpRequest = request;
		this._requestPayload = payload;
		this._httpResponse = response;
		this._responseMillis = responseMillis;
		parseRequest(httpMethod, request, payload);
		parseResponse(response);
	}

	public String getMethod() {
		return this.method;
	}

	public String getUrl() {
		return this.url;
	}

	public String getPayload() {
		return this.payload;
	}

	public int getStatusCode() {
		return this.statusCode;
	}

	public String getReasonPhrase() {
		return this.reasonPhrase;
	}

	public String getStringResponse() {
		return this.stringResponse;
	}

	public JsonElement getJsonElementResponse() {
		return this.jsonElementResponse;
	}

	public Header[] getHeaders(String headerName) {
		return this._httpResponse.getHeaders(headerName);
	}

	/**
	 * Parses the http request in a custom MPApiResponse object.
	 *
	 * @param httpMethod enum with the method executed
	 * @param request    HttpRequestBase object
	 * @param payload    JsonObject with the payload
	 * @throws MPException
	 */
	private void parseRequest(HttpMethod httpMethod, HttpRequestBase request, JsonObject payload) throws MPException {
		this.method = httpMethod.toString();
		this.url = request.getURI().toString();
		if (payload != null) {
			this.payload = payload.toString();
		}
	}

	/**
     * Parses the http response in a custom MPApiResponse object.
     *
     * @param response              a Http response to be parsed
     * @throws MPException
     */
    private void parseResponse(HttpResponse response) throws MPException {
    	Gson gson = new Gson();
        this.statusCode = response.getStatusLine().getStatusCode();
        this.reasonPhrase = response.getStatusLine().getReasonPhrase();

        if (response.getEntity() != null) {
            HttpEntity respEntity = response.getEntity();
            try {
                this.stringResponse = MPCoreUtils.inputStreamToString(respEntity.getContent());
            } catch (Exception ex) {
                throw new MPException(ex);
            }

            // Try to parse the response to a json, and a extract the entity of the response.
            // When the response is not a json parseable string then the string response must be used.
            try {
                this.jsonElementResponse = new JsonParser().parse(this.stringResponse);

                if (this.statusCode != 200 && this.statusCode != 201) {
                	this.responseError = gson.fromJson(this.jsonElementResponse, ResponseError.class);
                }

            } catch (JsonParseException jsonParseException) {
                // Do nothing
            }
        }
    }

	@Override
	protected MPApiResponse clone() throws CloneNotSupportedException {
		return (MPApiResponse) super.clone();
	}

}
