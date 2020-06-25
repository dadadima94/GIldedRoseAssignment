package com.gildedrose.itemtypes;

import com.gildedrose.Item;

/**
 * Conjured Class for new Conjured Category.
 */
public class ConjuredItem extends ItemType {
    protected void updateQuality(Item item) {
        decreaseQualityByOne(item);
        decreaseQualityByOne(item);
    }

    protected void updateQualityAfterSellIn(Item item) {
        decreaseQualityByOne(item);
        decreaseQualityByOne(item);
    }
}
