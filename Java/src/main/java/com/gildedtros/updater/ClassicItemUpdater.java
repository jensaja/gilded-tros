package com.gildedtros.updater;

import com.gildedtros.Item;

public class ClassicItemUpdater extends DecreasingQualityItemUpdater {

    public ClassicItemUpdater(Item item) {
        super(item);
    }

    @Override
    public void update() {
        decreaseQuality();
        decreaseSellIn();
        if (isSellInDateInPast()) {
            decreaseQuality();
        }
    }

}
