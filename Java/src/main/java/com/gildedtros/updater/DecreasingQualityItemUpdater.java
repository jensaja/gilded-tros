package com.gildedtros.updater;

import com.gildedtros.Item;

public abstract class DecreasingQualityItemUpdater extends ItemUpdater {

    public DecreasingQualityItemUpdater(Item item) {
        super(item);
    }

    protected void decreaseQuality() {
        decreaseQuality(1);
    }

    protected void decreaseQuality(int amount){
        item.quality = Math.max(0, item.quality - amount);
    }

}
