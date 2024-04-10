package edu.ucalgary.oop;


import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

public class FamilyRelationTest {

    private DisasterVictim personOne;
    private DisasterVictim personTwo;
    private String relationshipTo;
    private FamilyRelation testFamilyRelationObjectOne;

    @Before
    public void setUp() {
        personOne = new DisasterVictim("Chris", "2024-01-01");
        personTwo = new DisasterVictim("Joe", "2024-02-02");
        relationshipTo = "sibling";
        testFamilyRelationObjectOne = new FamilyRelation(personOne, relationshipTo, personTwo );
    }
    
    @Test
    public void testObjectCreation() {
        assertNotNull("Constructor should Initilize an instance of FamilyRelation", testFamilyRelationObjectOne);
    }
	
    @Test
    public void testSetAndGetPersonOne() {
        FamilyRelation testFamilyRelationObjectThree = new FamilyRelation();
        DisasterVictim individualOne = new DisasterVictim("Chris", "2024-01-01"); 
        testFamilyRelationObjectThree.setPersonOne(individualOne);
        assertEquals("setPersonOne and getPersonOne should update and give personOne", individualOne, testFamilyRelationObjectThree.getPersonOne());
    }

    @Test
    public void testSetAndGetPersonTwo() {
        FamilyRelation testFamilyRelationObjectFour = new FamilyRelation();
        DisasterVictim individualTwo = new DisasterVictim("Sam", "2024-02-02");
        testFamilyRelationObjectFour.setPersonTwo(individualTwo);
        assertEquals("setPersonTwo and getPersonTwo should update and give personTwo", individualTwo, testFamilyRelationObjectFour.getPersonTwo());
    }

    @Test
    public void testSetAndGetRelationshipTo() {
        FamilyRelation newRelationship = new FamilyRelation();
        String relation = "parent";
        newRelationship.setRelationshipTo(relation);
        assertEquals("setRelationshipTo and getRelationshipTo should update and get the relationshipTO", relation, newRelationship.getRelationshipTo());
    }
}
