package be.cegeka.orders.order.domain.stock;

import be.cegeka.orders.order.domain.items.Item;

import javax.persistence.*;

@Entity
@Table(name = "STOCK")
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "STOCK_ID")
    private int stockId;

    @OneToOne(cascade = CascadeType.ALL, targetEntity = Item.class)
    @JoinColumn(name = "ITEM_ID", referencedColumnName = "ITEM_ID")
    private Item item;

    public Stock() {
    }

    public Stock(Item item) {
        this.item = item;
    }

    public int getStockId() {
        return stockId;
    }

    public Item getItem() {
        return item;
    }
}
