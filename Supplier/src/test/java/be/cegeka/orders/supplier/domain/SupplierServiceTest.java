package be.cegeka.orders.supplier.domain;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.mockito.ArgumentMatchers.refEq;
import static org.mockito.Mockito.verify;

public class SupplierServiceTest {
    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @InjectMocks
    private SupplierService supplierService;

    @Mock
    private SupplierRepository supplierRepository;

    @Test
    public void whenPlaceOrderIsCalledSupplierRepositoryPlaceOrderShouldBeCalled() throws Exception {
        supplierService.placeOrder(10,"testitem",50);
        verify(supplierRepository).placeOrder(refEq(new Order(10,"testitem",50), "orderDateTime"));

    }

    @Test
    public void whenGetAllOrdersIsCalledSupplierRepositoryGetAllORdersShouldBeCalled() throws Exception {
        supplierService.getAllOrders();
        verify(supplierRepository).getAllOrders();
    }
}