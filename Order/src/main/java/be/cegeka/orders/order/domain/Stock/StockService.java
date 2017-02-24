package be.cegeka.orders.order.domain.Stock;


import be.cegeka.orders.order.domain.items.Item;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class StockService {

    @Inject
    private StockRepository stockRepository;
    private Stock stock;
    private Item item;

    public int getItemQuantity(int quantity) {
        quantity = 0;
        if (stockRepository.getAllStock().contains(item)) {
            quantity++;
        } else {
            stock.addItem(item);
            quantity++;
        }
        return quantity;
    }

    public List<Stock> getAllStock() {
        return
    }
}
