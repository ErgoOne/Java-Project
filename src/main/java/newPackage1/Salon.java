/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newPackage1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;


/**
 *
 * @author Badr
 */
public class Salon {
    private int nbUsers;
    private String host;

    public int getNbUsers() {
        return nbUsers;
    }

    public String getHost() {
        return host;
    }

    public void setNbUsers(int nbUsers) {
        this.nbUsers = nbUsers;
    }

    public void setHost(String host) {
        this.host = host;
    }
    
    public Salon() {
    }
   ArrayList<Room> rooms= new ArrayList<>();
   
   public void addRoom(Room r)
   {
       rooms.add(r);
   }
   
   public HashMap<String, String> getSalon()
   {
    HashMap<String, String> h = new HashMap<>();
    for(Room R : rooms){
	h.put(R.getName(), R.getDesc());
	}       
    return h;
   } 
   
   
}
