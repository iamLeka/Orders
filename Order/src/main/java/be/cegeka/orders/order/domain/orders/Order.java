package be.cegeka.orders.order.domain.orders;

import be.cegeka.orders.order.domain.customers.Customer;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "Orders")
public class Order {

    @Id
    //@GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "ORDER_ID")
    private int id;
    @Column (name = "ORDER_DATE")
    private Date orderDate;

   public Order(){

    }

    public Order ( Date orderDate){
        this.orderDate = orderDate;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        return id == order.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    public int getOrderId() {
        return id;

    }

}
