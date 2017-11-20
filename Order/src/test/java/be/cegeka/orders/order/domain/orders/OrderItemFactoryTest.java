package be.cegeka.orders.order.domain.orders;

import be.cegeka.orders.order.domain.items.Item;
import be.cegeka.orders.order.domain.items.ItemDto;
import be.cegeka.orders.order.domain.items.ItemRepository;
import org.assertj.core.api.Assertions;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.refEq;
import static org.mockito.Mockito.when;

public class OrderItemFactoryTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Mock
    private ItemRepository itemRepository;

    @InjectMocks
    private OrderItemFactory orderItemFactory;

    @Test
    public void givenItemDto_ShouldReturnOrderItem() throws Exception {
        //GIVEN
        ItemDto itemDto = new ItemDto(1,5);
        Item item = new Item("Bier","Jammie", BigDecimal.valueOf(2));

        //WHEN
        when(itemRepository.getItemById(1)).thenReturn(item);

        OrderItem actualOrderItem = orderItemFactory.makeOrderItemFromDto(itemDto);
        OrderItem expectedOrderItem = new OrderItem(item,5, LocalDate.now().plusWeeks(1),BigDecimal.valueOf(10));

        //THEN
        Assertions.assertThat(actualOrderItem).isEqualToComparingFieldByField(expectedOrderItem);
    }
}