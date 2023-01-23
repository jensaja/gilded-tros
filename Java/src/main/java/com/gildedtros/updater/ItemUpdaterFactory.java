package com.gildedtros.updater;

import com.gildedtros.Item;

import java.util.Map;
import java.util.function.Function;

public class ItemUpdaterFactory {

    private static final Map<String, Function<Item, ItemUpdater>> updatersForName = Map.of(
         "Good Wine", WineUpdater::new,
         "B-DAWG Keychain", LegendaryItemUpdater::new,
         "Backstage passes for Re:Factor", BackstagePassUpdater::new,
         "Backstage passes for HAXX", BackstagePassUpdater::new,
         "Duplicate Code", SmellyItemUpdater::new,
         "Long Methods", SmellyItemUpdater::new,
         "Ugly Variable Names", SmellyItemUpdater::new
    );

    public static ItemUpdater getUpdaterForItem(Item item) {
        return updatersForName
                .getOrDefault(item.name, ClassicItemUpdater::new)
                .apply(item);
    }

}
