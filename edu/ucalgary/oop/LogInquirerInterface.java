package edu.ucalgary.oop;
import java.util.ArrayList;
import java.util.Scanner;

public class LogInquirerInterface {
    public static LogInquirer generateLogInquirer(Location loca){
        ArrayList<ReliefService> log = new ArrayList<ReliefService>();
        Scanner scanner = new Scanner(System.in);
        String input = "";
        while(input != "q"){
            System.out.print("Do you want to generate a new relief service(q to quit): ");
            input = scanner.nextLine();
            if (input.equals("q")){
                scanner.close();
                break;
            }
            ReliefService reliefService = generateReliefService(loca);
            log.add(reliefService);

        }
        
        return new LogInquirer(log, log.get(0).getInquirer());
    }

    public static ReliefService generateReliefService(Location loca){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter date of inquiry:");
        String date = scanner.nextLine();
        System.out.print("Enter info provided:");
        String info = scanner.nextLine();
        System.out.print("Enter first name for the inquirer: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter last name for the inquirer: ");
        String lastName = scanner.nextLine();
        System.out.print("Enter phone number for the inquirer: ");
        String phone = scanner.nextLine();
        System.out.print("Enter any related infromation to the inquirer: ");
        String information = scanner.nextLine();
        scanner.close();
        DisasterVictim victim = LogInquirerInterface.searchDisasterVictim(loca);
        Inquirer inquirer = new Inquirer(firstName, date, phone, information);
        return new ReliefService(inquirer, victim, date, info, loca);
    }
    
    public static DisasterVictim searchDisasterVictim(Location location){
        String input = "";
        while(input != "q"){
            Scanner scanner = new Scanner(System.in);
            System.out.print("Please enter first or last name of the vicitim (q to quit): ");
            input = scanner.nextLine();
            if (input.equals("q")){
                scanner.close();
                break;
            }
            int count = 0;
            ArrayList<DisasterVictim> occupants = new ArrayList<DisasterVictim>();
            for( DisasterVictim victim : location.getOccupants()){
                if (victim.getFirstName().toLowerCase().contains(input.toLowerCase()) || victim.getLastName().toLowerCase().contains(input.toLowerCase())){
                    System.out.print(count +". "+victim.getFirstName() + " " + victim.getLastName());
                    occupants.add(victim);
                } 
            }
            System.out.print("Please enter the number of the vicitim you are looking for(q to quit or c to go back to search): ");
            input = scanner.nextLine();
            if (input.equals("q")){
                break;
            } 
            else if (input.equals("c")){
                continue;
            }
            else {
                scanner.close();
                return occupants.get(Integer.parseInt(input));
            }
        }
        return null;
        
    }
    
}
