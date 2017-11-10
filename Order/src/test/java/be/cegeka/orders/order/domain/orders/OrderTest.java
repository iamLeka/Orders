package be.cegeka.orders.order.domain.orders;

import be.cegeka.orders.order.domain.customers.Customer;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.sql.Date;
import java.time.LocalDate;

import static org.junit.Assert.*;

public class OrderTest {
    @Test
    public void createOrderShouldCreateNewOrder() throws Exception {
        Order testOrder = new Order(Date.valueOf(LocalDate.now()));
        Assertions.assertThat(testOrder.getOrder_date()).isEqualTo(Date.valueOf(LocalDate.now()));
    }
}