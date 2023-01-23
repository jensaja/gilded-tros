package com.gildedtros;

import com.gildedtros.updater.ItemUpdater;
import com.gildedtros.updater.ItemUpdaterFactory;

import java.util.Arrays;

class GildedTros {
    Item[] items;

    public GildedTros(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        Arrays.stream(items)
                .map(ItemUpdaterFactory::getUpdaterForItem)
                .forEach(ItemUpdater::update);
    }

}