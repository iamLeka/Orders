package be.cegeka.orders.order.application;

import be.cegeka.orders.order.domain.items.Item;
import be.cegeka.orders.order.domain.items.ItemService;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.math.BigDecimal;

@RestController
@RequestMapping(path = "/item")
@Transactional
public class ItemController {

    @Inject
    private ItemService itemService;

    @PostMapping(consumes = "application/json", produces = "application/json")
    public Item addItem(@RequestBody Item item) {
        itemService.addItem(item);
        return item;
    }
}
