package com.gildedtros.factory;

import com.gildedtros.Item;

public class ItemFactory {

    public static final String TEST_ITEM_NAME = "foo";
    public static final int TEST_ITEM_SELLIN = 5;
    public static final int TEST_ITEM_QUALITY = 20;


    public static Item createTestItem() {
        return new Item(TEST_ITEM_NAME, TEST_ITEM_SELLIN, TEST_ITEM_QUALITY);
    }

    public static Item createTestItemWithZeroQuality() {
        return new Item(TEST_ITEM_NAME, TEST_ITEM_SELLIN, 0);
    }

}
