package be.cegeka.orders.order.application;

import be.cegeka.orders.order.domain.items.ItemService;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.math.BigDecimal;

@RestController
@RequestMapping(path = "/item")
@Transactional
public class ItemController {

    private ItemService itemService;

    @PostMapping(path = "/add")
    public void addItem(
            @RequestParam(value = "name", required = true) String name,
            @RequestParam(value = "description", required = true) String description,
            @RequestParam(value = "price", required = true) BigDecimal price) {

        itemService.addItem(name, description, price);
    }

}
