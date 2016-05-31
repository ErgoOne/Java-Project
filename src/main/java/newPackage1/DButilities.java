/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newPackage1;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.UIManager.getInt;


/**
 *
 * @author Badr
 */
public class DButilities {
    public static  String url = "jdbc:mysql://localhost:3306/java_chat";
    public static  String User = "java_user";
    public static  String mdp = "123456";
    public static Connection con;
    public static ArrayList<String> maxd;
    

    static void chgStatUser(User u, String stat) // Set le statut sur la bd à off
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String user = u.getPseudo();
             //con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/java_chat", "root", "");
            String sql2 = "UPDATE users SET statut='" + stat + "' WHERE pseudo='" + user + "'";
            Statement stmt = null;
            stmt = con.createStatement();
            stmt.executeUpdate(sql2);
            stmt.close();
            //con.close();

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DButilities.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    static void getUser(User u) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            /*make connection with the database*/
            String user = u.getPseudo();
            //con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/java_chat", "root", "");/* red colored part has to be as per your database*/

            // On récupere les infos du users pour la classe user et pour les afficher.
            String sql = "Select pseudo,nom,email,telephone,statut from users where pseudo='" + user + "'";
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
            ResultSetMetaData resultMeta = result.getMetaData();
            ArrayList<String> a = new ArrayList<>();

