package edu.ucalgary.oop;

import org.junit.Test;
import static org.junit.Assert.*;

public class SupplyTest {
    String expectedName = "Pillow";
    int expectedAmount = 10;

    @Test
    public void testConstructor() {
        Supply supply = new Supply(expectedName, expectedAmount);
        assertEquals("Constructor should set the name correctly", expectedName, supply.getType());
        assertEquals("Constructor should set the amount correctly", expectedAmount, supply.getQuantity());
    }

    @Test
    public void testGetType() {
        Supply supply1 = new Supply(expectedName, expectedAmount);
        assertEquals("getType should return the expected name", expectedName, supply1.getType());
    }

    @Test
    public void testSetType() {
        Supply supply2 = new Supply();
        supply2.setType(expectedName);
        assertEquals("setType should update the name correctly", expectedName, supply2.getType());
    }

    @Test
    public void testGetQuantity() {
        Supply supply3 = new Supply(expectedName, expectedAmount);
        assertEquals("getQuantity should return the expected amount", expectedAmount, supply3.getQuantity());
    }

    @Test
    public void testSetQuantity() {
        Supply supply4 = new Supply();
        supply4.setQuantity(expectedAmount);
        assertEquals("setQuantity should update the amount correctly", expectedAmount, supply4.getQuantity());
    }

    @Test
    public void testIncrement() {
        Supply supply5 = new Supply();
        supply5.setQuantity(expectedAmount);
        supply5.increment(5);
        assertEquals("Increment should update the amount by adding the provided int", expectedAmount + 5, supply5.getQuantity());
    }

    @Test
    public void testDecrement() {
        Supply supply6 = new Supply();
        supply6.setQuantity(expectedAmount);
        supply6.decrement(5);
        assertEquals("Decrement should update the amount by subtracting the provided int", expectedAmount - 5, supply6.getQuantity());
    }

}
