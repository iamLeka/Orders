package be.cegeka.orders.order.domain.items;

public class Item {

    private int id;
    private String name;
    private double price;

    public Item(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}