package be.cegeka.orders.order.domain.items;

import javax.inject.Inject;
import javax.inject.Named;
import java.math.BigDecimal;

@Named
public class ItemService {

    @Inject
    private ItemRepository itemRepository;

    public void addItem(Item item) {
        itemRepository.addItem(item);
    }
}
