package com.gildedrose.itemtypes;

import com.gildedrose.Item;

public class ConjuredItem extends ItemType {
    protected void updateQualityBeforeSellIn(Item item) {
        decreaseQualityByOne(item);
        decreaseQualityByOne(item);
    }

    protected void updateQualityAfterSellIn(Item item) {
        decreaseQualityByOne(item);
        decreaseQualityByOne(item);
    }
}
