package com.gildedrose;

public class TextTestFixture {

    public static void main(String[] args) {
        final Inventory inventory = Inventory.of(
                Item.of("+5 Dexterity Vest", 10, 20),
                Item.of("Aged Brie", 2, 0),
                Item.of("Elixir of the Mongoose", 5, 7),
                Item.of("Sulfuras, Hand of Ragnaros", 0, 80),
                Item.of("Sulfuras, Hand of Ragnaros", -1, 80),
                Item.of("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                Item.of("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                Item.of("Backstage passes to a TAFKAL80ETC concert", 5, 49),
                Item.of("Conjured Mana Cake", 3, 6)
        );

        final GildedRose gilded = new GildedRose(inventory);

        int days = 2;
        if (args.length > 0) {
            days = Integer.parseInt(args[0]) + 1;
        }

        for (int i = 0; i < days; i++) {
            System.out.println("-------- day " + i + " --------");
            System.out.println("name, sellIn, quality");

            for (final Item item : inventory.getItems()) {
                System.out.println(item);
            }

            System.out.println();
            gilded.updateInventory();
        }
    }
}
