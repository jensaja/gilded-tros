package com.gildedtros.factory;

import com.gildedtros.Item;

public class ItemFactory {

    public static final String TEST_ITEM_NAME = "foo";
    public static final int TEST_ITEM_SELLIN = 5;
    public static final int TEST_ITEM_QUALITY = 20;
    private static final String GOOD_WINE_NAME = "Good Wine";
    private static final String B_DAWG_KEYCHAIN_NAME = "B-DAWG Keychain";
    private static final String BACKSTAGE_PASS_NAME = "Backstage passes for Re:Factor";
    private static final String SMELLY_ITEM_NAME = "Duplicate Code";


    public static Item createTestItem() {
        return new Item(TEST_ITEM_NAME, TEST_ITEM_SELLIN, TEST_ITEM_QUALITY);
    }

    public static Item createTestItemWithZeroQuality() {
        return new Item(TEST_ITEM_NAME, TEST_ITEM_SELLIN, 0);
    }

    public static Item createTestItemWithZeroSellIn() {
        return new Item(TEST_ITEM_NAME, 0, TEST_ITEM_QUALITY);
    }

    public static Item createTestGoodWine() {
        return new Item(GOOD_WINE_NAME, TEST_ITEM_SELLIN, TEST_ITEM_QUALITY);
    }

    public static Item createTestBDawgKeychain() {
        return new Item(B_DAWG_KEYCHAIN_NAME, TEST_ITEM_SELLIN, TEST_ITEM_QUALITY);
    }

    public static Item createTestBackstagePass(int daysToConcert) {
        return new Item(BACKSTAGE_PASS_NAME, daysToConcert, TEST_ITEM_QUALITY);
    }

    public static Item createTestSmellyItem() {
        return new Item(SMELLY_ITEM_NAME, TEST_ITEM_SELLIN, TEST_ITEM_QUALITY);
    }

}
