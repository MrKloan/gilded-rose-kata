package com.gildedrose;

class ImprovableItem extends InventoryItem {

    private static final int MAXIMUM_QUALITY = 50;

    private ImprovableItem(final Item item) {
        super(item);
    }

    static InventoryItem of(final Item item) {
        return new ImprovableItem(item);
    }

    @Override
    protected void updateQuality() {
        if (item.quality >= MAXIMUM_QUALITY)
            return;

        item.quality = item.quality + 1;

        if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            if (item.sellIn < 11)
                if (item.quality < MAXIMUM_QUALITY)
                    item.quality = item.quality + 1;
            if (item.sellIn < 6)
                if (item.quality < MAXIMUM_QUALITY)
                    item.quality = item.quality + 1;
        }
    }

    @Override
    protected void updateSellIn() {
        item.sellIn = item.sellIn - 1;

        if (item.sellIn >= SELLIN_THRESHOLD)
            return;

        if (item.name.equals("Aged Brie")) {
            if (item.quality < MAXIMUM_QUALITY)
                item.quality = item.quality + 1;
        }

        if (item.name.equals("Backstage passes to a TAFKAL80ETC concert"))
            item.quality = MINIMUM_QUALITY;
    }
}
