package com.maps;

/**
 * Created by dev on 16/02/2016.
 */
public class StockItem implements Comparable<StockItem> {
    private final String name;
    private double price;
    private int reserved;
    private int quantityStock;
    private int availableStock;

    public StockItem(String name, double price) {
        this.name = name;
        this.price = price;
        this.quantityStock = 0;
        this.reserved = 0;
    }

    public StockItem(String name, double price, int quantityStock) {
        this.name = name;
        this.price = price;
        this.quantityStock = quantityStock;
        this.availableStock = quantityStock;
    }

    public String getName() {
        return name;
    }

    public void reserveItem(int q) {
        if(this.availableStock() >= q) {
            this.reserved += q;
            this.availableStock -= q;
        } else {
            System.out.println("Not enough " + this.getName() + "s in stock to reserve");
        }
    }

    public void unreserve(int q) {
        if(this.reserved > 0) {
            this.reserved -= q;
            this.availableStock += q;
        } else {
            System.out.println("No " + this.getName() + "s reserved");
        }
    }

    public double getPrice() {
        return price;
    }

    public int quantityInStock() {
        return quantityStock;
    }

    public int availableStock() {
        return this.quantityStock - this.reserved;
    }

    public void setPrice(double price) {
        if(price > 0.0) {
            this.price = price;
        }
    }

    public void adjustStock(int quantity) {
        int newQuantity = this.quantityStock + quantity;
        if(newQuantity >=0) {
            this.quantityStock = newQuantity;
        }
    }

    @Override
    public boolean equals(Object obj) {
        //System.out.println("Entering StockItem.equals");
        if(obj == this) {
            return true;
        }

        if((obj == null) || (obj.getClass() != this.getClass())) {
            return false;
        }

        String objName = ((StockItem) obj).getName();
        return this.name.equals(objName);
    }

    @Override
    public int hashCode() {
        return this.name.hashCode() + 31;
    }

    @Override
    public int compareTo(StockItem o) {
        //System.out.println("Entering StockItem.compareTo");
        if(this == o) {
            return 0;
        }

        if(o != null) {
            return this.name.compareTo(o.getName());
        }

        throw new NullPointerException();
    }

    @Override
    public String toString() {
        return this.name + " : price " + String.format("%.2f", this.price);
    }

    public int amountReserved() {
        return this.reserved;
    }

    public void setReserved(int amount) {
        this.reserved = amount;
    }
}
