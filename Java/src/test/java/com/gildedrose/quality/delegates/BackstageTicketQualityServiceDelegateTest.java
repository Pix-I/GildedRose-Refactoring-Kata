package com.gildedrose.quality.delegates;

import com.gildedrose.Item;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BackstageTicketQualityServiceDelegateTest {

    private BackstageTicketQualityServiceDelegate delegate = new BackstageTicketQualityServiceDelegate();
    
    @Test
    void updateQuality_lessThan5Days() {
        Item ticket = new Item("Backstage passes to a TAFKAL80ETC concert", 2, 0);
        delegate.updateQuality(ticket);
        assertEquals(3,ticket.quality);
    }
    @Test
    void updateQuality_lessThan10Days() {
        Item ticket = new Item("Backstage passes to a TAFKAL80ETC concert", 10, 0);
        delegate.updateQuality(ticket);
        assertEquals(2,ticket.quality);
    }
    @Test
    void updateQuality_lessThan15Days() {
        Item ticket = new Item("Backstage passes to a TAFKAL80ETC concert", 15, 0);
        delegate.updateQuality(ticket);
        assertEquals(1,ticket.quality);
    }

    @Test
    void updateQualityOfOverdueItem() {
        Item ticket = new Item("Backstage passes to a TAFKAL80ETC concert", 0, 30);
        delegate.updateQualityOfOverdueItem(ticket);
        assertEquals(0,ticket.quality);
    }
}
