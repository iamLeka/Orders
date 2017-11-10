package be.cegeka.orders.order.domain.items;

import javax.inject.Inject;
import javax.inject.Named;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Named
public class ItemService {

    @Inject
    private ItemRepository itemRepository;

    public List<Item> addItem(List<Item> items) {
        List<Item> persistedItems = items.stream()
                .map(item -> itemRepository.addItem(item))
                .collect(Collectors.toList());

        return persistedItems;
    }
}
