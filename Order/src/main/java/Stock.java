import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by kevinbi on 23/02/2017.
 */
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
