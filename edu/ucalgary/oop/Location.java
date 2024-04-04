package edu.ucalgary.oop;

import java.util.ArrayList;

public class Location implements addRemoveSupply{
    private String name;
    private String address;
    private ArrayList<DisasterVictim> occupants;
    private ArrayList<Supply> supplies;

    public Location(String name, String address){
        this.name = name;
        this.address = address;
        this.occupants = new ArrayList<DisasterVictim>();
        this.supplies = new ArrayList<Supply>();
    }
    /*setters*/

    public void setName(String name){ this.name = name;}
    public void setAddress(String address){ this.address = address;}
    public void setOccupants(ArrayList<DisasterVictim> occupants){ this.occupants = occupants;}
    public void setSupplies(ArrayList<Supply> supplies){ this.supplies = supplies;}

    /*getters */

    public String getName(){ return this.name;}
    public String getAddress(){ return this.address;}
    public ArrayList<DisasterVictim> getOccupants(){ return this.occupants;}
    public ArrayList<Supply> getSupplies(){ return this.supplies;}
    
    /*functions*/

    public void addOccupant(DisasterVictim occupant){ this.occupants.add(occupant);}
    public void removeOccupant(DisasterVictim occupant){ this.occupants.remove(occupant);}
    @Override
    public void addSupply(Supply supply){ 
        for (Supply s : this.supplies){
            if (s.getType().equals(supply.getType())){
                s.setQuantity(s.getQuantity() + supply.getQuantity());
                return;
            }
        }
        this.supplies.add(supply);
    }
    @Override
    public void removeSupply(Supply supply){ this.supplies.remove(supply);}
    
    public void decrementSupply(String supply, int amount ){ 
        for (Supply s : this.supplies){
            if (s.getType().equals(supply)){
                s.setQuantity(s.getQuantity() - amount);
            }
        }
    }
}