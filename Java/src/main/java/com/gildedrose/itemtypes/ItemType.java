package com.gildedrose.itemtypes;

import com.gildedrose.GildedRose;
import com.gildedrose.Item;

public class ItemType {

    public void updateSingleItem(Item item, GildedRose gildedRose) {
        updateQualityBeforeSellIn(item);

        decreaseSellIn(item);

        if (hasPassedSellIn(item)) {
            updateQualityAfterSellIn(item);
        }
    }

    protected void updateQualityBeforeSellIn(Item item) {
        decreaseQualityByOne(item);
    }

    protected void updateQualityAfterSellIn(Item item) {
        decreaseQualityByOne(item);
    }

    protected void decreaseSellIn(Item item) {
        item.sellIn = item.sellIn - 1;
    }

    protected boolean hasPassedSellIn(Item item) {
        return item.sellIn < 0;
    }

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
}
