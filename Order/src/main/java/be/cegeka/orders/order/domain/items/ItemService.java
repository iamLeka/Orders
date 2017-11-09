package be.cegeka.orders.order.domain.items;

import javax.inject.Inject;
import javax.inject.Named;
import java.math.BigDecimal;

@Named
public class ItemService {

    @Inject
    private ItemRepository itemRepository;

    public void addItem(String name, String description, BigDecimal price) {
        itemRepository.addItem(new Item(name, description, price));
    }
}
