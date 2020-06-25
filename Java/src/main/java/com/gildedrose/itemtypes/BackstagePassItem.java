package com.gildedrose.itemtypes;

import com.gildedrose.Item;

public class BackstagePassItem extends ItemType {

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
