package be.cegeka.orders.order.domain.orders;

import org.junit.Test;

import java.sql.Date;
import java.time.LocalDate;

import static org.junit.Assert.*;

public class OrderTest {
    @Test
    public void createOrderShouldCreateNewOrder() throws Exception {
        
        Order testOrder=new Order(Date.valueOf(LocalDate.now()),)
    }
}