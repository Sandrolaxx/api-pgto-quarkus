package org.acme.dto;

import jakarta.json.bind.annotation.JsonbProperty;

public class ConsultaBoletoDTO {
    
    @JsonbProperty("barCode")
    private ConsultaBoletoDataDTO data;

    @JsonbProperty("billData")
    private ConsultaBoletoDataDTO bill;

    private Long transactionIdAuthorize;

    private String cpfCnpj;

    private String dueDate;

    public ConsultaBoletoDataDTO getData() {
        return data;
    }

    public void setData(ConsultaBoletoDataDTO data) {
        this.data = data;
    }

    public ConsultaBoletoDataDTO getBill() {
        return bill;
    }

    public void setBill(ConsultaBoletoDataDTO bill) {
        this.bill = bill;
    }

    public Long getTransactionIdAuthorize() {
        return transactionIdAuthorize;
    }

    public void setTransactionIdAuthorize(Long transactionIdAuthorize) {
        this.transactionIdAuthorize = transactionIdAuthorize;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

}
