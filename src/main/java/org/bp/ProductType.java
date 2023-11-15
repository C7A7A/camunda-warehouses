package org.bp;

public enum ProductType {
    OTHER("other", 1f),
    GROCERY("grocery", 0.8f),
    TRANSPORT("transport", 1.2f),
    ENTERTAINMENT("entertainment ", 1.5f),
    ELECTRONICS("electronics ", 2f),
    MILITARY("military ", 5f),
    SECRET("secret ", 15f);

    public final String type;
    public final Float multiplier;

    private ProductType(String type, Float multiplier) {
        this.type = type;
        this.multiplier = multiplier;
    }
}
