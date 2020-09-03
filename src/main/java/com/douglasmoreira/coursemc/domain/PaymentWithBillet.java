package com.douglasmoreira.coursemc.domain;

import com.douglasmoreira.coursemc.domain.enums.PaymentStatus;

import javax.persistence.Entity;
import java.util.Date;

@Entity
public class PaymentWithBillet extends Payment {

    private Date dueDate;
    private Date paymentDate;

    public PaymentWithBillet() {

    }

    public PaymentWithBillet(Date dueDate, Date paymentDate) {
        this.dueDate = dueDate;
        this.paymentDate = paymentDate;
    }

    public PaymentWithBillet(Integer id, PaymentStatus paymentStatus, Request request, Date dueDate, Date paymentDate) {
        super(id, paymentStatus, request);
        this.dueDate = dueDate;
        this.paymentDate = paymentDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }
}
