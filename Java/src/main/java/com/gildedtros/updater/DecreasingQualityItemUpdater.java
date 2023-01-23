package com.gildedtros.updater;

import com.gildedtros.Item;

public abstract class DecreasingQualityItemUpdater extends ItemUpdater {

    public DecreasingQualityItemUpdater(Item item) {
        super(item);
    }

    protected void decreaseQuality() {
        if (item.quality > 0) {
            item.quality--;
        }
    }

}
