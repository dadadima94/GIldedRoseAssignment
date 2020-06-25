package com.gildedrose.itemtypes;

import com.gildedrose.Item;

/**
 * This chlid class overrides two methods of the mother for the Backstage tickets requirements
 */
public class BackstagePassItem extends ItemType {

    protected void updateQuality(Item item) {
        increaseQualityByOne(item);

        if (item.sellIn <= 10) {  // Backstage SellIn Threshold changed to leq
            increaseQualityByOne(item);
        }

        if (item.sellIn <= 5) { // Backstage SellIn Threshold changed to leq
            increaseQualityByOne(item);
        }

    }

    protected void updateQualityAfterSellIn(Item item) {
        item.quality = 0;
    }
}
