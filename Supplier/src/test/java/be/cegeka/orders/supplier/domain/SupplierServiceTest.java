package be.cegeka.orders.supplier.domain;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import javax.inject.Inject;

import static org.mockito.ArgumentMatchers.refEq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class SupplierServiceTest {
    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @InjectMocks
    private SupplierService supplierService;

    @Mock
    private SupplierRepository supplierRepository;

    @Mock
    private OrderMapper orderMapper;

    @Test
    public void whenPlaceOrderIsCalledSupplierRepositoryPlaceOrderShouldBeCalled() throws Exception {
        OrderDTO orderdto=new OrderDTO(10,"testitem",50);
        Order order= orderMapper.makeOrderFromOrderDTO(orderdto);
        when(supplierService.placeOrder(orderdto)).thenReturn(order);
        supplierService.placeOrder(orderdto);
        verify(supplierRepository).placeOrder(order);

    }

    @Test
    public void whenGetAllOrdersIsCalledSupplierRepositoryGetAllORdersShouldBeCalled() throws Exception {
        supplierService.getAllOrders();
        verify(supplierRepository).getAllOrders();
    }
}