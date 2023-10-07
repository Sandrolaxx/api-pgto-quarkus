package org.acme.dto;

import java.math.BigDecimal;

public class ConsultResponseDTO {

    private String assignor;

    private String settleDate;

    private String dueDate;

    private String endHour;

    private String initeHour;

    private String nextSettle;

    private String digitable;

    private BigDecimal transactionId;

    private BigDecimal type;

    private BigDecimal value;

    private String errorCode;

    private String message;

    private BigDecimal status;

    private RegisterData registerData;

    public String getAssignor() {
        return assignor;
    }

    public void setAssignor(String assignor) {
        this.assignor = assignor;
    }

    public String getSettleDate() {
        return settleDate;
    }

    public void setSettleDate(String settleDate) {
        this.settleDate = settleDate;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getEndHour() {
        return endHour;
    }

    public void setEndHour(String endHour) {
        this.endHour = endHour;
    }

    public String getIniteHour() {
        return initeHour;
    }

    public void setIniteHour(String initeHour) {
        this.initeHour = initeHour;
    }

    public String getNextSettle() {
        return nextSettle;
    }

    public void setNextSettle(String nextSettle) {
        this.nextSettle = nextSettle;
    }

    public String getDigitable() {
        return digitable;
    }

    public void setDigitable(String digitable) {
        this.digitable = digitable;
    }

    public BigDecimal getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(BigDecimal transactionId) {
        this.transactionId = transactionId;
    }

    public BigDecimal getType() {
        return type;
    }

    public void setType(BigDecimal type) {
        this.type = type;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public BigDecimal getStatus() {
        return status;
    }

    public void setStatus(BigDecimal status) {
        this.status = status;
    }

    public RegisterData getRegisterData() {
        return registerData;
    }

    public void setRegisterData(RegisterData registerData) {
        this.registerData = registerData;
    }

}