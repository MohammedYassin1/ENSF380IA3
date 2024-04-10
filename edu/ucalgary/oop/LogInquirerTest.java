package edu.ucalgary.oop;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
import java.util.ArrayList;

public class LogInquirerTest {
    private LogInquirer logInquirer;
    private ArrayList<ReliefService> reliefServices;
    private ReliefService reliefService;
    private ReliefService reliefService1;   
    private Inquirer inquirer;
    private DisasterVictim missingPerson;
    private DisasterVictim missingPerson1;
    private Location lastKnownLocation;
    private Location lastKnownLocation1;
    private String validDate = "2024-02-10";
    private String invalidDate = "2024/02/10";
    private String expectedInfoProvided = "Looking for family member";
    private String expectedInfoProvided1 = "Looking for friend";

    @Before
    public void setUp() {
        inquirer = new Inquirer("John", "Doe", "0213546978", "Looking for friend");
        missingPerson = new DisasterVictim("Momo", "2024-02-02");
        lastKnownLocation = new Location("New Location", "01 st 01 ave");
        missingPerson1 = new DisasterVictim("John Doe", "2024-03-03");
        lastKnownLocation1 = new Location("Newer Location", "02 st 02 ave");
        reliefService = new ReliefService(inquirer, missingPerson, validDate, expectedInfoProvided, lastKnownLocation);
        reliefService1 = new ReliefService(inquirer, missingPerson1, validDate, expectedInfoProvided1, lastKnownLocation1);
        reliefServices = new ArrayList<ReliefService>();
        reliefServices.add(reliefService);
        reliefServices.add(reliefService1);
        logInquirer = new LogInquirer(reliefServices, inquirer);
    }

    @Test
    public void testObjectCreation() {
        assertNotNull("LogInquirer object should not be null", logInquirer);
    }

    @Test
    public void testGetLog() {
        assertEquals("Log should match the one set in setUp method", reliefServices, logInquirer.getLog());
    }

    @Test
    public void testSetLog() {
        logInquirer.setLog(reliefServices);
        assertEquals("Log should match the one set using setLog method", reliefServices, logInquirer.getLog());
    }

    @Test
    public void testGetInquirer() {
        assertEquals("Inquirer should match the one set in setUp method", inquirer, logInquirer.getInquirer());
    }

    @Test
    public void testSetInquirer() {
        Inquirer newInquirer = new Inquirer("Jane", "Doe", "0987654321", "Looking for friend");
        logInquirer.setInquirer(newInquirer);
        assertEquals("Inquirer should match the one set using setInquirer method", newInquirer, logInquirer.getInquirer());
    }

    @Test
    public void testAddLog(){
        ReliefService reliefService2 = new ReliefService(inquirer, missingPerson, validDate, expectedInfoProvided, lastKnownLocation);
        logInquirer.addLog(reliefService2);
        assertEquals("Log should match the one added with addLog method", reliefService2, logInquirer.getLog().get(2));
    }
}
