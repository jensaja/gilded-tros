package com.gildedtros;

import com.gildedtros.factory.ItemFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedTrosTest {

    private void runUpdateQualityForSingleItem(Item testItem){
        GildedTros app = new GildedTros(new Item[]{testItem});
        app.updateQuality();
    }

    @Test
    public void whenUpdateQualityThenItemsNameDoesntChange() {
        Item testItem = ItemFactory.createTestItem();
        runUpdateQualityForSingleItem(testItem);
        assertEquals(ItemFactory.TEST_ITEM_NAME, testItem.name);
    }

    @Test
    public void whenUpdateQualityThenItemsQualityGetDecreasedBy1() {
        Item testItem = ItemFactory.createTestItem();
        runUpdateQualityForSingleItem(testItem);
        assertEquals(ItemFactory.TEST_ITEM_QUALITY - 1, testItem.quality);
    }

    @Test
    public void whenUpdateQualityThenItemsSellInGetDecreasedBy1() {
        Item testItem = ItemFactory.createTestItem();
        runUpdateQualityForSingleItem(testItem);
        assertEquals(ItemFactory.TEST_ITEM_SELLIN - 1, testItem.sellIn);
    }

    @Test
    public void whenUpdateQualityAndSellByDateHasPassedThenQualityDecreasesTwiceAsFast() {
        Item testItem = ItemFactory.createTestItem();
        testItem.sellIn = 1;

        // first update: sell in 1 day --> normal behaviour: -1
        runUpdateQualityForSingleItem(testItem);
        assertEquals(ItemFactory.TEST_ITEM_QUALITY - 1, testItem.quality);
        int qualityAfterFirstUpdate = testItem.quality;

        // second update: sell in 0 days --> sell by date has passed: quality decreases twice as fast: -2
        runUpdateQualityForSingleItem(testItem);
        assertEquals(qualityAfterFirstUpdate - 2, testItem.quality);
    }

    @Test
    public void whenUpdateQualityThenQualityGetsNeverNegative() {
        Item testItem = ItemFactory.createTestItemWithZeroQuality();

        runUpdateQualityForSingleItem(testItem);
        assertEquals(0, testItem.quality);
    }

    @Test
    public void whenUpdateQualityAndSellInHasPassedThenQualityGetsNeverNegative() {
        Item testItem = ItemFactory.createTestItemWithZeroQuality();
        testItem.sellIn = 0;

        runUpdateQualityForSingleItem(testItem);
        assertEquals(0, testItem.quality);
    }

}
