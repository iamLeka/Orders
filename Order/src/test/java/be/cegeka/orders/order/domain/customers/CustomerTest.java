package be.cegeka.orders.order.domain.customers;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import static be.cegeka.orders.order.domain.customers.CustomerTestBuilder.aCustomer;
import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.*;

public class CustomerTest {
    private Customer testCustomer;

    @Before
    public void setup(){
        testCustomer = aCustomer()
                .withID(15)
                .withLastName("Babush")
                .withFirstName("Ka")
                .withEmail("omasaandetop@senioren.net")
                .withAddress("home zooeneschein")
                .withPhone("geen, alleen gele briefkaarten")
                .build();

    }

//    @Test
//    public void aCustomer_isNotEqualToNotACustomer() throws Exception {
//
//    }

        @Test
    public void aCustomer_isNotEqualToNotACustomer() throws Exception {
        Assertions.assertThat(testCustomer).isNotEqualTo(new Object());
    }
//
    @Test
    public void aCustomer_isEqualToItself() throws Exception {
        Assertions.assertThat(testCustomer).isEqualTo(testCustomer);
    }
//
    @Test
    public void equals_CustomerWithSameId_isTrue() throws Exception {
        Customer testCustomer2 = aCustomer()
                .withID(15)
                .build();
        assertThat(testCustomer).isEqualTo(testCustomer2);
    }

    @Test
    public void equals_NullObject_isFalse() throws Exception {
        assertThat(testCustomer).isNotEqualTo(null);
    }

    @Test
    public void equals_ObjectWithOtherId_isFalse() throws Exception {
        Customer testCustomer2 = aCustomer()
                .withID(25)
                .build();
        assertThat(testCustomer).isNotEqualTo(testCustomer2);
    }
}