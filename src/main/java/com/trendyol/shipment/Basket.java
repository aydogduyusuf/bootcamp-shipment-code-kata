package com.trendyol.shipment;

import java.util.List;
import java.util.HashMap;

public class Basket {

    private List<Product> products;
    private ShipmentSize[] shipmentSizesArr = ShipmentSize.values();
    private int maxSize = 0;

    public ShipmentSize getShipmentSize() {
        if (products.size() < 3) {
            return products.get(0).getSize().getOrder() < products.get(1).getSize().getOrder() ?
                    products.get(1).getSize() : products.get(0).getSize();
        }
        HashMap<ShipmentSize, Integer> countOfShipmentSizes = new HashMap<>();

        for (Product product: products) {
            ShipmentSize shipmentSize = product.getSize();
            if (shipmentSize.getOrder() > maxSize) {
                maxSize = shipmentSize.getOrder();
            }

            if (countOfShipmentSizes.containsKey(shipmentSize)) {
                countOfShipmentSizes.put(shipmentSize, countOfShipmentSizes.get(shipmentSize)+1);
            } else {
                countOfShipmentSizes.put(shipmentSize, 1);
            }
        }

        for (ShipmentSize shipmentSize: countOfShipmentSizes.keySet()) {
            if (countOfShipmentSizes.get(shipmentSize) >= 3 && shipmentSize != ShipmentSize.X_LARGE) {
                return shipmentSizesArr[shipmentSize.getOrder()+1];
            } else if (countOfShipmentSizes.get(shipmentSize) >= 3 && shipmentSize == ShipmentSize.X_LARGE) {
                return ShipmentSize.X_LARGE;
            }
        }

        return shipmentSizesArr[maxSize];
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
