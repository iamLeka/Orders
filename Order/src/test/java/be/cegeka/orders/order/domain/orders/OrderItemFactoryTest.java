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

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class OrderItemFactoryTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Mock
    private ItemRepository itemRepository;

    @Mock
    private SupplierService supplierService;

    @InjectMocks
    private OrderItemFactory orderItemFactory;

    @Test
    public void givenItemDto_ShouldReturnOrderItem() throws Exception {
        //GIVEN
        ItemDto itemDto = new ItemDto(1, 5);
        Item item = new Item("Bier", "Jammie", BigDecimal.valueOf(2));

        //WHEN
        when(itemRepository.getItemById(1)).thenReturn(item);

        OrderItem actualOrderItem = orderItemFactory.makeOrderItemFromDto(itemDto);
        OrderItem expectedOrderItem = new OrderItem(item, 5, LocalDate.now().plusWeeks(1), BigDecimal.valueOf(10));

        //THEN
        Assertions.assertThat(actualOrderItem).isEqualToComparingFieldByField(expectedOrderItem);
    }

    @Test
    public void ifItemInStock_shouldReturnCurrentDatePlusOne() throws Exception {
        ItemDto itemDto = new ItemDto(1, 4);
        Item item = new Item(1, "bier", "lekker", BigDecimal.valueOf(1), 5);
        when(itemRepository.getItemById(1)).thenReturn(item);

        OrderItem actualOrderItem = (orderItemFactory.makeOrderItemFromDto(itemDto));
        OrderItem expectedOrderItem = (new OrderItem(item, 4, LocalDate.now().plusDays(1), BigDecimal.valueOf(4)));

        Assertions.assertThat(actualOrderItem.getShippingDate()).isEqualTo(expectedOrderItem.getShippingDate());
    }


    @Test
    public void ifItemNotInStock_shouldReturnCurrentDatePlusSeven() throws Exception {
        ItemDto itemDto = new ItemDto(1, 8);
        Item item = new Item(1, "bier", "lekker", BigDecimal.valueOf(1), 5);
        when(itemRepository.getItemById(1)).thenReturn(item);

        OrderItem actualOrderItem = (orderItemFactory.makeOrderItemFromDto(itemDto));
        OrderItem expectedOrderItem = (new OrderItem(item, 8, LocalDate.now().plusDays(7), BigDecimal.valueOf(4)));

        Assertions.assertThat(actualOrderItem.getShippingDate()).isEqualTo(expectedOrderItem.getShippingDate());
    }

    @Test
    public void IfOrderedProductInStock_ShouldDecreaseWithOrderAmount() throws Exception {
        ItemDto itemDto = new ItemDto(1, 3);
        Item item = new Item(1, "bier", "lekker", BigDecimal.valueOf(1), 5);
        when(itemRepository.getItemById(1)).thenReturn(item);

        orderItemFactory.makeOrderItemFromDto(itemDto);
        int expectedAmount = 2;
        int actualAmount = item.getStock();

        Assertions.assertThat(expectedAmount).isEqualTo(actualAmount);
    }

    @Test
    public void IfOrderedProductNotInStock_ShouldPlaceOrderWithSupplier() throws Exception {
        ItemDto itemDto = new ItemDto(1, 3);
        Item item = new Item(1, "bier", "lekker", BigDecimal.valueOf(1), 5);
        when(itemRepository.getItemById(1)).thenReturn(item);

        verify(supplierService).postNewOrder("Itchy butthole", item.getName() + " " + itemDto.getAmount());
        //check if order is placed with supplier
    }


}