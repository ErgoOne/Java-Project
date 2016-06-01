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
            con = (Connection) DriverManager.getConnection("jdbc:mysql://192.168.1.97:3306/java_chat", "java_user", "123456");
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

    static String getDroitUR() {
        //TypeDroit tmp = TypeDroit.none;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            /*make connection with the database*/
            //con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/java_chat", "root", "");/* red colored part has to be as per your database*/
            String sql = "Select type_droit from acceder where pseudo=?";

            /*          + utilisateur.getPseudo()
                    + "' AND nom='" + r.getName()
                    + "'  ";*/
 /*select instances from the table*/
            System.err.println(sql);

            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, Principale.u.getPseudo());
            /*execution of the database query*/
            ResultSet result = statement.executeQuery();
            //map mp
            /*print the result with three attributes from the table 'products in my case' */
            while (result.next()) {
                System.out.println(result.getString(1));
                String res = result.getString("type_droit");
                //tmp = TypeDroit.valueOf(res);

                
                if ("rw".equals(res)) {
                    return "rw";
                } else {
                    return "r";
                }
                // u=new User(login,...)
                // mp.put(pseudo,u)
            }

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DButilities.class.getName()).log(Level.SEVERE, null, ex);
           return "Error";
        }
        return "Error";
        
    }
