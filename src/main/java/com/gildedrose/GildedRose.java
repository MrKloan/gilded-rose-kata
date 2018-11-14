package com.gildedrose;

class GildedRose {

    private final InventoryItem[] inventoryItems;

    private GildedRose(final InventoryItem[] inventoryItems) {
        this.inventoryItems = inventoryItems;
    }

    static GildedRose of(final InventoryItem... inventoryItems) {
        return new GildedRose(inventoryItems);
    }

    void updateQuality() {
        for (final InventoryItem item : inventoryItems) {
            update(item.item);
        }
    }

    private void update(final Item item) {
        if (!item.name.equals("Aged Brie")
                && !item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            if (item.quality > 0) {
                if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                    item.quality = item.quality - 1;
                }
            }
        } else {
            if (item.quality < 50) {
                item.quality = item.quality + 1;

                if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    if (item.sellIn < 11) {
                        if (item.quality < 50) {
                            item.quality = item.quality + 1;
                        }
                    }

                    if (item.sellIn < 6) {
                        if (item.quality < 50) {
                            item.quality = item.quality + 1;
                        }
                    }
                }
            }
        }

        if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
            item.sellIn = item.sellIn - 1;
        }

        if (item.sellIn < 0) {
            if (!item.name.equals("Aged Brie")) {
                if (!item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    if (item.quality > 0) {
                        if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                            item.quality = item.quality - 1;
                        }
                    }
                } else {
                    item.quality = 0;
                }
            } else {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;
                }
            }
        }
    }

    int getItemQuality(final int itemIndex) {
        return inventoryItems[itemIndex].getQuality();
    }

    int getItemSellIn(final int itemIndex) {
        return inventoryItems[itemIndex].getSellIn();
    }
}