package com.douglasmoreira.coursemc.domain;

import com.douglasmoreira.coursemc.domain.enums.PaymentStatus;

import javax.persistence.Entity;

@Entity
public class PaymentWithCard extends Payment {

    private Integer numberOfInstallments;

    public PaymentWithCard() {

    }

    public PaymentWithCard(Integer numberOfInstallments) {
        this.numberOfInstallments = numberOfInstallments;
    }

    public PaymentWithCard(Integer id, PaymentStatus paymentStatus, Request request, Integer numberOfInstallments) {
        super(id, paymentStatus, request);
        this.numberOfInstallments = numberOfInstallments;
    }

    public Integer getNumberOfInstallments() {
        return numberOfInstallments;
    }

    public void setNumberOfInstallments(Integer numberOfInstallments) {
        this.numberOfInstallments = numberOfInstallments;
    }
}
