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

/*C'est une classe message permettant de créer et attribuer à chaque objet message,
  une date et un type string que nous pourrons utiliser dans une autre classe.*/
public class Mesg {
    private String msg;
    private String date;

    
    public Mesg(String msg) {
        this.msg = msg;
  
    }

    public String getMsg() {
        return msg;
    }

    public String getDate() {
        return date;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
    
    
}