            while (result.next()) {
                for (int i = 1; i <= resultMeta.getColumnCount(); i++) {
                    a.add((String) result.getString(i));
                }
            }
            u.setPseudo(a.get(0));
            u.setNom(a.get(1));
            u.setEmail(a.get(2));
            u.setTel(a.get(3));
            if (a.get(4).equals("off")) {
                // On update la base comme quoi le user est en ligne dans le cas ou il est Off
                String sql2 = "UPDATE users SET statut='on' WHERE pseudo='" + user + "'";
                Statement stmt = null;
                stmt = con.createStatement();
                stmt.executeUpdate(sql2);
                stmt.close();
            }
            u.setStatus("on");
            u.hello();
            //con.close();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DButilities.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    static int auth(String user) {
        int tmp;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            /*make connection with the database*/
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/java_chat", "root", "");
            String sql = "Select pseudo from users where pseudo='" + user + "'";

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
            if (result.next()) {
                tmp = 1;
            } else {
                tmp = 0;
            }

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DButilities.class.getName()).log(Level.SEVERE, null, ex);
            tmp = 0;
        }
        return tmp;
    }

    static TypeDroit getDroitUR(User utilisateur, Room r) {
        TypeDroit tmp = TypeDroit.none;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            /*make connection with the database*/
            //con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/java_chat", "root", "");/* red colored part has to be as per your database*/
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
static void putRoomtoSalon(Salon s) {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            /*make connection with the database*/
            //Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/java_chat", "root", "");/* red colored part has to be as per your database*/
            String sql = "Select * from room";

            System.err.println(sql);

            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            ResultSetMetaData resultMeta = result.getMetaData();

            while (result.next()) {
                for (int i = 1; i <= resultMeta.getColumnCount(); i++) {
                    //System.out.print(result.getString(i)+"\n");
                    // s.addRoom(result.getString(i),result.getString(i+1) );//Ajouter les room de la BD dans la salon
                    creationRoomS(s, result.getString(i), result.getString(i + 1));
                    i++;
                }
            }

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DButilities.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    static boolean CreerRoom(Room r2, User u) {
        boolean isroomalreadypresent=false; 
        try {
            Class.forName("com.mysql.jdbc.Driver");
            /*make connection with the database*/
            System.out.println("RETURN"+isroomalreadypresent);
            //Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/java_chat", "root", "");/* red colored part has to be as per your database*/
            String verif= "SELECT COUNT(*) AS count FROM room WHERE nom='"+r2.getName()+"'";
            Statement s=con.createStatement();
            ResultSet result = s.executeQuery(verif);
            //ResultSetMetaData resultMeta = result.getMetaData();
            int i=1;
            while (result.next()){ // A RAJOUTER A CHAQUE FOIS AVEC LES CONT
           i = result.getInt(1);}
            //retun= result.getInt(1);*/
            System.out.println("RETURN i "+i);
            if(i!=0){
               /* retun=1;*/
            String sql = "INSERT INTO room VALUES ('" + r2.getName() + "', '" + r2.getDesc() + "')";
            String sql2 = "INSERT INTO creerroom VALUES('" + u.getPseudo() + "', '" + r2.getName() + "')";
            Statement stmt = null;
            stmt = con.createStatement();
            int statut = stmt.executeUpdate(sql);

            if (statut == 1) {
                System.err.println("la requete a fonctionner");
            } else {
                System.err.println("erreur insert");
            }
            Statement stmt2 = null;
            stmt2 = con.createStatement();
            int statut2 = stmt2.executeUpdate(sql2);

            if (statut2 == 1) {
                System.err.println("la deuxieme requete a fonctionner");
            } else {
                System.err.println("erreur insert");
            }
            return isroomalreadypresent;
            }
            else {
            //con.close();
            isroomalreadypresent=true;
            return isroomalreadypresent;
            }
            //PreparedStatement statement = con.prepareStatement(sql);
            //statement.setString(1, r2.getName());
            // statement.setString(2, d);

            //ResultSet result = statement.executeQuery();
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

            return isroomalreadypresent;
        }
    }

    static void getRoom(Room r) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            /*make connection with the database*/
            String nameroom = r.getName();
            //Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/java_chat", "root", "");/* red colored part has to be as per your database*/
            String sql = "Select Nom, Descriptif from room where Nom='" + nameroom + "'";

            System.err.println(sql);

            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            ResultSetMetaData resultMeta = result.getMetaData();
            ArrayList<String> aroom = new ArrayList<>();
            while (result.next()) {
                for (int i = 1; i <= resultMeta.getColumnCount(); i++) {
                    aroom.add((String) result.getString(i));
                    //System.out.print(result.getString(i)+"\n");
                }
            }
            r.setNom(aroom.get(0));
            r.setDesc(aroom.get(1));
            r.Hello();

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DButilities.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    static void CreerMsg(Mesg m, User u, Room r) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            /*make connection with the database*/
           // Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/java_chat", "root", "");/* red colored part has to be as per your database*/
            String sql = "INSERT INTO ecrit VALUES ('" + m.getMsg() + "', NOW(), '" + u.getPseudo() + "', '" + r.getName() + "')";
            Statement stmt = null;
            stmt = con.createStatement();
            int statut = stmt.executeUpdate(sql);

            if (statut == 1) {
                System.err.println("la requete a fonctionner");
            } else {
                System.err.println("erreur insert");
            }
            //con.close();

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DButilities.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    static String getDateMsg(Mesg nm) {
        String date = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            /*make connection with the database*/
            String namemsg = nm.getMsg();
            //Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/java_chat", "root", "");/* red colored part has to be as per your database*/
            String sql = "Select date_cre from ecrit where msg='" + namemsg + "'";

            System.err.println(sql);

            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            ResultSetMetaData resultMeta = result.getMetaData();
            ArrayList<String> dmsg = new ArrayList<>();
            while (result.next()) {
                for (int i = 1; i <= resultMeta.getColumnCount(); i++) {
                    dmsg.add((String) result.getString(i));
                    //System.out.print(result.getString(i)+"\n");
                }
            }
            date = dmsg.get(0);
            System.err.println(date);

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DButilities.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.err.println("date apres catch" + date);
        return date;
    }
    static String getdate() {
        try { Class.forName("com.mysql.jdbc.Driver");
            /*make connection with the database*/
            //Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/java_chat", "root", "");
    String sql ="SELECT DATE_FORMAT(NOW(), '%H:%i')";
    PreparedStatement statement = con.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            result.next();
            System.out.println("DATE :" +result.getString(1));
            return result.getString(1);
    }
        catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DButilities.class.getName()).log(Level.SEVERE, null, ex);
            return "tto";
        }
    
    }
