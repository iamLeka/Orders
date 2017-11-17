package be.cegeka.orders.supplier.domain;

import org.joda.time.LocalDateTime;
import org.springframework.test.util.ReflectionTestUtils;

public class OrderTestBuilder {
    private int id;
    private int customerId;
    private int amount;
    private LocalDateTime orderDateTime;
    private String item;

    public static OrderTestBuilder aOrder() {
        return new OrderTestBuilder()
                .withCustomerId(10)
                .withAmount(5)
                .withOrderDateTime(LocalDateTime.now())
                .withItem("appel");
    }

    public OrderTestBuilder withCustomerId(int customerId) {
        this.customerId = customerId;
        return this;
    }

    public OrderTestBuilder withAmount(int amount) {
        this.amount = amount;
        return this;
    }

    public OrderTestBuilder withOrderDateTime(LocalDateTime orderDateTime) {
        this.orderDateTime = orderDateTime;
        return this;
    }

    public OrderTestBuilder withItem(String item) {
        this.item = item;
        return this;
    }
    public Order build(){
        Order order = new Order(customerId,item,amount);
        ReflectionTestUtils.setField(order, "id", id);
        return order;
    }
}
