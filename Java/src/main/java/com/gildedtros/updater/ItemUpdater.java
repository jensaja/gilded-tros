package com.gildedtros.updater;

import com.gildedtros.Item;

public abstract class ItemUpdater {

    protected Item item;

    public ItemUpdater(Item item) {
        this.item = item;
    }

    public abstract void update();

    protected void decreaseSellIn() {
        item.sellIn--;
    }

    protected boolean isSellInDateInPast() {
        return item.sellIn < 0;
    }

}
