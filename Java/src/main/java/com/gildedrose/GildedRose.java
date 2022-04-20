package com.gildedrose;

class GildedRose {
    private static final String AGED_BRIE = "Aged Brie";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    private static final String BACKSTAGE_CONCERT = "Backstage passes to a TAFKAL80ETC concert";

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item: items) {
            if (!AGED_BRIE.equals(item.name)
                    && !BACKSTAGE_CONCERT.equals(item.name)) {
                if (item.quality > 0) {
                    if (!SULFURAS.equals(item.name)) {
                        decreaseQuality(item);
                    }
                }
            } else {
                if (item.quality < 50) {
                    increaseQuality(item);

                    if (BACKSTAGE_CONCERT.equals(item.name)) {
                        if (item.sellIn < 11) {
                            increaseQuality(item);
                        }

                        if (item.sellIn < 6) {
                            increaseQuality(item);
                        }
                    }
                }
            }

            if (!SULFURAS.equals(item.name)) {
                item.sellIn = item.sellIn - 1;
            }

            if (item.sellIn < 0) {
                if (!AGED_BRIE.equals(item.name)) {
                    if (!BACKSTAGE_CONCERT.equals(item.name)) {
                        if (item.quality > 0) {
                            if (!item.name.equals(SULFURAS)) {
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

    private void increaseQuality(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }

    private void decreaseQuality(Item item) {
        item.quality = item.quality - 1;
    }
}
