package com.douglasmoreira.coursemc.domain.enums;

public enum PaymentStatus {

    PENDING(1, "Pending"),
    SETTLED(2, "Settled"),
    CANCELED(3, "Canceled");

    private int cod;
    private String description;

    PaymentStatus(int cod, String description) {
        this.cod = cod;
        this.description = description;
    }

    public int getCod() {
        return cod;
    }

    public String getDescription() {
        return description;
    }

    public static PaymentStatus toEnum(Integer cod) {

        if (cod == null) {
            return null;
        }

        for (PaymentStatus paymentStatus: PaymentStatus.values()) {
            if (cod.equals(paymentStatus)) {
                return paymentStatus;
            }
        }

        throw new IllegalArgumentException("invalid cod: " + cod);
    }

}
