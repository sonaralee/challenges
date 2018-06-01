package com.maps;

public class Main {
    private static StockList stockList = new StockList();

    public static void main(String[] args) {
        StockItem temp = new StockItem("bread", 0.86, 100);
        stockList.addStock(temp);

        temp = new StockItem("cake", 1.10, 7);
        stockList.addStock(temp);

        temp = new StockItem("car", 12.50, 3);
        stockList.addStock(temp);

        temp = new StockItem("chair", 62.0, 10);
        stockList.addStock(temp);

        temp = new StockItem("cup", 0.50, 200);
        stockList.addStock(temp);
        temp = new StockItem("cup",0.45, 7);
        stockList.addStock(temp);

        temp = new StockItem("door", 72.95, 4);
        stockList.addStock(temp);

        temp = new StockItem("juice", 2.50, 36);
        stockList.addStock(temp);

        temp = new StockItem("phone", 96.99, 35);
        stockList.addStock(temp);

        temp = new StockItem("towel", 2.40, 80);
        stockList.addStock(temp);

        temp = new StockItem("vase", 8.76, 40);
        stockList.addStock(temp);

        System.out.println(stockList);

        Basket emmaBasket = new Basket("Emma");
        fillBasket(emmaBasket, "car", 1);
        System.out.println("\nStock list after reserving car: ");
        System.out.println(stockList);

        emmaBasket.removeFromBasket(stockList.get("car"), 1);
        System.out.println("\nStock list after unreserving car: ");
        System.out.println(stockList);


        fillBasket(emmaBasket, "juice", 4);
        fillBasket(emmaBasket, "bread", 1);
//        sellItem(emmaBasket, "car", 1);
        System.out.println(emmaBasket);

        System.out.println(stockList);
        emmaBasket.checkOut();

        System.out.println(emmaBasket);
//
//        sellItem(emmaBasket, "car", 1);
//        sellItem(emmaBasket, "car", 1);
//        System.out.println(emmaBasket);
//
//        sellItem(emmaBasket, "car", 1);
//        sellItem(emmaBasket, "spanner", 5);
//        System.out.println(emmaBasket);
//
//        sellItem(emmaBasket, "juice", 4);
//        sellItem(emmaBasket, "cup", 12);
//        sellItem(emmaBasket, "bread", 1);
//        System.out.println(emmaBasket);
//
        System.out.println(stockList);
//
//        System.out.println(stockList);
//        for(Map.Entry<String, Double> price: stockList.PriceList().entrySet()) {
//            System.out.println(price.getKey() + " costs" + price.getValue());
//        }
    }

    private static int fillBasket(Basket b, String i, int q) {
        StockItem item = stockList.get(i);
        if(item == null) {
            System.out.println("We don't sell " + i);
            return 0;
        }
        if(item.quantityInStock() > 0) {
            b.addToBasket(item, q);
            return q;
        }
        System.out.println("There are no more " + i + "s in stock");
        return 0;
    }
}
