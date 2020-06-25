package com.gildedrose.itemtypes;

import com.gildedrose.Item;

/**
 * This chlid class overrides two methods of the mother for the Aged Brie requirements
 */
public class AgedBrieItem extends ItemType {
    protected void updateQuality(Item item) {
        increaseQualityByOne(item);
    }

    protected void updateQualityAfterSellIn(Item item) {
        increaseQualityByOne(item);
    }

}
