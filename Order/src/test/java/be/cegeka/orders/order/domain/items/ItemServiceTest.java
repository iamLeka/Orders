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

import static org.junit.Assert.*;
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
        Item item = new Item("Shizzle", "Something suspicious", BigDecimal.valueOf(100.5));
        itemService.addItem(item);
        verify(itemRepository).addItem(Mockito.refEq(new Item("Shizzle", "Something suspicious", BigDecimal.valueOf(100.5))));
    }
}