package edu.ucalgary.oop;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ReliefServiceTest {
    private ReliefService reliefService;
    private Inquirer inquirer;
    private DisasterVictim missingPerson;
    private Location lastKnownLocation;
    private String validDate = "2024-09-09";
    private String invalidDate = "2024/09/09";
    private String expectedInfoProvided = "Looking for friend";

    @Before
    public void setUp() {
        inquirer = new Inquirer("John", "Doe", "0987654321", "Looking for friend");
        missingPerson = new DisasterVictim("John Smith", "2024-01-25");
        lastKnownLocation = new Location("New Location", "123 Main St");
        reliefService = new ReliefService(inquirer, missingPerson, validDate, expectedInfoProvided, lastKnownLocation);
    }

    @Test
    public void testObjectCreation() {
        assertNotNull("ReliefService object should not be null", reliefService);
    }

    @Test
    public void testGetInquirer() {
        assertEquals("The contactor should match the one set in the setup", inquirer, reliefService.getInquirer());
    }

    @Test
    public void testSetContactor() {
        Inquirer newInquirer = new Inquirer("Jane", "Doe", "0987654321", "Looking for friend");
        reliefService.setInquirer(newInquirer);
        assertEquals("The contactor should match the one set in the setup", newInquirer, reliefService.getInquirer());
    }

    @Test
    public void testGetMissingPerson() {
        assertEquals("The missing person should match the one set in the setup", missingPerson, reliefService.getMissingPerson());
    }

    @Test
    public void testSetMissingPerson() {
        DisasterVictim newMissingPerson = new DisasterVictim("John Doe", "2024-01-25");
        reliefService.setMissingPerson(newMissingPerson);
        assertEquals("The missing person should match the one set in the setup", newMissingPerson, reliefService.getMissingPerson());
    }

    @Test
    public void testGetDateOfInquiry() {
        assertEquals("The date of inquiry should match the one set in the setup", validDate, reliefService.getDateOfInquiry());
    }

    @Test
    public void testSetDateOfInquiryWithValidDate() {
        String newValidDate = "2024-02-11";
        reliefService.setDateOfInquiry(newValidDate);
        assertEquals("Setting a valid date should update the date of inquiry", newValidDate, reliefService.getDateOfInquiry());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetDateOfInquiryWithInvalidDate() {
        reliefService.setDateOfInquiry(invalidDate);
    }

    @Test
    public void testGetInfoProvided() {
        assertEquals("The info provided should match the one set in the setup", expectedInfoProvided, reliefService.getInfoProvided());
    }

    @Test
    public void testSetInfoProvided() {
        String newInfoProvided = "Looking for friend";
        reliefService.setInfoProvided(newInfoProvided);
        assertEquals("The info provided should match the one set in the setup", newInfoProvided, reliefService.getInfoProvided());
    }

    @Test
    public void testSetAndGetLogged() {
        Boolean b = true;
        reliefService.setLogged(b);
        assertEquals("The info provided should match the one set in the setup", b, reliefService.getLogged());
    }

    @Test
    public void testGetLastKnownLocation() {
        assertEquals("The last known location should match the one set in the setup", lastKnownLocation, reliefService.getLastKnownLocation());
    }

    @Test
    public void testSetLastKnownLocation() {
        Location newLastKnownLocation = new Location("SAIT", "1301 16 Ave NW");
        reliefService.setLastKnownLocation(newLastKnownLocation);
        assertEquals("The last known location should match the one set in the setup", newLastKnownLocation, reliefService.getLastKnownLocation());
    }
}
