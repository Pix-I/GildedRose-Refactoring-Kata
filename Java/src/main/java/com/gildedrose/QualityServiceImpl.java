package com.gildedrose;

public class QualityServiceImpl implements QualityService {

    public void updateQualityOfItem(Item item) {
        if (isAgedBrieTicket(item)
                || isBackstageTicket(item)) {
            if (item.quality < 50) {
                upgradeQuality(item);

                if (isBackstageTicket(item)) {
                    if (item.sellIn < 11) {
                        if (item.quality < 50) {
                            upgradeQuality(item);
                        }
                    }

                    if (item.sellIn < 6) {
                        if (item.quality < 50) {
                            upgradeQuality(item);
                        }
                    }
                }
            }
        } else {
            if (item.quality > 0) {
                if (isNotALegendary(item)) {
                    downGradeQuality(item);
                }
            }
        }

        if (isNotALegendary(item)) {
            item.sellIn = item.sellIn - 1;
        }

        if (item.sellIn < 0) {
            if (isAgedBrieTicket(item)) {
                if (item.quality < 50) {
                    upgradeQuality(item);
                }
            } else {
                if (isBackstageTicket(item)) {
                    item.quality = 0;
                } else {
                    if (item.quality > 0 && isNotALegendary(item)) {
                        downGradeQuality(item);
                    }
                }
            }
        }
    }

    private boolean isBackstageTicket(Item item) {
        return item.name.equals("Backstage passes to a TAFKAL80ETC concert");
    }

    private boolean isAgedBrieTicket(Item item) {
        return item.name.equals("Aged Brie");
    }

    private boolean isNotALegendary(Item item) {
        return !item.name.equals("Sulfuras, Hand of Ragnaros");
    }

    private void upgradeQuality(Item item) {
        item.quality = item.quality + 1;
    }

    private void downGradeQuality(Item item) {
        item.quality = item.quality - 1;
    }
}
