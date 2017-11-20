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
        Order order=new Order(10,"testitem",50);
        supplierService.placeOrder(order);
        verify(supplierRepository).placeOrder(refEq(order));

    }

    @Test
    public void whenGetAllOrdersIsCalledSupplierRepositoryGetAllORdersShouldBeCalled() throws Exception {
        supplierService.getAllOrders();
        verify(supplierRepository).getAllOrders();
    }
}