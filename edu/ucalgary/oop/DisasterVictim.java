package edu.ucalgary.oop;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.*;

public class DisasterVictim implements AddRemoveSupply{
    private String firstName;
    private String lastName;
    private Location location;
    private int height;
    private int weight;
    private int aproxAge;
    private String dateOfBirth;
    private String comments;
    private final int ASSIGNED_SOCIAL_ID;
    private ArrayList<MedicalRecord> medicalRecords;
    private ArrayList<FamilyRelation> familyConnections;
    private final String ENTRY_DATE;
    private ArrayList<Supply> personalBelongings;
    private String gender;
    private ArrayList<DietaryRestriction> dietaryRestrictions;
    private static int counter = 0;
    private static final String REGEX = "\\d{4}-\\d{2}-\\d{2}";
	private static final Pattern PATTERN = Pattern.compile(REGEX);

    //Const
    public DisasterVictim() {
        this.firstName = null;
        this.ENTRY_DATE = null;
        this.lastName = null;
        this.dateOfBirth = null;
        this.comments = null;
        this.ASSIGNED_SOCIAL_ID = counter++;
        this.medicalRecords = new ArrayList<MedicalRecord>();
        this.familyConnections = new ArrayList<FamilyRelation>();
        this.personalBelongings = new ArrayList<Supply>();
        this.gender = null;
        this.dietaryRestrictions = new ArrayList<DietaryRestriction>();
    }

    public DisasterVictim(String firstName, String ENTRY_DATE) throws IllegalArgumentException{
        /*add if statment and IllegalArgumentExcemption */
        Matcher match = PATTERN.matcher(ENTRY_DATE);
        boolean valid_date = match.find();

        if(!valid_date){
            throw new IllegalArgumentException("Invalid format for date. Please use format: YYYY-MM-DD.");
        }
        this.firstName = firstName;
        this.ENTRY_DATE = ENTRY_DATE;

        this.lastName = null;
        this.dateOfBirth = null;
        this.comments = null;
        this.ASSIGNED_SOCIAL_ID = counter++;
        this.medicalRecords = new ArrayList<MedicalRecord>();
        this.familyConnections = new ArrayList<FamilyRelation>();
        this.personalBelongings = new ArrayList<Supply>();
        this.gender = null;
    }

    //Getters
    public String getFirstName(){ return this.firstName;}

    public String getLastName(){ return this.lastName;}

    public Location getLocation(){ return this.location;}

    public String getDateOfBirth(){ return this.dateOfBirth;}

    public int getAproxAge(){ return this.aproxAge;}

    public int getHeight(){ return this.height;}

    public int getWeight(){ return this.weight;}

    public String getComments(){ return this.comments;}

    public int getAssignedSocialID(){ return this.ASSIGNED_SOCIAL_ID;}

    public ArrayList<MedicalRecord> getMedicalRecords(){
        return this.medicalRecords;
    }

    public ArrayList<FamilyRelation> getFamilyConnections(){
        return this.familyConnections;
    }

    public String getEntryDate(){ return this.ENTRY_DATE;}

    public ArrayList<Supply> getPersonalBelongings(){
        return this.personalBelongings;
    }

    public String getGender(){ return this.gender;}

    public ArrayList<DietaryRestriction> getDietaryRestriction(){
        return this.dietaryRestrictions;
    }

    //Setters
    public void setFirstName(String firstName){ this.firstName = firstName;}

    public void setLastName(String lastName){ this.lastName = lastName;}

    public void setLocation(Location location){ this.location = location;}

    public void setDateOfBirth(String dateOfBirth) throws IllegalArgumentException{
        Matcher match = PATTERN.matcher(dateOfBirth);
        boolean valid_date = match.find();

        if(!valid_date){
            throw new IllegalArgumentException("Invalid format for date. Please use YYYY-MM-DD.");
        }
        this.dateOfBirth = dateOfBirth;
        this.aproxAge = 0;
    }

    public void setAproxAge(int aproxAge) {
        if (this.dateOfBirth != null) {
            throw new IllegalArgumentException("dateOfBirth is already set");
        }
        this.aproxAge = aproxAge;
    }

    public void setComments(String comments){ this.comments = comments;}

    
    public void setGender(String gender) {
        String newGender = "";
        for(String gen:this.location.getGenders()){
            if (gen.equals(gender.toLowerCase())){
                newGender = gen;
                this.gender = newGender;
                return;
            }
        }
        for(String gen:this.location.getGenders()){
            if (gen.contains(gender.toLowerCase())){
                newGender = gen;
                this.gender = newGender;
                return;
            }
        }
        
        throw new IllegalArgumentException("Invalid gender: " + gender);
        
    }

