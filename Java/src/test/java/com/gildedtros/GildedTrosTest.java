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

    @Test void whenUpdateQualityAndSellInIs0ThenSellInContinuesToDecreaseToNegative() {
        Item testItem = ItemFactory.createTestItemWithZeroSellIn();

        runUpdateQualityForSingleItem(testItem);
        assertEquals(-1, testItem.sellIn);
    }

    @Test
    public void whenUpdateQualityOfGoodWineThenQualityIncreases() {
        Item testWine = ItemFactory.createTestGoodWine();

        runUpdateQualityForSingleItem(testWine);
        assertEquals(ItemFactory.TEST_ITEM_QUALITY + 1, testWine.quality);
    }

    @Test
    public void whenUpdateQualityOfGoodWineAndSellByDateHasPassedThenQualityIncreasesTwiceAsFast() {
        Item testWine = ItemFactory.createTestGoodWine();
        testWine.sellIn = 0;

        runUpdateQualityForSingleItem(testWine);
        assertEquals(ItemFactory.TEST_ITEM_QUALITY + 2, testWine.quality);
    }

    @Test
    public void whenUpdateQualityOfGoodWineThenQualityGetsNoHigherThan50() {
        Item testWine = ItemFactory.createTestGoodWine();
        testWine.quality = 49;

        // first update: quality was 49 --> gets updated to 50
        runUpdateQualityForSingleItem(testWine);
        assertEquals(50, testWine.quality);

        // second update: quality was 50 --> quality doesn't get any higher
        runUpdateQualityForSingleItem(testWine);
        assertEquals(50, testWine.quality);
    }

    @Test
    public void whenUpdateQualityOfGoodWineWithSellIn0ThenQualityRemains50() {
        Item testWine = ItemFactory.createTestGoodWine();
        testWine.sellIn = 0;
        testWine.quality = 50;

        // first update: quality was 49 --> gets updated to 50
        runUpdateQualityForSingleItem(testWine);
        assertEquals(50, testWine.quality);

        // second update: quality was 50 --> quality doesn't get any higher
        runUpdateQualityForSingleItem(testWine);
        assertEquals(50, testWine.quality);
    }

    @Test
    public void whenUpdateQualityOfBDawgKeychainThenNeitherSellInNorQualityGetsChanged() {
        Item testKeychain = ItemFactory.createTestBDawgKeychain();

        runUpdateQualityForSingleItem(testKeychain);
        assertEquals(ItemFactory.TEST_ITEM_SELLIN, testKeychain.sellIn);
        assertEquals(ItemFactory.TEST_ITEM_QUALITY, testKeychain.quality);
    }

    private void runUpdateQualityAndAssertThatQualityHasIncreased(Item testItem, int qualityIncrease) {
        int qualityBeforeUpdate = testItem.quality;
        runUpdateQualityForSingleItem(testItem);
        assertEquals(qualityBeforeUpdate + qualityIncrease, testItem.quality);
    }

    @Test
    public void whenUpdateQualityOfBackstagePassesThenQualityChangesNormallyUpTo11DaysToTheConcert() {
        Item testBackstagePass = ItemFactory.createTestBackstagePass(11);
        runUpdateQualityAndAssertThatQualityHasIncreased(testBackstagePass, 1);
    }

    @Test
    public void whenUpdateQualityOfBackstagePassesThenQualityIncreasesByTwoWhen10DaysOrLessToTheConcert() {
        Item testBackstagePass = ItemFactory.createTestBackstagePass(9);
        runUpdateQualityAndAssertThatQualityHasIncreased(testBackstagePass, 2);
    }

    @Test
    public void whenUpdateQualityOfBackstagePassesThenQualityIncreasesByThreeWhen5DaysOrLessToTheConcert() {
        Item testBackstagePass = ItemFactory.createTestBackstagePass(5);
        runUpdateQualityAndAssertThatQualityHasIncreased(testBackstagePass, 3);
    }

    @Test
    public void whenUpdateQualityOfBackstagePassesThenQualityDropsToZeroAfterConcert() {
        Item testBackstagePass = ItemFactory.createTestBackstagePass(0);

        runUpdateQualityForSingleItem(testBackstagePass);
        assertEquals(0, testBackstagePass.quality);
    }

    @Test
    public void whenUpdateQualityOfSmellyItemThenQualityExpiresTwiceAsFast() {
        Item smellyItem = ItemFactory.createTestSmellyItem();

        runUpdateQualityForSingleItem(smellyItem);
        assertEquals(ItemFactory.TEST_ITEM_QUALITY - 2, smellyItem.quality);
    }

    @Test
    public void whenUpdateQualityOfSmellyItemAndSellInHasPassedThenQualityExpiresFourTimesAsFast() {
        Item smellyItem = ItemFactory.createTestSmellyItem();
        smellyItem.sellIn = 0;

        runUpdateQualityForSingleItem(smellyItem);
        assertEquals(ItemFactory.TEST_ITEM_QUALITY - 4, smellyItem.quality);
    }
}
