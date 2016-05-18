/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newPackage1;

import java.util.HashMap;
import java.util.Map;
import static newPackage1.DButilities.auth;
import static newPackage1.DButilities.getDroitUR;

/**
 *
 * @author Badr
 */
public class NewClass {

    public static void main(String[] args) {
        //--
        TypeDroit test;
        int tmp;
        User u1 = new User("Margx");
        
        Room r1 = new Room("R1");
        //Room r2 = new Room();
        //--
        test=getDroitUR(u1,r1);
        System.out.println("res : "+test);
        tmp=auth(u1);
        System.out.println("\nAuth : "+tmp);
        
        
        
        
        /*Map<Room, TypeDroit> du1 = new HashMap<>();
        du1.put(r2, TypeDroit.NONE);
        du1.put(r1, TypeDroit.RW);
        Droit droit = new Droit(u1,du1);*/
        
        
    }

}
