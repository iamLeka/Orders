package be.cegeka.orders.order.domain.items;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.MockitoRule;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class ItemServiceTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @InjectMocks
    private ItemService itemService;

    @Mock
    private ItemRepository itemRepository;

    @Test
    public void addItemShouldCallItemRepository() throws Exception {
        Item item1 = new Item("Red Vodka", "Special Vodka", BigDecimal.valueOf(15.00));
        Item item2 = new Item("Blue Vodka", "Special Vodka", BigDecimal.valueOf(15.00));
        List<Item> items = new ArrayList<>();

        items.add(item1);
        items.add(item2);

        itemService.addItem(items);
        verify(itemRepository).addItem(Mockito.refEq(new Item("Red Vodka", "Special Vodka", BigDecimal.valueOf(15.00))));
        verify(itemRepository).addItem(Mockito.refEq(new Item("Blue Vodka", "Special Vodka", BigDecimal.valueOf(15.00))));
    }
}