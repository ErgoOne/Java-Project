/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newPackage1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static newPackage1.DButilities.AfficherNvMess;
import static newPackage1.DButilities.AfficherUtilisateur;
import static newPackage1.DButilities.CreerMsg;
import static newPackage1.DButilities.auth;
import static newPackage1.DButilities.CreerRoom;
import static newPackage1.DButilities.getDerMsgDate;
import static newPackage1.DButilities.getDroitUR;
import static newPackage1.DButilities.getRoom;
import static newPackage1.DButilities.getUser;
import static newPackage1.DButilities.putRoomtoSalon;

/**
 *
 * @author Badr
 */
public class NewClass {

    public static void main(String[] args) {
        //--
       // TypeDroit test;
        //int tmp;
        User u1 = new User("atila");
        Salon s= new Salon();
        Room r1 = new Room("R8","bob marley");
        Room r2= new Room("R7", "bob");
        //getUser(u1);
        
       //Creation de room
        /*
        int count=s.rooms.size();
        //int i=0;
        Room[] myArray = new Room[count+1]; 
        //for(i=0;i<count;i++){
            myArray[count] = new Room(String.valueOf(count),"a");
            CreerRoom(myArray[count],u1);
        //}
        */
        //Creation de message
        
	//int numero=r1.chat.size();
        /*
        int numero=3;
        Mesg[] Arraymsg =new Mesg[numero+1];
        
        Arraymsg[numero] = new Mesg(String.valueOf(numero));
        CreerMsg(Arraymsg[numero],u1,r2);
        r2.addMesg(u1,Arraymsg[numero]);
        */
        
        //Afficher les derniers messages
        
        //System.out.println(r2.getLastDate());
        //AfficherNvMess(getDerMsgDate(u1));
        
        //Room r1 = new Room("R8","bob marley");
       
        //Room r = Room.getInstance("R2", "Salon de World Of Warcraft");
        //Room r = Room.getInstance("R8", "bob marley");
        //System.out.println(r.getNom());
        
        //AfficherNvMess(getDerMsgDate(u1,r),r);
        //getRoom(r1);
        //Room r2 = new Room();
        //--
        /*test=getDroitUR(u1,r1);
        System.out.println("res : "+test);*/

       
      //Requete sql pour afficher les rooms enregistrée dans la bdd
       /* CreerRoom(r1,texte,u1);*/
        //CreerRoom(r1, u1);
        //putRoomtoSalon(s);
        //s.getSalon();
     
        /*Map<Room, TypeDroit> du1 = new HashMap<>();
        du1.put(r2, TypeDroit.NONE);
        du1.put(r1, TypeDroit.RW);
        Droit droit = new Droit(u1,du1);*/
        DButilities.getdate();
        
    }

}
