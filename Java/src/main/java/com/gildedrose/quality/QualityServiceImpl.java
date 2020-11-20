package com.gildedrose.quality;

import com.gildedrose.Item;

public class QualityServiceImpl implements QualityService {

    // TODO : Make the process item specific, both downgrade, aging and overdue
    // The goal will be to have specific rules for different items and make it easier to add other items in the future

    public void updateQualityOfItem(Item item) {
        switch (item.name){
            case "Backstage passes to a TAFKAL80ETC concert":
            case "Aged Brie":
                updateQualityOfTicket(item);
                break;
            default:
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

    private void updateQualityOfTicket(Item item) {
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
