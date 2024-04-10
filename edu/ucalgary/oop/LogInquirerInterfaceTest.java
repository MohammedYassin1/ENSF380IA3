package edu.ucalgary.oop;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Before;

public class LogInquirerInterfaceTest {
    private ArrayList<DisasterVictim> disasterVictims;
    private DisasterVictim disasterVictim;
    private String search = "John";
    private ArrayList<DisasterVictim> expectedDisasterVictims;
    private Location location = new Location("Shelter", "12 st 12 ave NE");


    @Before
    public void setUp() {
        disasterVictim = new DisasterVictim("Johnny", "2024-02-02");
        disasterVictim.setLocation(location);
        disasterVictim.setLastName("Doe");

        disasterVictims = new ArrayList<DisasterVictim>();
        disasterVictims.add(disasterVictim);
        disasterVictims.add(new DisasterVictim("Wattson", "2024-03-03"));

        expectedDisasterVictims = new ArrayList<DisasterVictim>();
        expectedDisasterVictims.add(disasterVictim); 
        location.setOccupants(expectedDisasterVictims);
    }
    @Test
    public void testGenerateLogInquirer() {
        LogInquirer logInquirer = LogInquirerInterface.generateLogInquirer(location);
        assertNotNull("testGenerateLogInquirer should generate inastanace of LogInquirer",logInquirer);
    }

    @Test
    public void testGenerateReliefService() {
        ReliefService reliefService = LogInquirerInterface.generateReliefService(location);
        assertNotNull("testReliefService should generate inastanace of ReliefService",reliefService);
    }

    @Test
    public void testSearchDisasterVictim() {
        DisasterVictim disasterVictims1 = LogInquirerInterface.searchDisasterVictim(location);
        assertNotNull("searchDisasterVictim should return instance of DisasterVictim", disasterVictims1);
    }
    
    @Test
    public void testPartialSearchDisasterVictim() {
        DisasterVictim disasterVictims1 = LogInquirerInterface.searchDisasterVictim(location);
        assertNotNull("searchDisasterVictim should return instance of DisasterVictim", disasterVictims1);
    }
}


