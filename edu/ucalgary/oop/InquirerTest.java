package edu.ucalgary.oop;

import org.junit.*;
import static org.junit.Assert.*;


public class InquirerTest {
    private String firstName;
    private String lastName;
    private String servicePhoneNumber;
    private String message;
    private Inquirer inquirer;

    @Before
    public void setUp() {
        firstName = "James";
        lastName = "Doe";
        servicePhoneNumber = "403-323-7321";
        message = "Looking for my mother, Jane Doe.";
        inquirer = new Inquirer(firstName, lastName, servicePhoneNumber, message);
    }
/* 
    @Test
    public void testInheritance() {
        assertTrue("Inquirer should be an instance of DisasterVictim", inquirer instanceof DisasterVictim);
    }
*/
    @Test
    public void testObjectCreation() {
        assertNotNull("Inquirer constructor should create instance",inquirer);
    }

    @Test
    public void testGetFirstName() {
        String newFirstName = "John";
        lastName = "Doe";
        servicePhoneNumber = "403-323-7321";
        message = "Looking for my mother, Jane Doe.";
        Inquirer newInquirer = new Inquirer(newFirstName, lastName, servicePhoneNumber, message);
        assertEquals("getFirstName() should return inquirer's first name", newFirstName, newInquirer.getFirstName());
    }
	
    @Test
    public void testGetLastName() {
        String newLastName = "John";
        lastName = "Doe";
        servicePhoneNumber = "403-323-7321";
        message = "Looking for my mother, Jane Doe.";
        Inquirer newInquirer = new Inquirer(firstName, newLastName, servicePhoneNumber, message);
        assertEquals("getLastName() should return inquirer's last name", newLastName, newInquirer.getLastName());
    }
	
    @Test
    public void testGetServicesPhoneNum() {
        assertEquals("getServicesPhoneNum() should return the correct Services Number", servicePhoneNumber, inquirer.getServicesPhoneNum());
    }
	
    @Test
    public void testGetInfo() {
        assertEquals("getInfo() should return the inquirer message", message,inquirer.getInfo());
    }

}

