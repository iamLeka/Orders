package be.cegeka.orders.order.domain.items;

public class ItemDto {
    private int itemId;
    private int amount;

    public ItemDto() {
    }

    public ItemDto(int itemId, int amount) {
        this.itemId = itemId;
        this.amount = amount;
    }

    public int getItemId() {
        return itemId;
    }

    public int getAmount() {
        return amount;
    }
}
