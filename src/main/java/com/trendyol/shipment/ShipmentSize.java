package com.trendyol.shipment;

public enum ShipmentSize {

    SMALL(0),
    MEDIUM(1),
    LARGE(2),
    X_LARGE(3);

    private final int order;
    private ShipmentSize(int order) {
        this.order = order;
    }
    public int getOrder() {
        return this.order;
    }
}
