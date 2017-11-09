package be.cegeka.orders.order.domain.items;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.*;

public class ItemTest {

    @Test
    public void checkIfCreatedItemNameEqualsToTheCreatedName() throws Exception {
        Item item = new Item("Vodka","A strong beverage", BigDecimal.valueOf(10.5));
        String expected = "Vodka";
        assertThat(item.getName()).isEqualTo(expected);
    }

    @Test
    public void checkifCreatedDescriptionCanBeReturnedFromTheItem() throws Exception {
        Item item = new Item("Vodka","A strong beverage", BigDecimal.valueOf(10.5));
        String expected = "A strong beverage";
        assertThat(item.getDescription()).isEqualTo(expected);
    }

    @Test
    public void checkifCreatedPriceReturnsPrice() throws Exception {
        Item item = new Item("Vodka","A strong beverage", BigDecimal.valueOf(10.5));
        BigDecimal expected = BigDecimal.valueOf(10.5);
        assertThat(item.getPrice()).isEqualTo(expected);
    }
}