/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newPackage1;

/**
 *
 * @author Badr
 */
public class Room {
    private String nom;
    private String desc;
    
    public Room (String n, String d)
    {
        this.nom=n;
         this.desc=d;
    }

    String getName() {
        return nom;
    }
    String getDesc() {
        return desc;
    }
    
}
