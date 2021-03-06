package be.cegeka.orders.order.domain.orders;

import be.cegeka.orders.order.domain.items.Item;
import be.cegeka.orders.order.domain.items.ItemDto;
import be.cegeka.orders.order.domain.items.ItemRepository;

import javax.inject.Inject;
import javax.inject.Named;
import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;

@Named
public class OrderItemFactory {

    @Inject
    private ItemRepository itemRepository;

    @Inject
    private SupplierService supplierService;

    public OrderItem makeOrderItemFromDto(ItemDto itemDto) {

        Item item = itemRepository.getItemById(itemDto.getItemId());

        OrderItem orderItem = new OrderItem(item,
                itemDto.getAmount(),
                getShippingDate(item, itemDto.getAmount()),
                getItemGroupPrice(item.getPrice(), itemDto.getAmount())
        );

        checkStockOrder(itemDto);

        return orderItem;
    }

    private LocalDate getShippingDate(Item item, int amount) {
        if (item.getStock() >= amount) {
            return LocalDate.now().plusDays(1);
        } else
            return LocalDate.now().plusWeeks(1);
    }

    private BigDecimal getItemGroupPrice(BigDecimal singlePrice, int amount) {
        return singlePrice.multiply(BigDecimal.valueOf(amount));
    }

    private void checkStockOrder(ItemDto itemDto) {
        Item item = itemRepository.getItemById(itemDto.getItemId());

        if (itemDto.getAmount() <= item.getStock()) {
            item.decreaseStock(itemDto.getAmount());
        } else {
            supplierService.postNewOrder("Itchy butthole", item.getName() + " " + itemDto.getAmount());
        }
    }
}
