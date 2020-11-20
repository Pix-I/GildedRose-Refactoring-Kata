package com.gildedrose;

class GildedRose {
    private final Item[] items;

    private final QualityService qualityService = new QualityServiceImpl();


    public GildedRose(Item[] items) {
        this.items = items;
    }

    public Item[] getItems() {
        return items;
    }

    public void updateQuality() {
        for (Item item : items) {
            qualityService.updateQualityOfItem(item);
        }
    }

}