    public void setHeight(int height){ this.height = height;}

    public void setWeight(int weight){ this.weight = weight;}

    public void setDietaryRestriction(ArrayList<DietaryRestriction> dietaryRestriction){
        this.dietaryRestrictions = dietaryRestriction;
    }

    public void setMedicalRecords(ArrayList<MedicalRecord> medicalRecords){
        this.medicalRecords = medicalRecords;
    }

    public void setFamilyConnections(ArrayList<FamilyRelation> familyConnections){
        this.familyConnections = familyConnections;
    }

    public void setPersonalBelongings(ArrayList<Supply> personalBelongings){
        this.personalBelongings = personalBelongings;
    }
    
    public void addSupply(Supply supply) {
        this.personalBelongings.add(supply);
        this.location.decrementSupply(supply.getType(), supply.getQuantity());  
    }

    public void removeSupply(Supply supply) {
        this.personalBelongings.remove(supply);
    }

    
    public void addFamilyConnection(FamilyRelation familyConnection) {
        //this is always personOne
        for (FamilyRelation family : this.familyConnections) {
            if (family.getPersonTwo() == familyConnection.getPersonTwo()) {
                //2 people can't have multiple relationships with each other
                throw new IllegalArgumentException("familyConnection already exists");
            }
        }

        this.familyConnections.add(familyConnection);

        FamilyRelation newFamily = new FamilyRelation(familyConnection.getPersonTwo(), familyConnection.getRelationshipTo(), this);

        ArrayList<FamilyRelation> family1 = this.getFamilyConnections();
        ArrayList<FamilyRelation> family2 = familyConnection.getPersonTwo().getFamilyConnections();

        family2.add(newFamily);
        familyConnection.getPersonTwo().setFamilyConnections(family2);

        if(familyConnection.getRelationshipTo() == "sibling"){
            int i;
            for(i = 0; i < family2.size() - 1; i++){
                if(family2.get(i).getRelationshipTo() == "sibling"){
                    FamilyRelation newRelation1 = new FamilyRelation(this, "sibling", family2.get(i).getPersonTwo());
                    FamilyRelation newRelation2 = new FamilyRelation(family2.get(i).getPersonTwo(), "sibling", this);
                    ArrayList<FamilyRelation> family3 = family2.get(i).getPersonTwo().getFamilyConnections();
                    ArrayList<FamilyRelation> tempFamily1 = this.getFamilyConnections();
                    tempFamily1.add(newRelation1);
                    family3.add(newRelation2);
                    this.setFamilyConnections(tempFamily1);
                    family2.get(i).getPersonTwo().setFamilyConnections(family3);
                }
            }
            for(i = 0; i < family1.size() - 1; i++){
                if(family1.get(i).getRelationshipTo() == "sibling"){
                    FamilyRelation newRelation1 = new FamilyRelation(familyConnection.getPersonTwo(), "sibling", family1.get(i).getPersonTwo());
                    FamilyRelation newRelation2 = new FamilyRelation(family1.get(i).getPersonTwo(), "sibling", familyConnection.getPersonTwo());
                    ArrayList<FamilyRelation> family3 = family1.get(i).getPersonTwo().getFamilyConnections();
                    ArrayList<FamilyRelation> tempFamily2 = familyConnection.getPersonTwo().getFamilyConnections();
                    tempFamily2.add(newRelation1);
                    family3.add(newRelation2);
                    familyConnection.getPersonTwo().setFamilyConnections(tempFamily2);
                    family1.get(i).getPersonTwo().setFamilyConnections(family3);
                }
            }
        }
    }

    public void removeFamilyConnection(FamilyRelation familyConnection) {
        this.familyConnections.remove(familyConnection);
        ArrayList<FamilyRelation> family = familyConnection.getPersonTwo().getFamilyConnections();
        for(int i = 0; i < family.size(); i++){
            if(family.get(i).getPersonTwo() == this){
                ArrayList<FamilyRelation> tempFamily = family;
                family.remove(i);
                familyConnection.getPersonTwo().setFamilyConnections(family);
                return;
            }
        }
    }

    public void addMedicalRecord(MedicalRecord medicalRecord) {
        this.medicalRecords.add(medicalRecord);
    }

    
}