package be.cegeka.orders.supplier.application;

import be.cegeka.orders.supplier.domain.SupplierService;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

public class SupplierControllerTest {
    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @InjectMocks
    private SupplierController supplierController;

    @Mock
    private SupplierService supplierService;

    @Test
    public void whenPlaceOrderIsCalledSupplierServicePlaceOrderShouldBeCalled() throws Exception {
        supplierController.placeOrder(10,"testitem",50);
        Mockito.verify(supplierService).placeOrder(10,"testitem",50);
    }

    @Test
    public void whenGetAllOrdersIsCalledSupplierServiceGetAllOrdersShouldBeCalled() throws Exception {
        supplierController.getAllOrders();
        Mockito.verify(supplierService).getAllOrders();

    }
}