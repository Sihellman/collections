package edu.ti.caih313.collections;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LedgerTest {
    Ledger ledger = new Ledger();
    @Before
    void setUp(){
        ledger = new Ledger();
    }
    @Test
    void testAddSales(){
        ledger.addSales(1.0);
        ledger.addSales(2.0);
        assertTrue(ledger.sales.get(0) == 1.0);
        assertTrue(ledger.sales.get(1) == 2.0);

    }
    @Test
    void testGetNumberOfSales(){
        ledger.addSales(1.0);
        ledger.addSales(2.0);
        assertEquals(ledger.sales.size(), 2);
    }
    @Test
    void testGetTotalSales(){
        ledger.addSales(1.0);
        ledger.addSales(2.0);
        assertEquals(ledger.getTotalSales(), 3);
    }
    @Test
    void testGetAverageSale(){
        ledger.addSales(2.0);
        ledger.addSales(2.0);
        assertEquals(ledger.getAverageSale(), 2);
    }
}