static ArrayList<String> AfficherNvMess(String date, Room r) {
        ArrayList<String> a= new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            /*make connection with the database*/
            //Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/java_chat", "root", "");/* red colored part has to be as per your database*/
            String sql = "Select msg, date_cre, Pseudo from ecrit where date_cre>'" + date + "' AND nom='"+r.getName()+"' ORDER BY date_cre";

            System.err.println(sql);

            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            if (!result.next()){
                System.err.println("je suis ici dans le if je return l 'array ");
                return(AfficherttMess(r));
                //return a;
            }else{
            ResultSetMetaData resultMeta = result.getMetaData();

            while (result.next()) {
                 String msg = result.getString( "msg" );

                 String date_cre = result.getString( "date_cre" );

                 String Pseudo = result.getString( "Pseudo" );

                 String s = "# "+Pseudo+" "+date_cre+" : "+msg;
                 a.add(s);
          
                }
            return a;
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DButilities.class.getName()).log(Level.SEVERE, null, ex);
            return a;
        }
        
    }
    
    
     static ArrayList<String> AfficherttMess(Room r) {
         ArrayList<String> a= new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            /*make connection with the database*/
            //Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/java_chat", "root", "");/* red colored part has to be as per your database*/
            String sql = "Select msg, date_cre, Pseudo from ecrit where nom='"+r.getName()+"' ORDER BY date_cre";

            System.err.println(sql);

            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            ResultSetMetaData resultMeta = result.getMetaData();

            while (result.next()) {
                 String msg = result.getString( "msg" );

                 String date_cre = result.getString( "date_cre" );

                 String Pseudo = result.getString( "Pseudo" );
               
          String s = "# "+Pseudo+" "+date_cre+" : "+msg;
          a.add(s);
          
                }
            return a;

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DButilities.class.getName()).log(Level.SEVERE, null, ex);
            return a;
        }
    }
   
    
    

    static String getDerMsgDate(User u, Room r) {
        String maxdate = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            /*make connection with the database*/
            //Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/java_chat", "root", "");/* red colored part has to be as per your database*/
            String sql = "Select MAX(date_cre) from ecrit where Pseudo='" + u.getPseudo() + "' AND nom='"+r.getName()+"'";

            System.err.println(sql);

            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            ResultSetMetaData resultMeta = result.getMetaData();
            maxd = new ArrayList<>();
            while (result.next()) {
                for (int i = 1; i <= resultMeta.getColumnCount(); i++) {
                    maxd.add((String) result.getString(i));
                    //System.out.print(result.getString(i)+"\n");
                }
            }
            maxdate = maxd.get(0);
            System.err.println(maxdate);
            r.setLastmsgDate(maxdate);

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DButilities.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.err.println("date apres catch" + maxdate);
        return maxdate;
    }

    static boolean creationRoom(Salon s, User u, String n, String desc) { // creation de java vers la base+salon
        int count = s.rooms.size();
        boolean r = false;
        Room[] myArray = new Room[count + 1];
        myArray[count] = new Room(n, desc);
        r=CreerRoom(myArray[count], u);
        s.addRoom(myArray[count]);
        return r;
    }

    static void creationRoomS(Salon s, String nom, String desc) { // creation dans le salon ) partir de la base
        int count = s.rooms.size();
        Room[] myArray = new Room[count + 1];
        myArray[count] = new Room(nom, desc);
        s.addRoom(myArray[count]);
    }

    static void CreationMessage(Room r, User u) {
        int numero = r.chat.size();

        //int numero=3;
        Mesg[] Arraymsg = new Mesg[numero + 1];

        Arraymsg[numero] = new Mesg(String.valueOf(numero));
        CreerMsg(Arraymsg[numero], u, r);
        r.addMesg(u, Arraymsg[numero]);
    }

