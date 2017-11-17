package be.cegeka.orders.supplier.application;

import be.cegeka.orders.supplier.domain.SupplierService;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.transaction.Transactional;

@RestController
@RequestMapping(path = "/supplier")
@Transactional
public class SupplierController {
    @Inject
    private SupplierService supplierService;
    //change to json
    @PostMapping
    public void placeOrder(
            @RequestParam(value = "customerid", required = true) int customerId,
            @RequestParam(value = "item", required = true) String item,
            @RequestParam(value = "amount", required = true) int amount) {
        supplierService.placeOrder(customerId, item, amount);
    }

    @GetMapping
    public void getAllOrders(){
        supplierService.getAllOrders();
    }
}
