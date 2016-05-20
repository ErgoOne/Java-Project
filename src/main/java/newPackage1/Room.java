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
public class Room {
    private String lastmsgDate;//TO DO implement function to verify our last date with the server
    HashMap<User, Mesg> chat=new HashMap<>();// Les auteurs et msg dans la room
    
    public void addMesg(User u, Mesg m)
    {
        chat.put(u, m);
        //TO DO function on dbutilities to add the msg to the DB
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getNom() {
        return nom;
    }
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
    

   public void Hello()
    {
        System.out.println("\nROOM : "+getNom()+" "+getDesc()+"");
    }

}
