package be.cegeka.orders.order.application;

import be.cegeka.orders.order.domain.items.ItemService;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.math.BigDecimal;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;

public class ItemControllerTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @InjectMocks
    private ItemController itemController;

    @Mock
    private ItemService itemService;

    @Test
    public void whenAddingItem_shouldActivateCorrespondingMethod() throws Exception {
        itemController.addItem("Red Vodka", "Special Vodka", 15.00);
        verify(itemService).addItem("Red Vodka", "Special Vodka", BigDecimal.valueOf(15.00));
    }
}