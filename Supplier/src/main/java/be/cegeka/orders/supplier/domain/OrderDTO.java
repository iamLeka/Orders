package be.cegeka.orders.supplier.domain;

import javax.persistence.Column;
import java.sql.Timestamp;

public class OrderDTO {
    private int customerId;
    private String itemName;
    private int amount;

    public OrderDTO() {
    }

    public OrderDTO(int customerId, String itemName, int amount) {
        this.customerId = customerId;
        this.itemName = itemName;
        this.amount = amount;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getItemName() {
        return itemName;
    }

    public int getAmount() {
        return amount;
    }
}
