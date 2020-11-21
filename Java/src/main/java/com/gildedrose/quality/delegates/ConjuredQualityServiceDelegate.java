package com.gildedrose.quality.delegates;

import com.gildedrose.Item;

public class ConjuredQualityServiceDelegate extends QualityServiceDelegate {


    @Override
    public void updateQuality(Item i) {
        super.updateQuality(i);
        super.updateQuality(i);
    }

    // This actually executes updateQuality
    @Override
    public void updateQualityOfOverdueItem(Item i) {
        updateQuality(i);
    }
}
