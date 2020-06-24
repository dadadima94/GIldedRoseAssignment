package com.gildedrose;

class  GildedRose {

    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE_PASS = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            updateSingleItem(item);
        }
    }

    private void updateSingleItem(Item item) {
        updateQualityBeforeSellIn(item);

        decreaseSellIn(item);

        if (hasPassedSellIn(item)) {
            updateQualityAfterSellIn(item);
        }
    }

    private void updateQualityBeforeSellIn(Item item) {
        if (!item.name.equals(AGED_BRIE)
                && !item.name.equals(BACKSTAGE_PASS)) {
            if (item.quality > 0) {
                if (!item.name.equals(SULFURAS)) {
                    item.quality = item.quality - 1;
                }
            }
        } else {
            if (item.quality < 50) {
                item.quality = item.quality + 1;

                if (item.name.equals(BACKSTAGE_PASS)) {
                    if (item.sellIn <= 10) {  // Backstage SellIn Threshold changed to leq
                        if (item.quality < 50) {
                            item.quality = item.quality + 1;  // now a mutation here is covered, was due to Backstage SellIn Thresholds
                        }
                    }

                    if (item.sellIn <= 5) { // Backstage SellIn Threshold changed to leq
                        if (item.quality < 50) {
                            item.quality = item.quality + 1; // now mutation is covered here as well, was due to Backstage SellIn Thresholds
                        }
                    }
                }
            }
        }
    }

    private boolean hasPassedSellIn(Item item) {
        return item.sellIn < 0;
    }

    private void updateQualityAfterSellIn(Item item) {
        if (!item.name.equals(AGED_BRIE)) {
            if (!item.name.equals(BACKSTAGE_PASS)) {
                if (item.quality > 0) {
                    if (!item.name.equals(SULFURAS)) {
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

    private void decreaseSellIn(Item item) {
        if (!item.name.equals(SULFURAS)) {
            item.sellIn = item.sellIn - 1;
        }
    }
}