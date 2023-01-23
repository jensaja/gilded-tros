package com.gildedtros.updater;

import com.gildedtros.Item;

public class WineUpdater extends IncreasingQualityItemUpdater {

    public WineUpdater(Item item) {
        super(item);
    }

    @Override
    public void update() {
        increaseQuality();
        decreaseSellIn();
        if(isSellInDateInPast()) {
            increaseQuality();
        }
    }

}
