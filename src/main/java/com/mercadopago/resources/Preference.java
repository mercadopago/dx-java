package com.mercadopago.resources;

import com.mercadopago.core.MPBase;
import com.mercadopago.core.annotations.rest.GET;
import com.mercadopago.core.annotations.rest.POST;
import com.mercadopago.core.annotations.rest.PUT;
import com.mercadopago.core.annotations.validation.NotNull;
import com.mercadopago.core.annotations.validation.Size;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.datastructures.preference.*;

import java.util.ArrayList;
import java.util.Date;

/**
 * Mercado Pago MercadoPago
 * This resource allows you to set up, during the Payment process, all the item information,
 * any accepted means of Payment and many other options.
 *
 * Created by Eduardo Paoletta on 11/9/16.
 */
public class Preference extends MPBase {

    @NotNull private ArrayList<Item> items = null;
    @NotNull private Payer payer = null;
    private PaymentMethods paymentMethods = null;
    private Shipments shipments = null;
    private BackUrls backUrls = null;
    @Size(max=500) private String notificationUrl = null;
    private String id = null;
    private String initPoint = null;
    private String sandboxInitPoint = null;
    private Date dateCreated = null;
    private OperationType operationType = null;
    public enum OperationType {
        regular_payment,
        money_transfer
    }
    @Size(max=600) private String additionalInfo = null;
    private AutoReturn autoReturn = null;
    public enum AutoReturn {
        approved,
        all
    }
    @Size(max=256) private String externalReference = null;
    private Boolean expires = null;
    private Date expirationDateFrom = null;
    private Date expirationDateTo = null;
    private Float collectorId = null;
    private Float clientId = null;
    @Size(max=256) private String marketplace = null;
    private Float marketplaceFee = null;
    private DifferentialPricing differentialPricing = null;


    public ArrayList<Item> getItems() {
        return items;
    }

    public Preference setItems(ArrayList<Item> items) {
        this.items = items;
        return this;
    }

    public Preference appendItem(Item item) {
        if (items == null) {
            items = new ArrayList<Item>();
        }
        items.add(item);
        return this;
    }

    public Payer getPayer() {
        return payer;
    }

    public Preference setPayer(Payer payer) {
        this.payer = payer;
        return this;
    }

    public PaymentMethods getPaymentMethods() {
        return paymentMethods;
    }

    public Preference setPaymentMethods(PaymentMethods paymentMethods) {
        this.paymentMethods = paymentMethods;
        return this;
    }

    public Shipments getShipments() {
        return shipments;
    }

    public Preference setShipments(Shipments shipments) {
        this.shipments = shipments;
        return this;
    }

    public BackUrls getBackUrls() {
        return backUrls;
    }

    public Preference setBackUrls(BackUrls backUrls) {
        this.backUrls = backUrls;
        return this;
    }

    public String getNotificationUrl() {
        return notificationUrl;
    }

    public Preference setNotificationUrl(String notificationUrl) {
        this.notificationUrl = notificationUrl;
        return this;
    }

    public String getId() {
        return id;
    }

    public String getInitPoint() {
        return initPoint;
    }

    public String getSandboxInitPoint() {
        return sandboxInitPoint;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public OperationType getOperationType() {
        return operationType;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public Preference setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
        return this;
    }

    public AutoReturn getAutoReturn() {
        return autoReturn;
    }

    public Preference setAutoReturn(AutoReturn autoReturn) {
        this.autoReturn = autoReturn;
        return this;
    }

    public String getExternalReference() {
        return externalReference;
    }

    public Preference setExternalReference(String externalReference) {
        this.externalReference = externalReference;
        return this;
    }

    public Boolean getExpires() {
        return expires;
    }

    public Preference setExpires(Boolean expires) {
        this.expires = expires;
        return this;
    }

    public Date getExpirationDateFrom() {
        return expirationDateFrom;
    }

    public Preference setExpirationDateFrom(Date expirationDateFrom) {
        this.expirationDateFrom = expirationDateFrom;
        return this;
    }

    public Date getExpirationDateTo() {
        return expirationDateTo;
    }

    public Preference setExpirationDateTo(Date expirationDateTo) {
        this.expirationDateTo = expirationDateTo;
        return this;
    }

    public Float getCollectorId() {
        return collectorId;
    }

    public Float getClientId() {
        return clientId;
    }

    public String getMarketplace() {
        return marketplace;
    }

    public Preference setMarketplace(String marketplace) {
        this.marketplace = marketplace;
        return this;
    }

    public Float getMarketplaceFee() {
        return marketplaceFee;
    }

    public Preference setMarketplaceFee(Float marketplaceFee) {
        this.marketplaceFee = marketplaceFee;
        return this;
    }

    public DifferentialPricing getDifferentialPricing() {
        return differentialPricing;
    }

    public Preference setDifferentialPricing(DifferentialPricing differentialPricing) {
        this.differentialPricing = differentialPricing;
        return this;
    }


    public static Preference findById(String id) throws MPException {
        return findById(id, WITHOUT_CACHE);
    }

    public static Preference findById(String id, String accessToken) throws MPException {
        return findById(id, accessToken, WITHOUT_CACHE);
    }

    public static Preference findById(String id, Boolean useCache) throws MPException {
        return findById(id, null, useCache);
    }

    @GET(path="/checkout/preferences/:id")
    public static Preference findById(String id, String accessToken, Boolean useCache) throws MPException {
        return Preference.processMethod(Preference.class, "findById", id, accessToken, useCache);
    }

    public Preference save() throws MPException {
        return this.save(null);
    }

    @POST(path="/checkout/preferences")
    public Preference save(String accessToken) throws MPException {
        return super.processMethod("save", accessToken, WITHOUT_CACHE);
    }

    public Preference update() throws MPException {
        return this.update(null);
    }

    @PUT(path="/checkout/preferences/:id")
    public Preference update(String accessToken) throws MPException {
        return super.processMethod("update", accessToken, WITHOUT_CACHE);
    }

}
