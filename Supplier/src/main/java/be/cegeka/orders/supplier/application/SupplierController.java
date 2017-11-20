package be.cegeka.orders.supplier.application;

import be.cegeka.orders.supplier.domain.Order;
import be.cegeka.orders.supplier.domain.OrderDTO;
import be.cegeka.orders.supplier.domain.SupplierService;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping(path = "/supplier")
@Transactional
public class SupplierController {
    @Inject
    private SupplierService supplierService;

    //change to json
    @PostMapping(consumes = "application/json")
    public Order placeOrder(
            @RequestBody OrderDTO orderDTO
//            @RequestParam(value = "customerid", required = true) int customerId,
//            @RequestParam(value = "item", required = true) String item,
//            @RequestParam(value = "amount", required = true) int amount
    ) {
        return supplierService.placeOrder(orderDTO);
    }

    @GetMapping
    public List<Order> getAllOrders() {
        return supplierService.getAllOrders();
    }
}
