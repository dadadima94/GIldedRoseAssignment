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
            ItemType itemType = getItemType(item);
            itemType.updateSingleItem(item, this);
        }
    }

    private ItemType getItemType(Item item) {
        if (item.name.equals(SULFURAS)) {
            return new LegendaryItem();
        }
        if (item.name.equals(AGED_BRIE)) {
            return new AgedBrie();
        }
        if (item.name.equals(BACKSTAGE_PASS)) {
            return new BackstagePass();
        }
        return new ItemType();
    }

    private boolean hasPassedSellIn(Item item) {
        return item.sellIn < 0;
    }

    private class ItemType {

        protected void decreaseQualityByOne(Item item) {
            if (item.quality > 0) {
                item.quality = item.quality - 1;
            }
        }

        protected void increaseQualityByOne(Item item) {
            if (item.quality < 50) {
                item.quality = item.quality + 1;
            }
        }

        protected void updateQualityAfterSellIn(Item item) {
            decreaseQualityByOne(item);
        }

        protected void decreaseSellIn(Item item) {
            item.sellIn = item.sellIn - 1;
        }

        protected void updateQualityBeforeSellIn(Item item) {
            decreaseQualityByOne(item);
        }

        protected void updateSingleItem(Item item, GildedRose gildedRose) {
            updateQualityBeforeSellIn(item);

            decreaseSellIn(item);

            if (gildedRose.hasPassedSellIn(item)) {
                updateQualityAfterSellIn(item);
            }
        }
    }

    private class LegendaryItem extends ItemType {
        protected void updateQualityAfterSellIn(Item item) {
        }

        protected void decreaseSellIn(Item item) {
        }

        protected void updateQualityBeforeSellIn(Item item) {
        }
    }

    private class AgedBrie extends ItemType {
        protected void updateQualityAfterSellIn(Item item) {
            increaseQualityByOne(item);
        }

        protected void updateQualityBeforeSellIn(Item item) {
            increaseQualityByOne(item);
        }

    }

    private class BackstagePass extends ItemType {

        protected void updateQualityAfterSellIn(Item item) {
            item.quality = 0;
        }

        protected void updateQualityBeforeSellIn(Item item) {
            increaseQualityByOne(item);

            if (item.sellIn <= 10) {  // Backstage SellIn Threshold changed to leq
                increaseQualityByOne(item);
            }

            if (item.sellIn <= 5) { // Backstage SellIn Threshold changed to leq
                increaseQualityByOne(item);
            }

        }
    }
}