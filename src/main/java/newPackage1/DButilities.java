/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newPackage1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Badr
 */

public class DButilities {
    

    static int auth(String user){
    int tmp;
    try {
            Class.forName("com.mysql.jdbc.Driver");
            /*make connection with the database*/
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/java_chat", "root", "");/* red colored part has to be as per your database*/
            String sql = "Select pseudo from users where pseudo='"+user+"'";

            /*          + utilisateur.getPseudo()
                    + "' AND nom='" + r.getName()
                    + "'  ";*/
 /*select instances from the table*/
            System.err.println(sql);

            PreparedStatement statement = con.prepareStatement(sql);
            //statement.setString(1, user.getPseudo());
            /*execution of the database query*/
            ResultSet result = statement.executeQuery();
            //map mp
            /*print the result with three attributes from the table 'products in my case' */
            if (result.next()){
            tmp = 1;
            }
            else {tmp = 0;}
         

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DButilities.class.getName()).log(Level.SEVERE, null, ex);
            tmp =0;
        }
    return tmp;
    }
    static TypeDroit getDroitUR(User utilisateur, Room r) {
        TypeDroit tmp = TypeDroit.none;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            /*make connection with the database*/
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/java_chat", "root", "");/* red colored part has to be as per your database*/
            String sql = "Select type_droit from acceder where pseudo=? and nom=?";

            /*          + utilisateur.getPseudo()
                    + "' AND nom='" + r.getName()
                    + "'  ";*/
 /*select instances from the table*/
            System.err.println(sql);

            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, utilisateur.getPseudo());
            statement.setString(2, r.getName());
            /*execution of the database query*/
            ResultSet result = statement.executeQuery();
            //map mp
            /*print the result with three attributes from the table 'products in my case' */
            while (result.next()) {
                System.out.println(result.getString(1));
                String res = result.getString("type_droit");
                //tmp = TypeDroit.valueOf(res);
                
                if ("none".equals(res)) {
                    tmp = TypeDroit.none;
                } else if ("rw".equals(res)) {
                    tmp = TypeDroit.rw;
                } else if ("admin".equals(res)) {
                    tmp = TypeDroit.admin;
                } else if ("r".equals(res)) {
                    tmp = TypeDroit.r;
                }
                // u=new User(login,...)
                // mp.put(pseudo,u)
            }

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DButilities.class.getName()).log(Level.SEVERE, null, ex);
            tmp = TypeDroit.none;
        }

        return tmp;
    }
    static void AfficherRoom(){
      
        try {
            Class.forName("com.mysql.jdbc.Driver");
            /*make connection with the database*/
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/java_chat", "root", "");/* red colored part has to be as per your database*/
            String sql = "Select * from room";


            System.err.println(sql);

            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            ResultSetMetaData resultMeta = result.getMetaData();
         
            while (result.next()) {
                for(int i = 1; i <=  resultMeta.getColumnCount(); i++){
            System.out.print(result.getObject(i).toString()+"\n");
                }
            }

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DButilities.class.getName()).log(Level.SEVERE, null, ex);
        }
 
    }
     static void CreerRoom(Room r2,String d, User u){
          try {
            Class.forName("com.mysql.jdbc.Driver");
            /*make connection with the database*/
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/java_chat", "root", "");/* red colored part has to be as per your database*/
            String sql = "INSERT INTO room (Nom, Descrptif) VALUES ('"+r2.getName()+"', '"+d+"')";
            //String sql2= "INSERT INTO creerroom (Pseudo, Nom) VALUES('?', '?');";

            System.err.println(sql);
            //System.err.println(sql2);

            PreparedStatement statement = con.prepareStatement(sql);
            //statement.setString(1, r2.getName());
           // statement.setString(2, d);
     
            ResultSet result = statement.executeQuery();
            //ResultSetMetaData resultMeta = result.getMetaData();
            
           /* 
            PreparedStatement statement2 = con.prepareStatement(sql2);
            statement2.setString(1, u.getPseudo());
            statement2.setString(2, r.getName());
     
            ResultSet result2 = statement2.executeQuery();
            //ResultSetMetaData resultMeta2 = result2.getMetaData();
        */
         } catch (ClassNotFoundException | SQLException ex) {
        Logger.getLogger(DButilities.class.getName()).log(Level.SEVERE, null, ex);
        } 
     }

}
