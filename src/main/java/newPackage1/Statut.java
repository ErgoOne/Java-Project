/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newPackage1;

import java.util.HashMap;

/**
 *
 * @author Badr
 */
public class Statut { // Permet d'avoir la relation entre les entrés de la base pour les statut et les entrés 
    // de la combobox de l'application.
    
    public String getstat(String s){
    HashMap<String, String> stat= new HashMap<>();
         stat.put("off", "Hors ligne");
         stat.put("on", "En ligne");
         stat.put("abs", "Occupé");
         stat.put("Occupé", "abs");
         stat.put("En ligne", "on");
         stat.put("Hors ligne", "off");
    return stat.get(s);
    }

    public Statut() {
    }
    
}
