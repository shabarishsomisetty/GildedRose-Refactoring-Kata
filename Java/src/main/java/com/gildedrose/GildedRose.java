package com.gildedrose;

class GildedRose {
    private final String agedBrie = "Aged Brie";
    private final String sulfuras = "Sulfuras, Hand of Ragnaros";
    private final String backstageConcert = "Backstage passes to a TAFKAL80ETC concert";

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item: items) {
            if (!agedBrie.equals(item.name)
                    && !backstageConcert.equals(item.name)) {
                if (item.quality > 0) {
                    if (!item.name.equals(sulfuras)) {
                        item.quality = item.quality - 1;
                    }
                }
            } else {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;

                    if (backstageConcert.equals(item.name)) {
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

            if (!sulfuras.equals(item.name)) {
                item.sellIn = item.sellIn - 1;
            }

            if (item.sellIn < 0) {
                if (!agedBrie.equals(item.name)) {
                    if (!backstageConcert.equals(item.name)) {
                        if (item.quality > 0) {
                            if (!item.name.equals(sulfuras)) {
                                item.quality = item.quality - 1;
                            }
                        }
                    } else {
                        item.quality = item.quality - item.quality;
                    }
                } else {
                    if (item.quality < 50) {
                        item.quality = item.quality + 1;
                    }
                }
            }
        }
    }
}
