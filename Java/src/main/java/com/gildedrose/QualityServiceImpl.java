package com.gildedrose;

public class QualityServiceImpl implements QualityService {

    public void updateQualityOfItem(Item item) {
        if (isABackstageTicket(item)
                || item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    if (item.quality < 50) {
                        upgradeQuality(item);

                        if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
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
            if (isABackstageTicket(item)) {
                if (item.quality < 50) {
                    upgradeQuality(item);
                }
            } else {
                if (!item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    if (item.quality > 0) {
                        if (isNotALegendary(item)) {
                            downGradeQuality(item);
                        }
                    }
                } else {
                    item.quality = item.quality - item.quality;
                }
            }
        }
    }

    private boolean isABackstageTicket(Item item) {
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
