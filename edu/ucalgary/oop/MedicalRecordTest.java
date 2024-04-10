package edu.ucalgary.oop;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

public class MedicalRecordTest {

    Location expectedLocation;
    private String expectedTreatmentDetails;
    private String expectedDateOfTreatment;
    private String validDateOfTreatment;
    private String inValidDateOfTreatment;
    MedicalRecord medicalRecord;

    @Before
    public void setUp() {
        expectedLocation = new Location("Shelter Swan", "140 8 Ave NW ");
        expectedTreatmentDetails = "Nasal congestion treated";
        expectedDateOfTreatment = "2024-01-01";
        validDateOfTreatment = "2024-02-01";
        inValidDateOfTreatment = "2024/01/01";
        medicalRecord = new MedicalRecord(expectedLocation, expectedTreatmentDetails, expectedDateOfTreatment);
    }

    @Test
    public void testObjectCreation() {
        assertNotNull("MedicalRecord constructor should initilize instance", medicalRecord);
    }	

    @Test
    public void testSetAndGetLocation() {
        Location newExpectedLocation = new Location("Shelter Swan", "22 st 8 ave NE");
        medicalRecord.setLocation(newExpectedLocation);
        assertEquals("setLocation and getLocation should update and give the Location", newExpectedLocation.getName(), medicalRecord.getLocation().getName());
    }

    @Test
    public void testSetAndGetTreatmentDetails() {
        String newExpectedTreatment = "No surgery required";
        medicalRecord.setTreatmentDetails(newExpectedTreatment);
        assertEquals("setTreatmentDetails and getTreatmentDetails should update and give the treatment details", newExpectedTreatment, medicalRecord.getTreatmentDetails());
    }

	@Test
    public void testSetDateOfTreatment() {
        String newExpectedDateOfTreatment = "2024-02-05";
        medicalRecord.setDateOfTreatment(newExpectedDateOfTreatment);
        assertEquals("setDateOfTreatment should update date of treatment", newExpectedDateOfTreatment, medicalRecord.getDateOfTreatment());
    }

	@Test
    public void testSetDateOfTreatmentWithValidFormat() {
        medicalRecord.setDateOfTreatment(validDateOfTreatment); 
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetDateOfBirthWithInvalidFormat() {
        boolean correctValue = false;
        String failureReason = "no exception was thrown";
        medicalRecord.setDateOfTreatment(inValidDateOfTreatment); 
    }

}

