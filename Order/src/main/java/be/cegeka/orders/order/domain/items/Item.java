package be.cegeka.orders.order.domain.items;

import javax.persistence.*;


@Entity
@Table(name = "ITEMS")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ITEM_ID")
    private int itemId;
    @Column(name = "NAME")
    private String name;
    @Column(name = "DESCRIPTION", columnDefinition = "Text")
    private String text;
    @Column(name = "SELLING_PRICE", columnDefinition = "Decimal(10,2)")
    private double sellingPrice;

    public Item() {
    }

    public Item(String name, String text, double sellingPrice) {
        this.name = name;
        this.text = text;
        this.sellingPrice = sellingPrice;
    }

    public int getItemId() {
        return itemId;
    }

   /* public String getName() {
        return name;
    }

    public String getText() {
        return text;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }*/
}
