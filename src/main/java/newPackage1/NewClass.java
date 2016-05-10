/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newPackage1;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Badr
 */
public class NewClass {

    public static void main(String[] args) {
        //--
        User u1 = new User();
        
        Room r1 = new Room();
        Room r2 = new Room();
        //--
        
        
        Map<Room, TypeDroit> du1 = new HashMap<>();
        du1.put(r2, TypeDroit.NONE);
        du1.put(r1, TypeDroit.RW);
        Droit droit = new Droit(u1,du1);
    }

}
