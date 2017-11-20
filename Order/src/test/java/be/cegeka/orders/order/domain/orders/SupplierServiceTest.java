package be.cegeka.orders.order.domain.orders;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.springframework.web.client.RestTemplate;

import javax.inject.Inject;

import static org.mockito.Mockito.verify;
import static org.junit.Assert.*;

public class SupplierServiceTest {


    @Rule
    public MockitoRule rule = MockitoJUnit.rule();


    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private SupplierService supplierService;

    @Test
    public void ifNewOrderIsPosted_shouldVerifyTheRestTemplate() throws Exception {
        supplierService.postNewOrder("itchy butthole", "blabla");
        SupplierDto supplierDto =  new SupplierDto("itchy butthole", "blabla");

        verify(restTemplate).postForObject(Mockito.eq("http://CI00026731:9005/orders-1.0.0/supplier"),Mockito.refEq(supplierDto),Mockito.eq(String.class));
    }
}