package com.gildedrose;

import com.gildedrose.itemtypes.*;

public class GildedRose {

    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE_PASS = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    public static final String CONJURED = "Conjured";
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            ItemType itemType = getItemType(item);
            itemType.updateSingleItem(item, this);
        }
    }

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