/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newPackage1;

import java.util.HashMap;
import static newPackage1.DButilities.getDateMsg;

/**
 *
 * @author Badr
 */
public class Room {
    private String lastmsgDate;//TO DO implement function to verify our last date with the server
    HashMap<User, Mesg> chat=new HashMap<>();// Les auteurs et msg dans la room
    
    public void addMesg(User u, Mesg m)
    {
        String date;
        chat.put(u, m);
        date=getDateMsg(m);
        int cmp;
        if(lastmsgDate!=null){
                    cmp=date.compareTo(lastmsgDate);
                    if(cmp<0){
                        lastmsgDate=date;
                    }
        }
        else if(lastmsgDate==null){
                lastmsgDate=date;
            }
        
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
    String getLastDate(){
        return lastmsgDate;
    }

   public void Hello()
    {
        System.out.println("\nROOM : "+getNom()+" "+getDesc()+"");
    }

}
