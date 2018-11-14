package com.gildedrose;

class ConjuredItem extends InventoryItem {

    private ConjuredItem(final Item item) {
        super(item);
    }

    static InventoryItem of(final Item item) {
        return new ConjuredItem(item);
    }

    @Override
    protected void updateQuality() {
        super.updateQuality();
        super.updateQuality();
    }
}
