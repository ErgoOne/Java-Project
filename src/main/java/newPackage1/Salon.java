/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newPackage1;

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
   HashMap<String , String> rooms= new HashMap<>();
   
   public void addRoom(String r, String d)
   {
       rooms.put(r, d);
   }
   
   public void getSalon()
   {
       Set cles = rooms.keySet();
        Iterator it = cles.iterator();
        while (it.hasNext()){
           Object cle = it.next(); 
           String valeur = rooms.get(cle); 
           System.out.println(cle+ " "+valeur);
           // TO DO customiser ici ou dans principale pour recuperer mieux les attributs pour les afficher.
        }
   }
    
}
