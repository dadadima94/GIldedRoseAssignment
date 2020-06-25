package com.gildedrose.itemtypes;

import com.gildedrose.Item;

/**
 * This chlid class overrides two methods of the mother for the Aged Brie requirements
 */
public class LegendaryItem extends ItemType {
//    In the requirements.txt file in the repository there is one line stating:
//    "Just for clarification, an item can never have its Quality increase above 50, however "Sulfuras" is a
//    legendary item and as such its Quality is 80 and it never alters."
//    I haven't assigned this value of 80 to Solfuras anywhere. I assume the items are entered correctly in the store.
//    However, in the updateQuality() method could be added a line like  item.quality = 80.
    protected void updateQuality(Item item) {
    }

    protected void decreaseSellIn(Item item) {
    }

    protected void updateQualityAfterSellIn(Item item) {
    }
}
