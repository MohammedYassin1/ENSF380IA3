package edu.ucalgary.oop;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;
import java.beans.Transient;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;


public class DisasterVictimTest {
    private DisasterVictim victim;
    private List<Supply> suppliesToSet; 
    private List<FamilyRelation> familyRelations; 
    private String expectedFirstName;
    private String EXPECTED_ENTRY_DATE;
    private String validDate;
    private String invalidDate;
    private String expectedGender; 
    private String invalidGender;
    private String expectedComments;
    DisasterVictim victim1;
    DisasterVictim victim2;
    DisasterVictim victim3;

    @Before
    public void setUp() {
        expectedFirstName = "Micheal";
        EXPECTED_ENTRY_DATE = "2024-02-02";
        validDate = "2024-03-30";
        invalidDate = "2/2/2024";
        expectedGender = "female"; 
        invalidGender = "fem";
        expectedComments = "Dosen't need any medical attention and only speaks arabic";
        victim = new DisasterVictim(expectedFirstName, EXPECTED_ENTRY_DATE);
        suppliesToSet = new ArrayList<>();
        suppliesToSet.add(new Supply("Coat", 8));
        suppliesToSet.add(new Supply("Ration", 7));
        
        victim1 = new DisasterVictim("Molly", "2024-02-20");
        victim2 = new DisasterVictim("Hans", "2024-01-10");
        victim3 = new DisasterVictim("Kash", "2024-01-21");
    }    	
/*     
    @Test
    public void testImplementation() {
        assertTrue("DisasterVictim should implement AddRemoveSupply", victim instanceof AddRemoveSupply);
    }
*/
    @Test
    public void testConstructorWithValidEntryDate() {
        String expectedValidEntryDate = "2024-05-10";
        DisasterVictim victim = new DisasterVictim("Monika", expectedValidEntryDate);
        assertNotNull("Disaster victim constructor should create an instance", victim);
        assertEquals("Constructor should set the entry date correctly", expectedValidEntryDate, victim.getEntryDate());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorWithInvalidEntryDateFormat() {
        String invalidDate = "01/01/2024";
        new DisasterVictim("Monika", invalidDate);
    }
	
	@Test
    public void testSetAndGetFirstName() {
        String expectedFirstName = "David";
        victim.setFirstName(expectedFirstName);
        assertEquals("setFirstName and getFirstName should update and give firsName", expectedFirstName, victim.getFirstName());
    }

    @Test
    public void testSetAndGetLastName() {
        String expectedLastName = "Jameson";
        victim.setLastName(expectedLastName);
        assertEquals("setLattName and getLastName should update and give lastName", expectedLastName, victim.getLastName());
    }

    @Test
    public void testSetAndGetHeight() {
        int heightInCm = 180;
        victim.setHeight(heightInCm);
        assertEquals("setHeight and getHeight should update and give height", heightInCm, victim.getHeight());
    }

    @Test
    public void testSetAndGetWeight() {
        int weightInLb = 180;
        victim.setWeight(weightInLb);
        assertEquals("setWeight and getWeight should update and give weight", weightInLb, victim.getWeight());
    }

    @Test
    public void testSetAndGetComments() {
        victim.setComments(expectedComments);
        assertEquals("setComments and getComments should update and give comments", expectedComments, victim.getComments());
    }
/* 
    @Test
    public void testSetAndGetDietaryRestriction() {
        DietaryRestriction expectedRestriction = DietaryRestriction.AVML;           
        victim.setDietaryRestriction(expectedRestriction);
        assertEquals("setDietaryRestriction and getDietaryRestriction should update and give cietaryRestriction", expectedRestriction, victim.getDietaryRestriction());
    }
*/    
    @Test
    public void testGetAssignedSocialID() {
        DisasterVictim previousVictim = new DisasterVictim();
        int expectedSocialId = previousVictim.getAssignedSocialID() + 1;
        DisasterVictim expectedVictim = new DisasterVictim();

        assertEquals("getAssignedSocialID should give socailID", expectedSocialId, expectedVictim.getAssignedSocialID());
    }

    @Test
    public void testGetEntryDate() {
        assertEquals("getEntryDate should give the expected entry date", EXPECTED_ENTRY_DATE, victim.getEntryDate());
    }
   
    @Test
    public void testSetAndGetGender() {
        String newGender = "man";
        Location location = new Location("Shelter Kit", "12 st 12 ave NE");
        victim.setLocation(location);        
        victim.setGender(newGender);
        assertEquals("setGender and getGender should update and give gender", newGender.toLowerCase(), victim.getGender().toLowerCase());
    }
	
    @Test(expected = IllegalArgumentException.class)
    public void testSetInvalidGender() {
        Location location = new Location("Shelter", "12 st 12 ave NE");
        victim.setLocation(location);
        victim.setGender(invalidGender);
    }

    @Test
    public void testSetAndGetDateOfBirth() {
        String newDateOfBirth = "1987-05-21";
        victim.setDateOfBirth(newDateOfBirth);
        assertEquals("setDateOfBirth should update the date of birth", newDateOfBirth, victim.getDateOfBirth());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetDateOfBirthWithInvalidFormat() {
        victim.setDateOfBirth(invalidDate);
    }

    @Test
    public void testSetAndGetAproxAge(){
        int expectedAge = 60;
        victim.setAproxAge(expectedAge);
        assertEquals("setAproxAge and getAproxAge should update and give aproxAge", expectedAge, victim.getAproxAge());
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testSetAproxAgeWithDateOfBirthAlreadySet(){
        int expectedAge = 60;
        String dateOfBirth = "1964-01-01";
        victim.setDateOfBirth(dateOfBirth);
        victim.setAproxAge(expectedAge);
    }

    @Test
    public void testSetAndgetFamilyConnections() {
        DisasterVictim victim1 = new DisasterVictim("James", "2024-01-11");
        DisasterVictim victim2 = new DisasterVictim("Carl", "2024-02-12");

        FamilyRelation relation = new FamilyRelation(victim2, "parent", victim1);
        ArrayList<FamilyRelation> expectedRelations = new ArrayList<FamilyRelation>();
        expectedRelations.add(relation);
        victim2.setFamilyConnections(expectedRelations);

        ArrayList<FamilyRelation> relation2 = victim2.getFamilyConnections();
    
        assertEquals("setFamilyConnections and getFamilyConnections should update and give familyRelation", expectedRelations.get(0), relation2.get(0));
    }

    @Test
    public void testaddFamilyConnection() {
        DisasterVictim victim1 = new DisasterVictim("James", "2024-01-11");
        DisasterVictim victim2 = new DisasterVictim("Carl", "2024-02-12");
        DisasterVictim victim3 = new DisasterVictim("Dom", "2024-01-02");

        FamilyRelation relation = new FamilyRelation(victim2, "sibling", victim1);
        FamilyRelation relation2 = new FamilyRelation(victim2, "sibling", victim3);
        ArrayList<FamilyRelation> expectedRelations = new ArrayList<FamilyRelation>();
        expectedRelations.add(relation);
        expectedRelations.add(relation2);
        victim2.addFamilyConnection(relation);
        victim2.addFamilyConnection(relation2);

        ArrayList<FamilyRelation> relation1 = victim2.getFamilyConnections();

        //Test if there is a relation between victim3 and victim2
        ArrayList<FamilyRelation> relation3 = victim3.getFamilyConnections();
        boolean correct = relation3.get(0).getPersonTwo().equals(victim2);;
        
        assertEquals("addFamilyConnection should add familyRelation to ArrayList<FamilyRelation>", expectedRelations.get(0), relation1.get(0));
        assertTrue("addFamilyConnection should add familyRelation to both victims", correct);
    }

    
/*     
    @Test(expected = IllegalArgumentException.class)
    public void testaddFamilyConnectionDuplicate() {
        DisasterVictim victim1 = new DisasterVictim("James", "2024-01-11");
        DisasterVictim victim2 = new DisasterVictim("Carl", "2024-02-12");
        FamilyRelation relation = new FamilyRelation(victim2, "sibling", victim1);
        FamilyRelation relation2 = new FamilyRelation(victim1, "sibling", victim2);
        victim2.addFamilyConnection(relation);
        victim2.addFamilyConnection(relation2);
    }
*/    

    @Test
    public void testRemoveFamilyConnection() {
        DisasterVictim victim1 = new DisasterVictim("Jane", "2024-01-20");
        FamilyRelation relation1 = new FamilyRelation(victim, "sibling", victim1);
        
        FamilyRelation expectedRelation;
        victim.addFamilyConnection(relation1);

        DisasterVictim victim = new DisasterVictim("Max", "2024-01-23");
        victim.addFamilyConnection(relation1);
        victim.removeFamilyConnection(relation1);

        boolean correct = false;

        if((victim.getFamilyConnections().size() == 0) && (victim1.getFamilyConnections().size() == 0)){
            correct = true;
        }
        assertTrue("removeFamilyConnection should remove the FamilyRelation from both victims", correct);
    } 

    @Test
    public void testSetAndGetPersonalBelongings() {
        Supply one = new Supply("Jacket", 1);
        Supply two = new Supply("Shirt", 3);

        ArrayList<Supply> newSupplies = new ArrayList<>();
        newSupplies.add(one);
        newSupplies.add(two); 

        boolean correct = true;

        victim.setPersonalBelongings(newSupplies);
        ArrayList<Supply> actualSupplies = victim.getPersonalBelongings();

        if (newSupplies.size() != actualSupplies.size()) {
            correct = false;
        } else {
            for (int i = 0; i < newSupplies.size(); i++) {
                if (!actualSupplies.get(i).equals(newSupplies.get(i))) {
                    correct = false;
                }
            }
        }
        assertTrue("setPersonalBelongings and getPersonalBelongings should update and give personal belongings", correct);
    }

    @Test
    public void testAddPersonalBelonging() {
        DisasterVictim victim1 = new DisasterVictim("Jane", "2024-01-20");
        int totalAmount = 25;
        int amount = 5;
        
        Supply newSupply = new Supply("Emergency Kit", amount);
        Supply newSupply2 = new Supply("Emergency Kit", totalAmount);
        Location location = new Location("Shelter Kit", "12 st 12 ave NE");

        location.addSupply(newSupply2);
        victim1.setLocation(location);
        victim1.addPersonalBelonging(newSupply);
        ArrayList<Supply> testSupplies = victim1.getPersonalBelongings();
        int expectedAmount = totalAmount - amount;
        boolean correct = false;
        int actualAmount = 0;
        int i;
        for (i = 0; i < location.getSupplies().size(); i++) {
            if (location.getSupplies().get(i).getType() == newSupply.getType()) {
                actualAmount = location.getSupplies().get(i).getQuantity();
            }
        }
 
        assertEquals("addPersonalBelonging should add the supply to personal belongings", newSupply, testSupplies.get(0));
        assertEquals("addPersonalBelonging should decrement amount of supply" + 
        " in DisasterVictim location by amount set for personalBelonging", expectedAmount, actualAmount);
    }

    @Test
    public void testRemovePersonalBelonging() {
        Supply expectedSupply = new Supply("Tents", 5); 
        Location location = new Location("shelter", "12 st 12 ave NE");
        victim.setLocation(location);
        victim.addPersonalBelonging(expectedSupply); 
        

        victim.removePersonalBelonging(expectedSupply);
        ArrayList<Supply> testSupplies = victim.getPersonalBelongings();
        boolean correct = true;

        int i;
        for (i = 0; i < testSupplies.size(); i++) {
            if (testSupplies.get(i) == expectedSupply) {
                correct = false;
            }
        }
        assertTrue("removePersonalBelonging should remove the supply from personalBelonging", correct);
    }

    @Test
    public void testSetAndGetMedicalRecords() {
        Location testLocation = new Location("Shelter Kit", "12 st 12 ave NE");
        MedicalRecord testRecord = new MedicalRecord(testLocation, "testing eyes", "2024-03-02");
        boolean correct = true;

        ArrayList<MedicalRecord> expectedRecords = new ArrayList<MedicalRecord>();
        expectedRecords.add(testRecord);
        victim.setMedicalRecords(expectedRecords);
        ArrayList<MedicalRecord> actualRecords = victim.getMedicalRecords();

        if (expectedRecords.size() != actualRecords.size()) {
            correct = false;
        } else {
            int i;
            for (i=0;i<expectedRecords.size();i++) {
                if (!actualRecords.get(i).equals(expectedRecords.get(i))) {
                    correct = false;
                }
            }
        }
        assertTrue("setMedicalRecords and getMedicalRecors should update and give medical records", correct);
    }

    @Test
    public void testAddMedicalRecord() {
        Location testLocation = new Location("Shelter Kit", "12 st 12 ave NE");
        MedicalRecord testRecord = new MedicalRecord(testLocation, "testing eyes", "2024-03-02");
        boolean correct = true;

        ArrayList<MedicalRecord> expectedRecords = new ArrayList<MedicalRecord>();
        expectedRecords.add(testRecord);

        victim.addMedicalRecord(testRecord);
        ArrayList<MedicalRecord> actualRecords = victim.getMedicalRecords();
        
        if (expectedRecords.size() != actualRecords.size()) {
            correct = false;
        } else {
            int i;
            for (i=0;i<expectedRecords.size();i++) {
                if (!actualRecords.get(i).equals(expectedRecords.get(i))) {
                    correct = false;
                }
            }
        }
        assertTrue("addMedicalRecords should add the medical record to medicalRecords", correct);

    }
}





