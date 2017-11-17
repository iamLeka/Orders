package be.cegeka.orders.supplier.domain;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class SupplierService {
    @Inject
    private SupplierRepository supplierRepository;
    public void placeOrder(int customerId, String item, int amount) {
        supplierRepository.placeOrder(new Order(customerId,item,amount));

    }

    public List<Order> getAllOrders() {
        return supplierRepository.getAllOrders();
    }
}
