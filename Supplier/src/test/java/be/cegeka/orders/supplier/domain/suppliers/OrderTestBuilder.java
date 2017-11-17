package be.cegeka.orders.supplier.domain.suppliers;

import org.joda.time.DateTime;
import org.springframework.test.util.ReflectionTestUtils;

public class OrderTestBuilder {
    private int id;
    private String customerId;
    private int amount;
    private DateTime orderDateTime;
    private String item;

    public static OrderTestBuilder aOrder() {
        return new OrderTestBuilder()
                .withCustomerId("qdfjhsd")
                .withAmount(5)
                .withOrderDateTime(DateTime.now())
                .withItem("appel");
    }

    public OrderTestBuilder withCustomerId(String customerId) {
        this.customerId = customerId;
        return this;
    }

    public OrderTestBuilder withAmount(int amount) {
        this.amount = amount;
        return this;
    }

    public OrderTestBuilder withOrderDateTime(DateTime orderDateTime) {
        this.orderDateTime = orderDateTime;
        return this;
    }

    public OrderTestBuilder withItem(String item) {
        this.item = item;
        return this;
    }
    public Order build(){
        Order order = new Order(customerId,orderDateTime,item,amount);
        ReflectionTestUtils.setField(order, "id", id);
        return order;
    }
}
