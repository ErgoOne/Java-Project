/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newPackage1;

import java.sql.Connection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Vector;
import static newPackage1.DButilities.getDateMsg;

/**
 *
 * @author Badr
 */

//Informations à récuperer par le serveur pour le salon.
public class Room {
    
    private String lastmsgDate;
    HashMap<User, Mesg> chat=new HashMap<>();// Les auteurs et msg dans la room
    private static Vector classes = new Vector();
    static Connection con;
    
    
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
    }

    public void setLastmsgDate(String lastmsgDate) {
        this.lastmsgDate = lastmsgDate;
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

  
  
   	public static Room getInstance(String attribut1, String attribut2) {
            
		Room tmp = new Room(attribut1, attribut2);
		if (classes.contains(tmp)) {
			Enumeration enume = classes.elements();
			while (enume.hasMoreElements()) {
				Room element = (Room) enume.nextElement();
				if (element.equals(tmp)) {
					return element;
				}
			}
		}
		else {
			classes.add(tmp);
			return tmp;
		}
                    return null;
	}
 


}
