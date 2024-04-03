package edu.ucalgary.oop;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReliefService{
    private Inquirer inquirer;
    private DisasterVictim missingPerson;
    private String dateOfInquiry;
    private String infoProvided;
    private Location lastKnownLocation;
    private static final String REGEX = "\\d{4}-\\d{2}-\\d{2}";
	private static final Pattern PATTERN = Pattern.compile(REGEX);

    public ReliefService(Inquirer inquirer, DisasterVictim missingPerson,
            String dateOfInquiry, String infoProvided, Location lastKnownLocation){
        this.inquirer = inquirer;
        this.missingPerson = missingPerson;
        this.dateOfInquiry = dateOfInquiry;
        this.infoProvided = infoProvided;
        this.lastKnownLocation = lastKnownLocation;
    }
    
    /*setters*/

    public void setInquirer(Inquirer inquirer){ this.inquirer = inquirer;}
    public void setMissingPerson(DisasterVictim missingPerson){ this.missingPerson = missingPerson;}
    public void setDateOfInquiry(String dateOfInquiry) throws IllegalArgumentException{
        Matcher match = PATTERN.matcher(dateOfInquiry);
        boolean valid_date = match.find();

        if(!valid_date){
            throw new IllegalArgumentException("Invalid format for date. Please use format: YYYY-MM-DD.");
        }
        this.dateOfInquiry = dateOfInquiry;
    }
    public void setInfoProvided(String infoProvided){ this.infoProvided = infoProvided;}
    public void setLastKnownLocation(Location lastKnowLocation){ this.lastKnownLocation = lastKnowLocation;}

    /*getters*/

    public Inquirer getInquirer(){ return this.inquirer;}
    public DisasterVictim getMissingPerson(){ return this.missingPerson;}
    public String getDateOfInquiry(){ return this.dateOfInquiry;}
    public String getInfoProvided(){ return this.infoProvided;}
    public Location getLastKnownLocation(){ return this.lastKnownLocation;}
    public String getLogDetails() {
        return "Inquirer: " + this.getInquirer().getFirstName() +
        ", Missing Person: " + this.getMissingPerson().getFirstName() +
        ", Date of Inquiry: " + this.getDateOfInquiry() +
        ", Info Provided: " + this.getInfoProvided() +
        ", Last Known Location: " + this.getLastKnownLocation().getName();
    }
}