static void putRoomtoSalon(Salon s) {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            /*make connection with the database*/
            String user=Principale.u.getPseudo();
            //Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/java_chat", "root", "");/* red colored part has to be as per your database*/
            String sql = "Select DISTINCT r.Nom,r.Descrptif from room as r, acceder as a, users as u WheRE r.isRprive=0 OR(r.nom=a.nom AND u.pseudo='"+user+"' AND u.Pseudo=a.Pseudo) OR(r.nom IN (SELECT ro.nom FROM creerroom as ro WHERE ro.pseudo='"+user+"'))" ;
            System.err.println(sql);
            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            ResultSetMetaData resultMeta = result.getMetaData();

            while (result.next()) {
                for (int i = 1; i <= resultMeta.getColumnCount(); i++) {
                    //System.out.print(result.getString(i)+"\n"+result.getString(i + 1));
                    // s.addRoom(result.getString(i),result.getString(i+1) );//Ajouter les room de la BD dans la salon
                    creationRoomS(s, result.getString(i), result.getString(i + 1));
                    i++;
                }
            }

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DButilities.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    static String GetModerateur(String room)
    {
        String admin=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            /*make connection with the database*/
            //Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/java_chat", "root", "");/* red colored part has to be as per your database*/
            String sql = "Select c.pseudo as ps from room as r, creerroom as c where r.Nom='" + room + "' AND c.nom=r.nom";
            System.out.println("NEW SQL : "+sql);
            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            ResultSetMetaData resultMeta = result.getMetaData();
            while (result.next()) {
                    admin=result.getString("ps");
                    //System.out.print(result.getString(i)+"\n");
                }
            
                return admin;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DButilities.class.getName()).log(Level.SEVERE, null, ex);
            return admin;
        }
    }
    static boolean CreerRoom(Room r2, User u, ArrayList<String> a) {
        boolean isroomalreadypresent=false; 
        int statut;
        try {
            String sql;
            Class.forName("com.mysql.jdbc.Driver");
            /*make connection with the database*/
            System.out.println("RETURN"+isroomalreadypresent);
            //Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/java_chat", "root", "");/* red colored part has to be as per your database*/
            String verif= "SELECT COUNT(*) AS count FROM room WHERE nom='"+r2.getName()+"'";
            System.out.println("SELECT : "+verif);
            Statement s=con.createStatement();
            ResultSet result = s.executeQuery(verif);
            //ResultSetMetaData resultMeta = result.getMetaData();
            int i=1;
            while (result.next()){ // A RAJOUTER A CHAQUE FOIS AVEC LES CONT
           i = result.getInt("count");}
        // i= result.getInt("count");
            //retun= result.getInt(1);*/
            System.out.println("RETURN i "+i);
            if(i==0){
               /* retun=1;*/
               if(a.isEmpty()){
            sql = "INSERT INTO room VALUES ('" + r2.getName() + "', '" + r2.getDesc() + "',0)";
            Statement stmt = null;
            stmt = con.createStatement();
            statut = stmt.executeUpdate(sql);
            
               }
               else {
                sql = "INSERT INTO room VALUES ('" + r2.getName() + "', '" + r2.getDesc() + "',1)";
                     Statement stmt = null;
            stmt = con.createStatement();
            statut = stmt.executeUpdate(sql);
            for(int x =0 ; x < a.size(); x++)
            {   
                String name=a.get(x);
                String read=a.get(x+1);
                String write=a.get(x+2);
            if (read.equals("1") || write.equals("1"))
            {
                if (write.equals("1"))
                {
                    String sql3 = "INSERT INTO acceder VALUES('rw', '" + name + "','" + r2.getName() + "') ";
                    
                    Statement stmt1 = null;
                    stmt1 = con.createStatement();
                    stmt1.executeUpdate(sql3);
                }
                else {
                    String sql3 = "INSERT INTO acceder VALUES('r', '" + name + "','" + r2.getName() + "') ";
                    
                    Statement stmt2 = null;
                    stmt2 = con.createStatement();
                    stmt2.executeUpdate(sql3);
                
                }
            }
                
                x+=2;
            }
               }
            String sql2 = "INSERT INTO creerroom VALUES('" + u.getPseudo() + "', '" + r2.getName() + "')";
          
            //String sql3 = "INSERT INTO acceder  ";
         

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
            String sql = null;
            Class.forName("com.mysql.jdbc.Driver");
            /*make connection with the database*/
           // Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/java_chat", "root", "");/* red colored part has to be as per your database*/
            //String sql = "INSERT INTO ecrit VALUES ('" + m.getMsg() + "', NOW(), '" + u.getPseudo() + "', '" + r.getName() + "')";
             
             String clean_string = m.getMsg();
         clean_string = clean_string.replaceAll("\\\\", "\\\\\\\\");
         clean_string = clean_string.replaceAll("\\n","\\\\n");
         clean_string = clean_string.replaceAll("\\r", "\\\\r");
         clean_string = clean_string.replaceAll("\\t", "\\\\t");
         clean_string = clean_string.replaceAll("\\00", "\\\\0");
         clean_string = clean_string.replaceAll("'", "\\\\'");
         clean_string = clean_string.replaceAll("\\\"", "\\\\\"");
         sql = "INSERT INTO ecrit VALUES ('" +clean_string+ "', NOW(), '" + u.getPseudo() + "', '" + r.getName() + "')";

            PreparedStatement stmt = con.prepareStatement(sql);
            //Statement stmt = null;
            //stmt = con.createStatement();
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
            String sql = "Select msg, date_cre, Pseudo from ecrit where date_cre>'" + date + "' AND nom='"+r.getName()+"' ORDER BY date_cre DESC";

            System.err.println(sql);

            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            if (!result.next()){
                System.err.println("je suis ici dans le if je return l 'array ");
                //return(AfficherttMess(r)); JE VIENS DE MODIF
                return a;
                
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
               
           String date = date_cre;
            String[] parts = date.split(" ");
        //    System.out.println("Date: " + parts[0]);
       //     System.out.println("Time: " + parts[1] + " " + parts[2]);
               // System.out.println("LHEUUUUUREEE "+parts[1]);
            String s = ""+Pseudo+" a écrit le " +parts[0]+" à " +parts[1]+" : ";
            String m= "  => "+msg;
          a.add(s);
          a.add(m);
          
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

    static boolean creationRoom(Salon s, User u, String n, String desc, ArrayList<String> a) { // creation de java vers la base+salon
        int count = s.rooms.size();
        boolean r = false;
        Room[] myArray = new Room[count + 1];
        myArray[count] = new Room(n, desc);
        r=CreerRoom(myArray[count], u, a);
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
static ArrayList<String> GetInfoUser (String pseudo)
{
ArrayList<String> a = new ArrayList<>();
String sql = "SELECT * from users where Pseudo='"+pseudo+"'";
  try {
            Class.forName("com.mysql.jdbc.Driver");
            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            ResultSetMetaData resultMeta = result.getMetaData();

            while (result.next()) {
                a.add(pseudo);
                 String nom = result.getString( "nom" );
                 a.add(nom);
                 String email = result.getString( "email" );
                 a.add(email);
                 String tel = result.getString( "telephone" );
                 a.add(tel);
                 String st = result.getString( "statut" );
                 a.add(st);  
            }
            return a;
            } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DButilities.class.getName()).log(Level.SEVERE, null, ex);
            return a;
        }
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
            String sql= "UPDATE room SET isRprive = 1 WHERE Nom='" + nr + "'";
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
static ArrayList<String> AfficherUtilisateurRoom(String nr) {
        ArrayList<String> aroom= new ArrayList<>();
         //String aafficher = null;
         //String virgule=",";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            /*make connection with the database*/
            //Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/java_chat", "root", "");/* red colored part has to be as per your database*/
            String sql = "Select a.Pseudo, u.statut, a.type_droit from users as u, acceder as a, room as r where a.Nom=r.Nom AND a.Pseudo=u.Pseudo AND a.Nom=(SELECT nom from room where Nom='"+ nr +"')";

            System.err.println(sql);

            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            ResultSetMetaData resultMeta = result.getMetaData();

            while (result.next()) {
                 String pseudo = result.getString( "a.Pseudo" );

                 String Statut = result.getString( "u.statut" );
				 
		 String Type_droit =result.getString("a.type_droit");

                System.out.println(pseudo+" "+Statut+ " "+Type_droit);
                //aafficher=pseudo.concat(virgule).concat(Statut).concat(virgule).concat(Type_droit);
           aroom.add(pseudo);
           aroom.add(Statut);
           aroom.add(Type_droit);
                }
            //return aafficher;
            return aroom;

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DButilities.class.getName()).log(Level.SEVERE, null, ex);
            //return aafficher;
            return aroom;
        }
    }

static ArrayList<String> getDbPseudo()
{
    ArrayList<String> p =new ArrayList<>();
    String user=Principale.u.getPseudo();
     try {
    Class.forName("com.mysql.jdbc.Driver");
            /*make connection with the database*/
            //Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/java_chat", "root", "");/* red colored part has to be as per your database*/
            String sql = "Select Pseudo from users WHERE pseudo!='"+user+"'";

            System.err.println(sql);

            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            ResultSetMetaData resultMeta = result.getMetaData();

            while (result.next()) {
                 String pseudo = result.getString( "Pseudo" );
           
            p.add(pseudo);
                }
            return p;
              } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DButilities.class.getName()).log(Level.SEVERE, null, ex);
            return p;
        }
            
}

