package com.gildedrose;

import com.gildedrose.itemtypes.*;

public class GildedRose {

    // Constants extraction
    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE_PASS = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    public static final String CONJURED = "Conjured";
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    /**
     * The updateQuality() method has been simplified:
     * - regular for replaced with enhanced for a-la Python;
     * - the item type is "assigned" looking at the item's name
     * - the item is updated
     *
     */

    public void updateQuality() {
        for (Item item : items) {
            ItemType itemType = getItemType(item);
            itemType.updateSingleItem(item, this);
        }
    }

    /**
     * Since it is forbidden to alter the ItemType and add an itemType attribute there,
     * I have generated this method to return a specific class of item based on the item name.
     * These classes are children classes of the ItemType class.
     *
     * @param item
     * @return
     */

    private ItemType getItemType(Item item) {
        if (item.name.equals(SULFURAS)) {
            return new LegendaryItem();
        }
        if (item.name.equals(AGED_BRIE)) {
            return new AgedBrieItem();
        }
        if (item.name.equals(BACKSTAGE_PASS)) {
            return new BackstagePassItem();
        }
        if (item.name.startsWith(CONJURED)){
            return new ConjuredItem();
        }
        return new RegularItem();
    }



}