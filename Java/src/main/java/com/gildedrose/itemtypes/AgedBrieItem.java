package com.gildedrose.itemtypes;

import com.gildedrose.Item;

public class AgedBrieItem extends ItemType {
    protected void updateQualityAfterSellIn(Item item) {
        increaseQualityByOne(item);
    }

    protected void updateQualityBeforeSellIn(Item item) {
        increaseQualityByOne(item);
    }

}
