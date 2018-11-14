package com.gildedrose;

class ImprovableItem extends InventoryItem {

    static final int MAXIMUM_QUALITY = 50;

    ImprovableItem(final Item item) {
        super(item);
    }

    static InventoryItem of(final Item item) {
        return new ImprovableItem(item);
    }

    @Override
    protected void updateQuality() {
        if (item.quality < MAXIMUM_QUALITY) {
            item.quality = item.quality + 1;
        }
    }
}
