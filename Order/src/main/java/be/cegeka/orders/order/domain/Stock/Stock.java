package be.cegeka.orders.order.domain.Stock;

import be.cegeka.orders.order.domain.items.Item;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.ALL;

@Entity
@Table(name = "Stock")
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "STOCK_ID")
    private int id;

    @OneToOne(cascade = ALL)
    @JoinColumn(name = "ITEM_ID" )
//    @JoinTable(
//            name = "Stock",
//            joinColumns = {@JoinColumn(name = "STOCK_ID")},
//            inverseJoinColumns = {@JoinColumn(name = "ITEM_ID")})
    private Item item;

    public Stock() {
    }

    public int getId() {
        return id;
    }

    public void addItem(Item item) {
        this.item = item;
    }

//    public List<Item> getItems() {
//        return items;
//    }
}
