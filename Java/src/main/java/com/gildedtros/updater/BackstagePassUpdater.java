package com.gildedtros.updater;

import com.gildedtros.Item;

public class BackstagePassUpdater extends IncreasingQualityItemUpdater {

    public BackstagePassUpdater(Item item) {
        super(item);
    }

    @Override
    public void update() {
        decreaseSellIn();
        if(isSellInDateInPast()){
            item.quality = 0;
        }
        else {
            increaseQuality();
            if (item.sellIn < 10) {
                increaseQuality();
            }
            if (item.sellIn < 5) {
                increaseQuality();
            }
        }
    }
}
