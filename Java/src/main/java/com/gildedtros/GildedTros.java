package com.gildedtros;

class GildedTros {
    Item[] items;

    public GildedTros(Item[] items) {
        this.items = items;
    }

    private void decreaseQuality(Item item) {
        if (item.quality > 0) {
            item.quality--;
        }
    }

    private void increaseQuality(Item item) {
        if (item.quality < 50) {
            item.quality++;
        }
    }

    private void decreaseSellIn(Item item) {
        item.sellIn--;
    }

    public void updateQuality() {
        for (Item item : items) {
            if (!item.name.equals("Good Wine")
                    && !item.name.equals("Backstage passes for Re:Factor")
                    && !item.name.equals("Backstage passes for HAXX"))
            {
                if (!item.name.equals("B-DAWG Keychain")) {
                    decreaseQuality(item);
                }
            } else {
                increaseQuality(item);

                if (item.name.equals("Backstage passes for Re:Factor") || item.name.equals("Backstage passes for HAXX") ) {
                    if (item.sellIn < 11) {
                        increaseQuality(item);
                    }

                    if (item.sellIn < 6) {
                        increaseQuality(item);
                    }
                }
            }

            if (!item.name.equals("B-DAWG Keychain")) {
                decreaseSellIn(item);
            }

            if (item.sellIn < 0) {
                if (!item.name.equals("Good Wine")) {
                    if (!item.name.equals("Backstage passes for Re:Factor") && !item.name.equals("Backstage passes for HAXX")) {
                        if (item.quality > 0) {
                            if (!item.name.equals("B-DAWG Keychain")) {
                                decreaseQuality(item);
                            }
                        }
                    } else {
                        item.quality = 0;
                    }
                } else {
                    increaseQuality(item);
                }
            }
        }
    }
}