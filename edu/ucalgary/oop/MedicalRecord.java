package edu.ucalgary.oop;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MedicalRecord{
    private Location location;
    private String treatmentDetails;
    private String dateOfTreatment;
    private static final String REGEX = "\\d{4}-\\d{2}-\\d{2}";
	private static final Pattern PATTERN = Pattern.compile(REGEX);

    public MedicalRecord(Location location, String treatmentDetails, String dateOfTreatment) throws IllegalArgumentException{
        Matcher match = PATTERN.matcher(dateOfTreatment);
        boolean valid_date = match.find();

        if(!valid_date){
            throw new IllegalArgumentException("Invalid format for date. Please use format: YYYY-MM-DD.");
        }
        this.location = location;
        this.treatmentDetails = treatmentDetails;
        this.dateOfTreatment = dateOfTreatment;
    }
    /*setters*/

    public void setLocation(Location location){ this.location = location;}
    public void setTreatmentDetails(String treatmentDetails){ this.treatmentDetails = treatmentDetails;}
    public void setDateOfTreatment(String dateOfTreatment) throws IllegalArgumentException{
        Matcher match = PATTERN.matcher(dateOfTreatment);
        boolean valid_date = match.find();

        if(!valid_date){
            throw new IllegalArgumentException("Invalid format for date. Please use format: YYYY-MM-DD.");
        }
        this.dateOfTreatment = dateOfTreatment;
    }


    /*getters*/

    public Location getLocation(){ return this.location;}
    public String getTreatmentDetails(){ return this.treatmentDetails;}
    public String getDateOfTreatment(){ return this.dateOfTreatment;}
}
