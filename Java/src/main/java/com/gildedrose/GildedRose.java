package com.gildedrose;

class GildedRose {
    private static final String AGED_BRIE = "Aged Brie";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    private static final String BACKSTAGE_CONCERT = "Backstage passes to a TAFKAL80ETC concert";
    private static final String CONJURED = "Conjured Mana Cake";

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item: items) {
            decreaseQuality(item, false);
            increaseQuality(item);
            if (BACKSTAGE_CONCERT.equals(item.name)) {
                if (item.sellIn < 11) {
                    increaseQuality(item);
                }
                if (item.sellIn < 6) {
                    increaseQuality(item);
                }
            }

            if (!SULFURAS.equals(item.name)) {
                item.sellIn = item.sellIn - 1;
            }

            if (item.sellIn < 0) {
                decreaseQuality(item, true);
                increaseQuality(item);
            }
        }
    }

    private void increaseQuality(Item item) {
        if(AGED_BRIE.equals(item.name) || BACKSTAGE_CONCERT.equals(item.name)) {
            if (item.quality < 50) {
                item.quality = item.quality + 1;
            }
        }
    }

    private void decreaseQuality(Item item, boolean isSellLessZero) {
        if (item.quality > 0) {
            if (!AGED_BRIE.equals(item.name) && !BACKSTAGE_CONCERT.equals(item.name) && !SULFURAS.equals(item.name)) {
                 if(isSellLessZero) {
                     item.quality = 0;
                 } else {
                     item.quality = item.quality - 1;
                 }
            }
            if(CONJURED.equals(item.name)) {
                item.quality = item.quality - 1;
            }
        }
    }
}
