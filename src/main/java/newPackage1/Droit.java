/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newPackage1;

import java.util.List;
import java.util.Map;

/**
 *
 * @author Badr
 */
public class Droit {

    User user;
   // Map<TypeDroit, List<Room>> doit;
    Map<Room, TypeDroit> doirpourrouu;

    Droit(User u1, Map<Room, TypeDroit> du1) {
        this.user=u1;
        this.doirpourrouu=du1;
    }
}
