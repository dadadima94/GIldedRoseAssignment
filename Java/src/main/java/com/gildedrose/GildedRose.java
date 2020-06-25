package com.gildedrose;

class GildedRose {

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
        switch (item.name) {
            case AGED_BRIE:
                increaseQualityByOne(item);
                break;
            case BACKSTAGE_PASS:
                increaseQualityByOne(item);

                if (item.sellIn <= 10) {  // Backstage SellIn Threshold changed to leq
                    increaseQualityByOne(item);
                }

                if (item.sellIn <= 5) { // Backstage SellIn Threshold changed to leq
                    increaseQualityByOne(item);
                }
                break;
            case SULFURAS:
                break;
            default:
                decreaseQualityByOne(item);
                break;
        }
    }

    private void updateQualityAfterSellIn(Item item) {
        switch (item.name) {
            case AGED_BRIE:
                increaseQualityByOne(item);
                break;
            case BACKSTAGE_PASS:
                item.quality = 0;
                break;
            case SULFURAS:
                break;
            default:
                decreaseQualityByOne(item);
                break;
        }
    }

    private boolean hasPassedSellIn(Item item) {
        return item.sellIn < 0;
    }

    private void decreaseSellIn(Item item) {
        if (!item.name.equals(SULFURAS)) {
            item.sellIn = item.sellIn - 1;
        }
    }

    private void increaseQualityByOne(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }

    private void decreaseQualityByOne(Item item) {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
    }
}