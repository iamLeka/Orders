package be.cegeka.orders.order.application;

import be.cegeka.orders.order.domain.items.Item;
import be.cegeka.orders.order.domain.items.ItemService;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ItemControllerTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @InjectMocks
    private ItemController itemController;

    @Mock
    private ItemService itemService;

    @Test
    public void whenAddingItem_shouldActivateCorrespondingMethod() throws Exception {
        List<Item> items = new ArrayList<>();
        Item item1 = new Item("Red Vodka", "Special Vodka", BigDecimal.valueOf(15.00));
        Item item2 = new Item("Blue Vodka", "Special Vodka", BigDecimal.valueOf(15.00));

        items.add(item1);
        items.add(item2);

        List<Item> expectedItems = itemController.addItem(items);
        verify(itemService).addItem(items);
        when(itemService.addItem(items)).thenReturn(items);
    }
}