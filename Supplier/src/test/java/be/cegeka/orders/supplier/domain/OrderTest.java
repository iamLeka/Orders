package be.cegeka.orders.supplier.domain;

import org.joda.time.DateTime;
import org.joda.time.LocalDateTime;
import org.junit.Before;

import static be.cegeka.orders.supplier.domain.OrderTestBuilder.aOrder;

public class OrderTest {
    private Order testOrder;

    @Before
    public void setUp(){
        testOrder = aOrder()
                .withAmount(5)
                .withCustomerId(10)
                .withItem("Appel")
                .withOrderDateTime(LocalDateTime.now())
                .build();
    }


}