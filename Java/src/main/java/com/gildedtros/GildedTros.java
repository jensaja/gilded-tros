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
            switch (item.name){
                case "Good Wine":
                    increaseQuality(item);
                    break;
                case "B-DAWG Keychain":
                    break;
                case "Backstage passes for Re:Factor":
                case "Backstage passes for HAXX":
                    increaseQuality(item);
                    if (item.sellIn < 11) {
                        increaseQuality(item);
                    }

                    if (item.sellIn < 6) {
                        increaseQuality(item);
                    }
                    break;
                default:
                    decreaseQuality(item);
            }

            if (!item.name.equals("B-DAWG Keychain")) {
                decreaseSellIn(item);
            }

            if (item.sellIn < 0) {
                switch (item.name) {
                    case "Good Wine":
                        increaseQuality(item);
                        break;
                    case "Backstage passes for Re:Factor":
                    case "Backstage passes for HAXX":
                        item.quality = 0;
                        break;
                    case "B-DAWG Keychain":
                        break;
                    default:
                        decreaseQuality(item);
                }
            }
        }
    }
}