package com.mercadopago.resources;

import com.google.gson.JsonObject;
import com.mercadopago.core.MPBase;
import com.mercadopago.core.MPResourceArray;
import com.mercadopago.core.annotations.rest.DELETE;
import com.mercadopago.core.annotations.rest.GET;
import com.mercadopago.core.annotations.rest.POST;
import com.mercadopago.core.annotations.rest.PUT;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.datastructures.customer.Address;
import com.mercadopago.resources.datastructures.customer.DefaultAddress;
import com.mercadopago.resources.datastructures.customer.Identification;
import com.mercadopago.resources.datastructures.customer.Phone;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.HashMap;

/**
 * Mercado Pago SDK Retrieves information about a customer
 *
 * Created by Eduardo Paoletta on 12/15/16.
 */
public class Customer extends MPBase {

	private String id = null;
	private String email = null;
	private String firstName = null;
	private String lastName = null;
	private Phone phone = null;
	private Identification identification = null;
	private String defaultAddress = null;
	private DefaultAddress address = null;
	private Date dateRegistered = null;
	private String description = null;
	private Date dateCreated = null;
	private Date dateLastUpdated = null;
	private JsonObject metadata = null;
	private String defaultCard = null;
	private ArrayList<Card> cards = null;
	private ArrayList<Address> addresses = null;
	private Boolean liveMode = null;

	public String getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public Customer setEmail(String email) {
		this.email = email;
		return this;
	}

	public String getFirstName() {
		return firstName;
	}

	public Customer setFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	public String getLastName() {
		return lastName;
	}

	public Customer setLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	public Phone getPhone() {
		return phone;
	}

	public Customer setPhone(Phone phone) {
		this.phone = phone;
		return this;
	}

	public Identification getIdentification() {
		return identification;
	}

	public Customer setIdentification(Identification identification) {
		this.identification = identification;
		return this;
	}

	public String getDefaultAddress() {
		return defaultAddress;
	}

	public Customer setDefaultAddress(String defaultAddress) {
		this.defaultAddress = defaultAddress;
		return this;
	}

	public DefaultAddress getAddress() {
		return address;
	}

	public Customer setAddress(DefaultAddress address) {
		this.address = address;
		return this;
	}

	public Date getDateRegistered() {
		return dateRegistered;
	}

	public Customer setDateRegistered(Date dateRegistered) {
		this.dateRegistered = dateRegistered;
		return this;
	}

	public String getDescription() {
		return description;
	}

	public Customer setDescription(String description) {
		this.description = description;
		return this;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public Date getDateLastUpdated() {
		return dateLastUpdated;
	}

	public JsonObject getMetadata() {
		return metadata;
	}

	public Customer setMetadata(JsonObject metadata) {
		this.metadata = metadata;
		return this;
	}

	public String getDefaultCard() {
		return defaultCard;
	}

	public Customer setDefaultCard(String defaultCard) {
		this.defaultCard = defaultCard;
		return this;
	}

	public ArrayList<Card> getCards() {
		return cards;
	}

	public ArrayList<Address> getAddresses() {
		return addresses;
	}

	public Boolean getLiveMode() {
		return liveMode;
	}

	public static MPResourceArray search(Map<String, String> filters) throws MPException {
		return search(filters, WITHOUT_CACHE);
	}

	@GET(path = "/v1/customers/search")
	public static MPResourceArray search(Map<String, String> filters, Boolean useCache) throws MPException {
		return Customer.processMethodBulk(Customer.class, "search", new HashMap<String, String>(filters), useCache);
	}

	public static Customer findById(String id) throws MPException {
		return findById(id, WITHOUT_CACHE);
	}

	@GET(path = "/v1/customers/:id")
	public static Customer findById(String id, Boolean useCache) throws MPException {
		return Customer.processMethod(Customer.class, "findById", id, useCache);
	}

	@POST(path = "/v1/customers")
	public Customer save() throws MPException {
		return super.processMethod("save", WITHOUT_CACHE);
	}

	@PUT(path = "/v1/customers/:id")
	public Customer update() throws MPException {
		return super.processMethod("update", WITHOUT_CACHE);
	}

	@DELETE(path = "/v1/customers/:id")
	public Customer delete() throws MPException {
		return super.processMethod("delete", WITHOUT_CACHE);
	}

}
