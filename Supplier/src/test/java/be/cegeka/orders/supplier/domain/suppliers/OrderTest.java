package be.cegeka.orders.supplier.domain.suppliers;

import org.joda.time.DateTime;
import org.junit.Before;

import static be.cegeka.orders.supplier.domain.suppliers.OrderTestBuilder.aOrder;

public class OrderTest {
    private Order testOrder;

    @Before
    public void setUp(){
        testOrder = aOrder()
                .withAmount(5)
                .withCustomerId("Domien")
                .withItem("Appel")
                .withOrderDateTime(DateTime.now())
                .build();
    }


}