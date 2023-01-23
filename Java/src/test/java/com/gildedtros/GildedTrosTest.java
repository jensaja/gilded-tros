package com.gildedtros;

import com.gildedtros.factory.ItemFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedTrosTest {

    @Test
    void whenUpdateQualityThenItemsNameDoesntChange() {
        GildedTros app = new GildedTros(new Item[]{ItemFactory.createTestItem()});
        app.updateQuality();
        assertEquals(ItemFactory.TEST_ITEM_NAME, app.items[0].name);
    }

}
