package com.gildedtros.updater;

import com.gildedtros.Item;

public abstract class IncreasingQualityItemUpdater extends ItemUpdater {

    public IncreasingQualityItemUpdater(Item item) {
        super(item);
    }

    protected void increaseQuality() {
        if (item.quality < 50) {
            item.quality++;
        }
    }

}
