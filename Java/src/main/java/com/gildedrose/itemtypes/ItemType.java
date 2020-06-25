package com.gildedrose.itemtypes;

import com.gildedrose.GildedRose;
import com.gildedrose.Item;

public class ItemType {

    /*
     * Most of the heavy lifting now is done by the ItemType class and not by the GildedRose class.
     * Here the updateSingleItem() is defined and the basic methods for "regular" items are declared
     *
     */


    /**
     * This method takes an item, decreases the SellIn counter by 1 and updates the quality in two phases:
     * - ALWAYS: updateQuality()
     * - if SellIn < 0: updateQualityAfterSellIn()
     *
     * @param item
     * @param gildedRose
     */
    public void updateSingleItem(Item item, GildedRose gildedRose) {
        updateQuality(item);

        decreaseSellIn(item);

        if (hasPassedSellIn(item)) {
            updateQualityAfterSellIn(item);
        }
    }

    /**
     * Decrease quality by 1 method
     *
     * @param item
     */
    protected void updateQuality(Item item) {
        decreaseQualityByOne(item);
    }

    /**
     * Decrease quality by 1 method. This method will run only when SellIn < 0
     * @param item
     */
    protected void updateQualityAfterSellIn(Item item) {
        decreaseQualityByOne(item);
    }

    /**
     * SellIn = SellIn - 1
     * @param item
     */
    protected void decreaseSellIn(Item item) {
        item.sellIn = item.sellIn - 1;
    }

    /**
     * Check whether SellIn < 0
     * @param item
     * @return
     */
    protected boolean hasPassedSellIn(Item item) {
        return item.sellIn < 0;
    }

    /**
     * if quality is positive --> quality = quality - 1
     * @param item
     */
    protected void decreaseQualityByOne(Item item) {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
    }

    /**
     * if quality is not max --> quality = quality + 1
     * quality
     * @param item
     */
    protected void increaseQualityByOne(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }
}
