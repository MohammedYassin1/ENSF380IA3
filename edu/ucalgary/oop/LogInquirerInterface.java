package edu.ucalgary.oop;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * Note to TA: Previous code kept giving me no line error in generateLogInquirer, so I had to rewrite the code.
 * public static LogInquirer generateLogInquirer(Location loca){
        ArrayList<ReliefService> log = new ArrayList<ReliefService>();
        Scanner scanner = new Scanner(System.in);
        String input = "";
        while(input != "q"){
            System.out.print("Do you want to generate a new relief service(q to quit): ");
            if (scanner.hasNextLine()) {
                input = scanner.nextLine();
            } else {
                System.out.println("No more input");
                input = scanner.nextLine();
            }
            if (input.equals("q")){
                scanner.close();
                return null;
            }
            ReliefService reliefService = generateReliefService(loca);
            log.add(reliefService);

        }
        
        return new LogInquirer(log, log.get(0).getInquirer());
    }
 */ 

public class LogInquirerInterface {
    public static LogInquirer generateLogInquirer(Location loca){
        ArrayList<ReliefService> log = new ArrayList<ReliefService>();
        Scanner scanner = new Scanner(System.in);
        String input = "";
        
        System.out.print("Do you want to generate a new relief service(q to quit): ");
        input = scanner.nextLine();
            
        if (input.equals("q")){
            scanner.close();
            if (log.size() == 0){
                return null;
            }
        }
        ReliefService reliefService = generateReliefService(loca);
        log.add(reliefService);

        
        
        return new LogInquirer(log, log.get(0).getInquirer());
    }

    public static ReliefService generateReliefService(Location loca){
        Scanner scanner2 = new Scanner(System.in);
        System.out.print("Enter date of inquiry:");
        String date = scanner2.nextLine();
        System.out.print("Enter info provided:");
        String info = scanner2.nextLine();
        System.out.print("Enter first name for the inquirer: ");
        String firstName = scanner2.nextLine();
        System.out.print("Enter last name for the inquirer: ");
        String lastName = scanner2.nextLine();
        System.out.print("Enter phone number for the inquirer: ");
        String phone = scanner2.nextLine();
        System.out.print("Enter any related infromation to the inquirer: ");
        String information = scanner2.nextLine();
        
        DisasterVictim victim = LogInquirerInterface.searchDisasterVictim(loca);
        Inquirer inquirer = new Inquirer(firstName, date, phone, information);
        scanner2.close();
        return new ReliefService(inquirer, victim, date, info, loca);
    }
    
    public static DisasterVictim searchDisasterVictim(Location location){
        Scanner scanner1 = new Scanner(System.in);
        String input = "";
        while(input != "q"){

            System.out.print("Please enter first or last name of the vicitim (q to quit): ");
            input = scanner1.nextLine();
            if (input.equals("q")){
                scanner1.close();
                return null;
            }
            int count = 0;
            ArrayList<DisasterVictim> occupants = new ArrayList<DisasterVictim>();
            for( DisasterVictim victim : location.getOccupants()){
                if (victim.getFirstName() != null){
                    if (victim.getFirstName().toLowerCase().contains(input.toLowerCase())){    
                        System.out.println(count +". "+victim.getFirstName() + " " + victim.getLastName());
                        occupants.add(victim);
                    }
                }   
                else if (victim.getLastName()!= null){
                    if (victim.getLastName().toLowerCase().contains(input.toLowerCase())){
                        System.out.println(count +". "+victim.getFirstName() + " " + victim.getLastName());
                        occupants.add(victim);
                    }
                }
            }
            System.out.print("Please enter the number of the vicitim you are looking for(q to quit or c to go back to search): ");
            input = scanner1.nextLine();
            if (input.equals("q")){
                break;
            } 
            else if (input.equals("c")){
                continue;
            }
            else {
                scanner1.close();
                return occupants.get(Integer.parseInt(input));
            }
        }
        return null;
        
    } 
}
