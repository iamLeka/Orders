package be.cegeka.orders.order.domain.orders;

public class SupplierDto {

    private String consumername;
    private String details_of_order;

    public SupplierDto(String consumername, String details_of_order) {
        this.consumername = consumername;
        this.details_of_order = details_of_order;
    }

    public String getConsumername() {
        return consumername;
    }

    public String getDetails_of_order() {
        return details_of_order;
    }
}

