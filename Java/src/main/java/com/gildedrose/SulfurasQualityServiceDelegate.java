package com.gildedrose;

public class SulfurasQualityServiceDelegate implements QualityServiceDelegate {

    // Legendary items do not age
    @Override
    public void ageItem(Item i) {
    }

    // Legendary items do not change in quality
    @Override
    public void updateQuality(Item i) {

    }

    // Legendary items are never overdue
    @Override
    public void updateQualityOfOverdueItem(Item i) {

    }
}
