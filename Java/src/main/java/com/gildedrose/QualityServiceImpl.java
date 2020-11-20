package com.gildedrose;

public class QualityServiceImpl implements QualityService {

    public void updateQualityOfItem(Item item) {
        if (isAgedBrieTicket(item)
                || isBackstageTicket(item)) {
            upgradeQualityIfNeeded(item);
        } else {
            downGradeQuality(item);
        }
        ageItem(item);
        if (item.sellIn < 0) {
            updateQualityOfOverdueItem(item);
        }
    }

    private void ageItem(Item item) {
        if (isNotALegendary(item)) {
            item.sellIn = item.sellIn - 1;
        }
    }

    private void upgradeQualityIfNeeded(Item item) {
        upgradeQuality(item);
        if (isBackstageTicket(item)) {
            if (item.sellIn < 11) {
                upgradeQuality(item);
            }
            if (item.sellIn < 6) {
                upgradeQuality(item);
            }
        }
    }

    private void updateQualityOfOverdueItem(Item item) {
        if (isAgedBrieTicket(item)) {
            upgradeQuality(item);
        } else {
            if (isBackstageTicket(item)) {
                makeItemWorthless(item);
            } else {
                downGradeQuality(item);
            }
        }
    }

    private void makeItemWorthless(Item item) {
        item.quality = 0;
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
        if (item.quality < 50) {
            item.quality++;
        }
    }

    private void downGradeQuality(Item item) {
        if (isNotALegendary(item) && item.quality > 0) {
            item.quality--;

        }
    }
}
