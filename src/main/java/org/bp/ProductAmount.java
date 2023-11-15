package org.bp;

public enum ProductAmount {
    FEW("few", 1.1f),
    NORMAL("normal", 1f),
    LOT("lot", 0.9f),
    HUGE("huge", 0.7f);


    public final String amountDescription;
    public final Float multiplier;

    private ProductAmount(String amountDescription, Float multiplier) {
        this.amountDescription = amountDescription;
        this.multiplier = multiplier;
    }
}
