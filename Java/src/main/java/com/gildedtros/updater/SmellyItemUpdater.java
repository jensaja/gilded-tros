package com.gildedtros.updater;

import com.gildedtros.Item;

public class SmellyItemUpdater extends DecreasingQualityItemUpdater {

    public SmellyItemUpdater(Item item) {
        super(item);
    }

    @Override
    public void update() {
        decreaseQuality(2);
        decreaseSellIn();
        if (isSellInDateInPast()) {
            decreaseQuality(2);
        }
    }

}
