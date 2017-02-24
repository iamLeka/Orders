package be.cegeka.orders.order.domain.stock;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "STOCK")
public class Stock {

    @Id
    @GeneratedValue
    @Column(name = "STOCK_ID")
    private int stockId;
    @NotNull
    @Column(name = "ITEM_ID")
    @OneToOne(mappedBy = "ITEM_ID")
    private int itemId;


    public Stock(int itemId) {
        this.itemId = itemId;
    }

    public int getStockId() {
        return stockId;
    }


    public int getItemId() {
        return itemId;
    }
}
