package edu.ucalgary.oop;
import java.util.ArrayList;

public class LogInquirer {
    private ArrayList<ReliefService> log;
    private Inquirer inquirer;

    public LogInquirer(ArrayList<ReliefService> log ,Inquirer inquirer){
        this.log = log;
        this.inquirer = inquirer;
    }

    /*getters*/
    public ArrayList<ReliefService> getLog() { return this.log;}
    public Inquirer getInquirer() { return this.inquirer;}

    /*setters*/
    public void setLog(ArrayList<ReliefService> log) { this.log = log;}
    public void setInquirer(Inquirer inquirer) { this.inquirer = inquirer;}

    /*functions*/
    public void addLog(ReliefService service){this.log.add(service);}
    
}
