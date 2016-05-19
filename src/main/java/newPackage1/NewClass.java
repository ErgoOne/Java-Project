/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newPackage1;

import java.util.HashMap;
import java.util.Map;
import static newPackage1.DButilities.auth;
import static newPackage1.DButilities.AfficherRoom;
import static newPackage1.DButilities.CreerRoom;
import static newPackage1.DButilities.getDroitUR;
import static newPackage1.DButilities.getUser;

/**
 *
 * @author Badr
 */
public class NewClass {

    public static void main(String[] args) {
        //--
        TypeDroit test;
        int tmp;
        User u1 = new User("atila");
        getUser(u1);

      
        String texte="Salon de css";
        Room r1 = new Room("R1","blabla");
        //Room r2 = new Room();
        //--
        /*test=getDroitUR(u1,r1);
        System.out.println("res : "+test);*/

       
        AfficherRoom(); //Requete sql pour afficher les rooms enregistrée dans la bdd
       /* CreerRoom(r1,texte,u1);*/

     
        /*Map<Room, TypeDroit> du1 = new HashMap<>();
        du1.put(r2, TypeDroit.NONE);
        du1.put(r1, TypeDroit.RW);
        Droit droit = new Droit(u1,du1);*/
        
        
    }

}
