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

//Classe contenant une ou plusieurs room 
public class Salon {
    private int nbUsers; 
    private String host; 

    //Getteur et setteur de la class
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
    
    //Constructeur
    public Salon() {
    }
    
    //Arraylist de rooms
    ArrayList<Room> rooms= new ArrayList<>();
   
    //Methode d'ajout de room au salon
    public void addRoom(Room r)
    {
       rooms.add(r);
     }
   
    //Afficher le salon en utilisant une HashMap
    public HashMap<String, String> getSalon()
     {
        //Place le nom et la description de chaque room parcurue qui sont dans l'array list , dans la hash map
        HashMap<String, String> h = new HashMap<>(); 
        for(Room R : rooms){
            h.put(R.getName(), R.getDesc());
            }       
    return h;
    } 
   
}
