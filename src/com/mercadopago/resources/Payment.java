package com.mercadopago.resources;

import com.google.gson.JsonObject;
import com.mercadopago.core.MPBase;
import com.mercadopago.core.MPBaseResponse;
import com.mercadopago.core.annotations.idempotent.Idempotent;
import com.mercadopago.core.annotations.rest.GET;
import com.mercadopago.core.annotations.rest.POST;
import com.mercadopago.core.annotations.rest.PUT;
import com.mercadopago.core.annotations.validation.Numeric;
import com.mercadopago.core.annotations.validation.Size;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.datastructures.payment.*;
import com.mercadopago.resources.interfaces.IPNRecoverable;

import java.util.ArrayList;
import java.util.Date;

/**
 * Mercado Pago SDK
 * This resource allows you to create, modify or read payments
 *
 * Created by Eduardo Paoletta on 12/2/16.
 */
@Idempotent
public class Payment extends MPBase implements IPNRecoverable {

    private String id = null;
    private Date dateCreated = null;
    private Date dateApproved = null;
    private Date dateLastUpdated = null;
    private Date moneyReleaseDate = null;
    private Integer collectorId = null;
    private OperationType operationType = null;
    public enum OperationType {
        regular_payment,
        money_transfer,
        recurring_payment,
        account_fund,
        payment_addition,
        cellphone_recharge,
        pos_payment
    }
    private Payer payer = null;
    private Boolean binaryMode = null;
    private Boolean liveMode = null;
    private Order order = null;
    private String externalReference = null;
    private String description = null;
    private JsonObject metadata = null;
    @Size(min=3, max=3) private CurrencyId currencyId = null;
    public enum CurrencyId {
        ARS,
        BRL,
        VEF,
        CLP,
        MXN,
        COP,
        PEN,
        UYU
    }
    private Float transactionAmount = null;
    private Float transactionAmountRefunded = null;
    private Float couponAmount = null;
    private Integer campaignId = null;
    private String couponCode = null;
    private TransactionDetails transactionDetails = null;
    private ArrayList<FeeDetail> feeDetails = null;
    private Integer differentialPricingId = null;
    private Float applicationFee = null;
    private Status status = null;
    public enum Status {
        pending,
        approved,
        authorized,
        in_process,
        in_mediation,
        rejected,
        cancelled,
        refunded,
        charged_back
    }
    private String statusDetail = null;
    private Boolean capture = null;
    private Boolean captured = null;
    private String callForAuthorizeId = null;
    private String paymentMethodId = null;
    private String issuerId = null;
    private PaymentTypeId paymentTypeId = null;
    public enum PaymentTypeId {
        account_money,
        ticket,
        bank_transfer,
        atm,
        credit_card,
        debit_card,
        prepaid_card
    }
    private String token = null;
    private Card card = null;
    private String statementDescriptor = null;
    @Numeric(min=1, fractionDigits=0) private Integer installments = null;
    private String notificationUrl = null;
    private ArrayList<Refund> refunds = null;
    private AdditionalInfo additionalInfo = null;