static ArrayList<String> getmyrooms(){
ArrayList<String> a = new ArrayList<>();
     try {Class.forName("com.mysql.jdbc.Driver");
     String sql = "SELECT c.nom, r.descrptif  FROM creerroom as c, room as r WHERE Pseudo='"+Principale.u.getPseudo()+"' and c.nom=r.nom";
         System.out.println("newPackage1.DButilities.getmyrooms() : SELECT : "+sql);
      PreparedStatement statement = con.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            ResultSetMetaData resultMeta = result.getMetaData();
            while (result.next()) {
                 String nom = result.getString("nom");
                 String desc = result.getString("descrptif");
                 a.add(nom);
                 a.add(desc);
                }
            System.out.println("newPackage1.DButilities.getmyrooms() JE SUIS DANS LE A = kkchs");
            return a;
      } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DButilities.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("newPackage1.DButilities.getmyrooms() JE SUIS DANS LE A = 0");
            return a;
}}

static void suppmyroom(ArrayList<String> a)
{
    for (String nom : a) {
		
         try {
            Class.forName("com.mysql.jdbc.Driver");
            /*make connection with the database*/
           // Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/java_chat", "root", "");/* red colored part has to be as per your database*/
           
           String sql1= "DELETE FROM creerroom where nom='"+nom+"'";
             System.out.println("newPackage1.DButilities.suppmyroom() SQL : "+sql1);
             Statement stmt1 = null;
             stmt1 = con.createStatement();
             int statut= stmt1.executeUpdate(sql1);
             
             String verif= "SELECT COUNT(*) AS count FROM ecrit WHERE nom='"+nom+"'";
            Statement s=con.createStatement();
            ResultSet result = s.executeQuery(verif);
            //ResultSetMetaData resultMeta = result.getMetaData();
            int i=0;
            while (result.next()){ // A RAJOUTER A CHAQUE FOIS AVEC LES CONT
           i = result.getInt("count");}
            if(i!=0){
                String sql4= "DELETE FROM ecrit WHERE nom='"+nom+"'";
             System.out.println("newPackage1.DButilities.suppmyroom() SQL2 : "+sql4);
            Statement stmt4 = null;
            stmt4 = con.createStatement();
           stmt4.executeUpdate(sql4);
           }
            verif= "SELECT COUNT(*) AS count FROM room WHERE nom='"+nom+"' and isRprive=1";
             s=con.createStatement();
            result = s.executeQuery(verif);
            //ResultSetMetaData resultMeta = result.getMetaData();
           i=0;
            while (result.next()){ // A RAJOUTER A CHAQUE FOIS AVEC LES CONT
           i = result.getInt("count");}
            if (i!=0){
           String sql3= "DELETE FROM acceder WHERE nom='"+nom+"'";
             System.out.println("newPackage1.DButilities.suppmyroom() SQL2 : "+sql3);
            Statement stmt3 = null;
            stmt3 = con.createStatement();
           stmt3.executeUpdate(sql3);
            }
           String sql= "DELETE FROM room WHERE nom='"+nom+"'";
             System.out.println("newPackage1.DButilities.suppmyroom() SQL2 : "+sql);
            Statement stmt = null;
            stmt = con.createStatement();
             stmt.executeUpdate(sql);
        
            } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DButilities.class.getName()).log(Level.SEVERE, null, ex);}
	}
}
}
