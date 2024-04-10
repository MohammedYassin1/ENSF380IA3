package edu.ucalgary.oop;
import java.util.Scanner;


public class DisasterVictimInterface {
    static public DisasterVictim generateDisasterVictim(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Entry date: ");
        String ENTRY_DATE = scanner.nextLine();
        System.out.print("Enter first name: ");
        String firstName = scanner.nextLine();
        DisasterVictim victim = new DisasterVictim(firstName, ENTRY_DATE);
        Location locn = new Location("location", "address");
        victim.setLocation(locn);

        System.out.print("Enter last name: ");
        String lastName = scanner.nextLine();
        victim.setLastName(lastName);

        System.out.print("Enter height in cm: ");
        int height = Integer.parseInt(scanner.nextLine());
        victim.setHeight(height);

        System.out.print("Enter weight in lb: ");
        int weight = Integer.parseInt(scanner.nextLine());
        victim.setWeight(weight);
        
        System.out.print("Enter gender: ");
        String gender = scanner.nextLine();
        victim.setGender(gender);
        
        System.out.print("Enter date of birth (1) or an aprox age (2) : ");
        if (scanner.nextLine().equals("1")){
            System.out.print("Enter date of birth: ");
            String dob_age = scanner.nextLine();
            victim.setDateOfBirth(dob_age);
        } else {
            System.out.print("Enter aprox age: ");
            int dob_age = Integer.parseInt(scanner.nextLine());
            victim.setAproxAge(dob_age);
        }
        
        System.out.print("Enter comments: ");
        String comments = scanner.nextLine();
        victim.setComments(comments);

        String input = "";
        while(input != "q"){
            System.out.print("Do you want to enter a medical record(c to continue or q to quit): ");
            input = scanner.nextLine();
            if (input.equals("q")){
                break;
            }
            System.out.print("Enter location name in medical record: ");
            String location = scanner.nextLine();
            System.out.print("Enter location address in medical record: ");
            String address = scanner.nextLine();
            Location loc = new Location(location, address);
            System.out.print("Enter date in medical record: ");
            String date = scanner.nextLine();
            System.out.print("Enter description in medical record: ");
            String description = scanner.nextLine();
            MedicalRecord record = new MedicalRecord(loc, description, date);
            victim.addMedicalRecord(record);
        }
        
        input = "";
        while(input != "q"){
            System.out.print("Do you want to enter a family connection(c to continue or q to quit): ");
            input = scanner.nextLine();
            if (input.equals("q")){
                break;
            }
            System.out.print("Enter first name of family member: ");
            String f_name = scanner.nextLine();
            System.out.print("Enter entry date of family member: ");
            String eDate = scanner.nextLine();
            System.out.print("Enter relation to the victim: ");
            String relation = scanner.nextLine();

            DisasterVictim family = new DisasterVictim(f_name, eDate);

            FamilyRelation familyRelation = new FamilyRelation(victim, relation, family);
            victim.addFamilyConnection(familyRelation);
        }
        
        input = "";
        while(input != "q"){
            System.out.print("Do you want to enter a personal belonging(c to continue or q to quit): ");
            input = scanner.nextLine();
            if (input.equals("q")){
                break;
            }
            System.out.print("Enter type of belonging: ");
            String type = scanner.nextLine();
            System.out.print("Enter quantity of belonging: ");
            int quantity = Integer.parseInt(scanner.nextLine());
            Supply supply = new Supply(type, quantity);
            victim.addSupply(supply);
        }

        scanner.close();
        
        return victim;
    }
    
}
