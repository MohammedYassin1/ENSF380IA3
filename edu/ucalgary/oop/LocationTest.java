package edu.ucalgary.oop;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;

public class LocationTest {
    private Location location;
    private DisasterVictim victim;
    private Supply supply;

    @Before
    public void setUp() {
        location = new Location("Hospital", "12 st 12 ave NE");
        victim = new DisasterVictim("Joe Biden", "2024-01-01");
        supply = new Supply("Nike", 10);
    }

    @Test
    public void testImplementation() {
        assertTrue("Location should implement AddRemoveSupply", location instanceof AddRemoveSupply);
    }

    @Test
    public void testConstructor() {
        assertNotNull("Location constructor should create instance of Location", location);
    }

    @Test
    public void testSetAndGetName() {
        String expectedName = "Crampton";
        location.setName(expectedName);
        assertEquals("setName and getName should update and give name of location", expectedName, location.getName());
    }

    @Test
    public void testSetAddress() {
        String expectedAddress = "Skyview Ranch 2345";
        location.setAddress(expectedAddress);
        assertEquals("setAddress and getAddress should update and give name of location", expectedAddress, location.getAddress());
    }

    @Test
    public void testSetAndGetOccupants() {
        ArrayList<DisasterVictim> expectedResidents = new ArrayList<>();
        expectedResidents.add(victim);
        location.setOccupants(expectedResidents);
        assertTrue("setOccupants and getOcupants should update and give Residents", location.getOccupants().containsAll(expectedResidents));
    }

    @Test
    public void testAddOccupant() {
        location.addOccupant(victim);
        assertTrue("addOccupant should add DisasterVictim instance to Residents", location.getOccupants().contains(victim));
    }

    @Test
    public void testRemoveOccupant() {
        location.addOccupant(victim); 
        location.removeOccupant(victim);
        assertFalse("removeOccupant should remove DisasterVictim instance from Residents", location.getOccupants().contains(victim));
    }

    @Test
    public void testSetAndGetSupplies() {
        ArrayList<Supply> expectedSupply = new ArrayList<>();
        expectedSupply.add(supply);
        location.setSupplies(expectedSupply);
        assertTrue("setOccupants and getOcupants should update and give Residents", location.getSupplies().contains(supply));
    }

    @Test
    public void testAddSupply() {
        location.addSupply(supply);
        assertTrue("addSupply should add Supply instance to supplies", location.getSupplies().contains(supply));
    }

    @Test
    public void testRemoveSupply() {
        location.addSupply(supply); 
        location.removeSupply(supply);
        assertFalse("removeSupply should remove supply instance from supplies", location.getSupplies().contains(supply));
    }

    @Test
    public void testDecrementSupply() {
        String name = "Nike";
        int quantity = 8;
        int quantity2 = 2;
        Location newLocation = new Location("Hospital", "12 st 12 ave NE");
        Supply newSupply = new Supply(name, quantity);
        newLocation.addSupply(newSupply);
        newLocation.decrementSupply(name, 2);
        assertEquals("decrementSupply should decrement supply by provided amount", quantity - quantity2, newLocation.getSupplies().get(0).getQuantity());
        
    }
}
