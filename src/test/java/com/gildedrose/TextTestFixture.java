package com.gildedrose;

public class TextTestFixture {
    public static void main(String[] args) {
        System.out.println("OMGHAI!");

        InventoryItem[] items = new InventoryItem[]{
                InventoryItem.of(new Item("+5 Dexterity Vest", 10, 20)),
                InventoryItem.of(new Item("Aged Brie", 2, 0)),
                InventoryItem.of(new Item("Elixir of the Mongoose", 5, 7)),
                InventoryItem.of(new Item("Sulfuras, Hand of Ragnaros", 0, 80)),
                InventoryItem.of(new Item("Sulfuras, Hand of Ragnaros", -1, 80)),
                InventoryItem.of(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20)),
                InventoryItem.of(new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49)),
                InventoryItem.of(new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49)),
                // this conjured item does not work properly yet
                InventoryItem.of(new Item("Conjured Mana Cake", 3, 6))
        };

        GildedRose app = GildedRose.of(items);

        int days = 2;
        if (args.length > 0) {
            days = Integer.parseInt(args[0]) + 1;
        }

        for (int i = 0; i < days; i++) {
            System.out.println("-------- day " + i + " --------");
            System.out.println("name, sellIn, quality");
            for (InventoryItem item : items) {
                System.out.println(item);
            }
            System.out.println();
            app.updateQuality();
        }
    }

}