static void AjouterUtilisateur(User u, Room r, TypeDroit t) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            /*make connection with the database*/
            //Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/java_chat", "root", "");/* red colored part has to be as per your database*/
            String sqlnum= "SELECT MAX(pseudoadd) FROM ajouter";
            PreparedStatement statement = con.prepareStatement(sqlnum);
            ResultSet result = statement.executeQuery();
            int num = result.getInt( "pseudoadd" )+1;
            String sql = "INSERT INTO ajouter VALUES ('" + num + "','" + u.getPseudo() + "','" + r.getName()+ "')";
            
            Statement stmt = null;
            stmt = con.createStatement();
            int statut = stmt.executeUpdate(sql);

            if (statut == 1) {
                System.err.println("la requete a fonctionner");
            } else {
                System.err.println("erreur insert");
            }
            String sql2 = "INSERT INTO acceder VALUES ('" + t.name() + "','" + u.getPseudo() + "','" + r.getName()+ "')";
            Statement stmt2 = null;
            stmt2 = con.createStatement();
            int statut2 = stmt2.executeUpdate(sql2);
            if (statut2 == 1) {
                System.err.println("la requete 2 a fonctionner");
            } else {
                System.err.println("erreur insert 2");
            }
            con.close();

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DButilities.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    static void SupprimerUtilisateur(User u, Room r, TypeDroit t) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            /*make connection with the database*/
            //Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/java_chat", "root", "");/* red colored part has to be as per your database*/
            String sqlnum= "SELECT MAX(pseudodel) FROM supprimer";
            PreparedStatement statement = con.prepareStatement(sqlnum);
            ResultSet result = statement.executeQuery();
            int num = result.getInt( "pseudodel" )+1;
            String sql = "INSERT INTO ajouter VALUES ('" + num + "','" + u.getPseudo() + "','" + r.getName()+ "')";
            
            Statement stmt = null;
            stmt = con.createStatement();
            int statut = stmt.executeUpdate(sql);

            if (statut == 1) {
                System.err.println("la requete a fonctionner");
            } else {
                System.err.println("erreur insert");
            }
            String sql2 = "DELETE FROM acceder WHERE type_droit='" + t.name() + "' AND pseudo='" + u.getPseudo() + "' AND nom='" + r.getName()+ "'";
            Statement stmt2 = null;
            stmt2 = con.createStatement();
            int statut2 = stmt2.executeUpdate(sql2);
            if (statut2 == 1) {
                System.err.println("la requete 2 a fonctionner");
            } else {
                System.err.println("erreur insert 2");
            }
            con.close();

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DButilities.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    static void ChangerDroit(User u, Room r, String droit){
	if(droit!="r" || droit!="none" || droit!="rw" || droit!="admin"){
		System.out.println("Invalide type de droit");
	}else{
		        try {
            Class.forName("com.mysql.jdbc.Driver");
            /*make connection with the database*/
           // Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/java_chat", "root", "");/* red colored part has to be as per your database*/
            String sql= "UPDATE acceder SET type_droit = '" + droit + "' WHERE pseudo='" + u.getPseudo() + "' AND nom='" + r.getName()+ "'";
            Statement stmt = null;
            stmt = con.createStatement();
            int statut = stmt.executeUpdate(sql);
            if (statut == 1) {
                System.err.println("la requete a fonctionner");
            } else {
                System.err.println("erreur insert ");
            }
            con.close();
			
				
			} catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DButilities.class.getName()).log(Level.SEVERE, null, ex);
			}  
	}
	
    }
static HashMap<String, String> AfficherUtilisateur() {
         HashMap<String, String> map = new HashMap<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            /*make connection with the database*/
            //Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/java_chat", "root", "");/* red colored part has to be as per your database*/
            String sql = "Select Pseudo, statut from users";

            System.err.println(sql);

            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            ResultSetMetaData resultMeta = result.getMetaData();

            while (result.next()) {
                 String pseudo = result.getString( "Pseudo" );

                 String Statut = result.getString( "statut" );

                System.out.println(pseudo+" "+Statut);
           
            map.put(pseudo, Statut);
                }
            return map;
            

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DButilities.class.getName()).log(Level.SEVERE, null, ex);
            return map;
        }
    }
static void RoomPublic(String nr, int yn){
	if(yn==1){
		        try {
            Class.forName("com.mysql.jdbc.Driver");
            /*make connection with the database*/
           // Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/java_chat", "root", "");/* red colored part has to be as per your database*/
            String sql= "UPDATE room SET isRoomPublic = 1 WHERE Nom='" + nr + "'";
            Statement stmt = null;
            stmt = con.createStatement();
            int statut = stmt.executeUpdate(sql);
            if (statut == 1) {
                System.err.println("la requete a fonctionner");
            } else {
                System.err.println("erreur insert ");
            }
            con.close();
			
				
			} catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DButilities.class.getName()).log(Level.SEVERE, null, ex);
			}  
	}
	
    }
}