    public String getId() {
        return id;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public Date getDateApproved() {
        return dateApproved;
    }

    public Date getDateLastUpdated() {
        return dateLastUpdated;
    }

    public Date getMoneyReleaseDate() {
        return moneyReleaseDate;
    }

    public Integer getCollectorId() {
        return collectorId;
    }

    public OperationType getOperationType() {
        return operationType;
    }

    public Payer getPayer() {
        return payer;
    }

    public Payment setPayer(Payer payer) {
        this.payer = payer;
        return this;
    }

    public Boolean getBinaryMode() {
        return binaryMode;
    }

    public Payment setBinaryMode(Boolean binaryMode) {
        this.binaryMode = binaryMode;
        return this;
    }

    public Boolean getLiveMode() {
        return liveMode;
    }

    public Order getOrder() {
        return order;
    }

    public Payment setOrder(Order order) {
        this.order = order;
        return this;
    }

    public String getExternalReference() {
        return externalReference;
    }

    public Payment setExternalReference(String externalReference) {
        this.externalReference = externalReference;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Payment setDescription(String description) {
        this.description = description;
        return this;
    }

    public JsonObject getMetadata() {
        return metadata;
    }

    public Payment setMetadata(JsonObject metadata) {
        this.metadata = metadata;
        return this;
    }

    public CurrencyId getCurrencyId() {
        return currencyId;
    }

    public Float getTransactionAmount() {
        return transactionAmount;
    }

    public Payment setTransactionAmount(Float transactionAmount) {
        this.transactionAmount = transactionAmount;
        return this;
    }

    public Float getTransactionAmountRefunded() {
        return transactionAmountRefunded;
    }

    public Float getCouponAmount() {
        return couponAmount;
    }

    public Payment setCouponAmount(Float couponAmount) {
        this.couponAmount = couponAmount;
        return this;
    }

    public Payment setCampaignId(Integer campaignId) {
        this.campaignId = campaignId;
        return this;
    }

    public Payment setCouponCode(String couponCode) {
        this.couponCode = couponCode;
        return this;
    }

    public TransactionDetails getTransactionDetails() {
        return transactionDetails;
    }

    public ArrayList<FeeDetail> getFeeDetails() {
        return feeDetails;
    }

    public Integer getDifferentialPricingId() {
        return differentialPricingId;
    }

    public Payment setDifferentialPricingId(Integer differentialPricingId) {
        this.differentialPricingId = differentialPricingId;
        return this;
    }

    public Payment setApplicationFee(Float applicationFee) {
        this.applicationFee = applicationFee;
        return this;
    }

    public Status getStatus() {
        return status;
    }

    public String getStatusDetail() {
        return statusDetail;
    }

    public Payment setCapture(Boolean capture) {
        this.capture = capture;
        return this;
    }

    public Boolean getCaptured() {
        return captured;
    }

    public String getCallForAuthorizeId() {
        return callForAuthorizeId;
    }

    public String getPaymentMethodId() {
        return paymentMethodId;
    }

    public Payment setPaymentMethodId(String paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
        return this;
    }

    public String getIssuerId() {
        return issuerId;
    }

    public Payment setIssuerId(String issuerId) {
        this.issuerId = issuerId;
        return this;
    }

    public PaymentTypeId getPaymentTypeId() {
        return paymentTypeId;
    }

    public Payment setToken(String token) {
        this.token = token;
        return this;
    }

    public Card getCard() {
        return card;
    }

    public String getStatementDescriptor() {
        return statementDescriptor;
    }

    public Payment setStatementDescriptor(String statementDescriptor) {
        this.statementDescriptor = statementDescriptor;
        return this;
    }

    public Integer getInstallments() {
        return installments;
    }

    public Payment setInstallments(Integer installments) {
        this.installments = installments;
        return this;
    }


    public String getNotificationUrl() {
        return notificationUrl;
    }

    public Payment setNotificationUrl(String notificationUrl) {
        this.notificationUrl = notificationUrl;
        return this;
    }

    public ArrayList<Refund> getRefunds() {
        return refunds;
    }

    public Payment setAdditionalInfo(AdditionalInfo additionalInfo) {
        this.additionalInfo = additionalInfo;
        return this;
    }


    public MPBaseResponse load(String id) throws MPException {
        return load(id, WITHOUT_CACHE);
    }

    @GET(path="/v1/payments/:id")
    public MPBaseResponse load(String id, Boolean useCache) throws MPException {
        return super.processMethod("load", id, useCache);
    }

    @POST(path="/v1/payments")
    public MPBaseResponse create() throws MPException {
        return super.processMethod("create");
    }

    @PUT(path="/v1/payments/:id")
    public MPBaseResponse update() throws MPException {
        return super.processMethod("update");
    }

}