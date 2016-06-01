/*
 * Classe utilitaire permettant majoritairement d'acceder à la base de données 
 * Pour toute sorte de tache en relation avec le chat
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



/**
 *
 * @author Badr
 */
public class DButilities {
    
    public static Connection con; // var de connection
    public static ArrayList<String> maxd; // Array List utilisé dans la fonction getDerMsgDate
    

     //Change le statut du joueur sur la bdd
    static void chgStatUser(User u, String stat) 
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String user = u.getPseudo();
            String sql2 = "UPDATE users SET statut='" + stat + "' WHERE pseudo='" + user + "'";
            Statement stmt = null;
            stmt = con.createStatement();
            stmt.executeUpdate(sql2);
            stmt.close();
            } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DButilities.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    // Permet d'acceder aux infos du user pour es stocker dans la Class User
    static void getUser(User u) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String user = u.getPseudo();
            String sql = "Select pseudo,nom,email,telephone,statut from users where pseudo='" + user + "'";
            System.err.println(sql);
            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            ResultSetMetaData resultMeta = result.getMetaData();
            ArrayList<String> a = new ArrayList<>();
            while (result.next()) {
                for (int i = 1; i <= resultMeta.getColumnCount(); i++) {
                    a.add((String) result.getString(i));
                }
            }
            // Set des attributs de l'objet u
            u.setPseudo(a.get(0));
            u.setNom(a.get(1));
            u.setEmail(a.get(2));
            u.setTel(a.get(3));
            if (a.get(4).equals("off")) {
                // On update la base comme quoi le user est en ligne
                String sql2 = "UPDATE users SET statut='on' WHERE pseudo='" + user + "'";
                Statement stmt = null;
                stmt = con.createStatement();
                stmt.executeUpdate(sql2);
                stmt.close();
            }
            u.setStatus("on");
            u.hello();
            } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DButilities.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // Fonction d'authetification à l'application avec le Pseudo du joueur
    static int auth(String user) {
        int tmp;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection("jdbc:mysql://192.168.1.97:3306/java_chat", "java_user", "123456");
            String sql = "Select pseudo from users where pseudo='" + user + "'";
            System.err.println(sql);
            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                tmp = 1; // Un joueur avec le Pseudo existe sur la bd
            } else {
                tmp = 0; // le pseudo est innexistant
            }

            } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DButilities.class.getName()).log(Level.SEVERE, null, ex);
            tmp = 0;
        }
        return tmp; // retour de la val pour traitement
    }

    // Permet d'avoir les droit de l'utilisateur connecté par rapport à une room precise.
    static String getDroitUR(String room) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String sql = "Select type_droit from acceder where pseudo=? and nom='"+room+"'";
            System.err.println("SQL DROIT ! "+sql);
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, Principale.u.getPseudo());
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                System.out.println(result.getString(1));
                String res = result.getString("type_droit");
                if ("rw".equals(res)) {
                    return "rw"; 
                } else {
                    return "r";
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DButilities.class.getName()).log(Level.SEVERE, null, ex);
           return "Error";
        }
        
        return "Error";
 }
    
   // Permet De recuperer les room dont le User peut acceder ( Car crée ou attribution de droit par un autre utilisateur)
static void putRoomtoSalon(Salon s) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String user=Principale.u.getPseudo();
            String sql = "Select DISTINCT r.Nom,r.Descrptif from room as r, acceder as a, users as u WheRE r.isRprive=0 OR(r.nom=a.nom AND u.pseudo='"+user+"' AND u.Pseudo=a.Pseudo) OR(r.nom IN (SELECT ro.nom FROM creerroom as ro WHERE ro.pseudo='"+user+"'))" ;
            System.err.println(sql);
            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            ResultSetMetaData resultMeta = result.getMetaData();
            while (result.next()) {
                for (int i = 1; i <= resultMeta.getColumnCount(); i++) {
                   creationRoomS(s, result.getString(i), result.getString(i + 1));
                    i++;
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DButilities.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    // Permet d'avoir le moderateur ou le createur de la room recherchée.
    static String GetModerateur(String room)
    {
        String admin=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String sql = "Select c.pseudo as ps from room as r, creerroom as c where r.Nom='" + room + "' AND c.nom=r.nom";
            System.out.println("NEW SQL : "+sql);
            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                    admin=result.getString("ps");
                }       
        return admin;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DButilities.class.getName()).log(Level.SEVERE, null, ex);
            return admin;
        }
    }
    // Fonction de creatrion d'une room sur la bdd
    static boolean CreerRoom(Room r2, User u, ArrayList<String> a) {
        boolean isroomalreadypresent=false; 
        int statut;
        try {
            String sql;
            Class.forName("com.mysql.jdbc.Driver");
            /*make connection with the database*/
            System.out.println("RETURN"+isroomalreadypresent);
            String verif= "SELECT COUNT(*) AS count FROM room WHERE nom='"+r2.getName()+"'";
            Statement s=con.createStatement();
            ResultSet result = s.executeQuery(verif);
            int i=1;
            while (result.next()){ 
            i = result.getInt("count");}
            if(i==0){
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
                isroomalreadypresent=true;
                return isroomalreadypresent;
                }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DButilities.class.getName()).log(Level.SEVERE, null, ex);
            return isroomalreadypresent;
        }
    }
    // Recevoir les infos de la bd par rapport à une room precise
    static void getRoom(Room r) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String nameroom = r.getName();
            String sql = "Select Nom, Descriptif from room where Nom='" + nameroom + "'";
            System.err.println(sql);
            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            ResultSetMetaData resultMeta = result.getMetaData();
            ArrayList<String> aroom = new ArrayList<>();
            while (result.next()) {
                for (int i = 1; i <= resultMeta.getColumnCount(); i++) {
                    aroom.add((String) result.getString(i));
                }
            }
            r.setNom(aroom.get(0));
            r.setDesc(aroom.get(1));
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DButilities.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // Insertion d'un message ecrit par un user dans la bdd PS : utilisation d'un remplacant de mysqli_real_escape_string
    static void CreerMsg(Mesg m, User u, Room r) {
        try {
            String sql = null;
            Class.forName("com.mysql.jdbc.Driver");
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
            int statut = stmt.executeUpdate(sql);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DButilities.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Permet d'avoir la date de creation d'un message (Etait utilisé pour la récuperation d'offset et d'affichage de
    // optimal de la boite de reception lors de l'actualisation via timer)
    static String getDateMsg(Mesg nm) {
        String date = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String namemsg = nm.getMsg();
            String sql = "Select date_cre from ecrit where msg='" + namemsg + "'";
            System.err.println(sql);
            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            ResultSetMetaData resultMeta = result.getMetaData();
            ArrayList<String> dmsg = new ArrayList<>();
            while (result.next()) {
                for (int i = 1; i <= resultMeta.getColumnCount(); i++) {
                    dmsg.add((String) result.getString(i));
                }
            }
            date = dmsg.get(0);
            System.err.println(date);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DButilities.class.getName()).log(Level.SEVERE, null, ex);
        }
        return date;
    }
    // Permet d'avoir la date courante sur le serveur que l'on utilisera pour les dates des msg
    static String getdate() {
        try { Class.forName("com.mysql.jdbc.Driver");
            String sql ="SELECT DATE_FORMAT(NOW(), '%H:%i')";
            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            result.next();
            System.out.println("DATE :" +result.getString(1));
            return result.getString(1);
            }
        catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DButilities.class.getName()).log(Level.SEVERE, null, ex);
            return "Erno";
            }
        }
    // Permet en théorie puisque pas implémentée de recuperer les dernier messages par rapport
    // a un dernier message de l'utilisateur.
static ArrayList<String> AfficherNvMess(String date, Room r) {
        ArrayList<String> a= new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String sql = "Select msg, date_cre, Pseudo from ecrit where date_cre>'" + date + "' AND nom='"+r.getName()+"' ORDER BY date_cre DESC";
            System.err.println(sql);
            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            if (!result.next()){
                System.err.println("je suis ici dans le if je return l 'array ");
                return a; 
            }else{
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
    
// Fonction utilisé actuellemnt permettant de recuperer tout les message present sur une room dans la bdd
static ArrayList<String> AfficherttMess(Room r) {
         ArrayList<String> a= new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
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

    // Permet d'avoir la date du dernier message ecrit par l'utilisateur
    static String getDerMsgDate(User u, Room r) {
        String maxdate = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String sql = "Select MAX(date_cre) from ecrit where Pseudo='" + u.getPseudo() + "' AND nom='"+r.getName()+"'";
            System.err.println(sql);
            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            ResultSetMetaData resultMeta = result.getMetaData();
            maxd = new ArrayList<>();
            while (result.next()) {
                for (int i = 1; i <= resultMeta.getColumnCount(); i++) {
                    maxd.add((String) result.getString(i));
                }
            }
            maxdate = maxd.get(0);
            System.err.println(maxdate);
            r.setLastmsgDate(maxdate);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DButilities.class.getName()).log(Level.SEVERE, null, ex);
        }
        return maxdate;
    }
    
    // // creation de java vers la base+salon
    static boolean creationRoom(Salon s, User u, String n, String desc, ArrayList<String> a) { 
        int count = s.rooms.size();
        boolean r = false;
        Room[] myArray = new Room[count + 1];
        myArray[count] = new Room(n, desc);
        r=CreerRoom(myArray[count], u, a);
        s.addRoom(myArray[count]);
        return r;
    }
     // creation dans le salon ) partir de la base
    static void creationRoomS(Salon s, String nom, String desc) {
        int count = s.rooms.size();
        Room[] myArray = new Room[count + 1];
        myArray[count] = new Room(nom, desc);
        s.addRoom(myArray[count]);
    }

    //Creation d'un message 
    static void CreationMessage(Room r, User u) {
        int numero = r.chat.size();
        Mesg[] Arraymsg = new Mesg[numero + 1];
        Arraymsg[numero] = new Mesg(String.valueOf(numero));
        CreerMsg(Arraymsg[numero], u, r);
        r.addMesg(u, Arraymsg[numero]);
    }
    
// Permet d'avoir les infromations stocké dans la BD par rapport un à un user    
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

// Permet de changer les droits d'un utilisateur par rapport à une room (Non geré dans notre GUI faute de temps)
static void ChangerDroit(User u, Room r, String droit){
	if(droit!="r" || droit!="none" || droit!="rw" || droit!="admin"){// On n'execute rien
	}else{
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String sql= "UPDATE acceder SET type_droit = '" + droit + "' WHERE pseudo='" + u.getPseudo() + "' AND nom='" + r.getName()+ "'";
            Statement stmt = null;
            stmt = con.createStatement();
            int statut = stmt.executeUpdate(sql);	
	} catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DButilities.class.getName()).log(Level.SEVERE, null, ex);
			}  
	}
    }
// Aficher les utilisateurs et leurs statut 
static HashMap<String, String> AfficherUtilisateur() {
         HashMap<String, String> map = new HashMap<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String sql = "Select Pseudo, statut from users";
            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
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
// Verifier si une room est publique ou pas pour accomplire ou pas des taches de fond
static int ispublique(String room){
 int r=0;
    try {
            Class.forName("com.mysql.jdbc.Driver");
            String sql= "SELECT isRprive as irp from room where nom='"+room+"'";
            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                r=result.getInt("irp");
            }
            if(r!=0) return 1;
            else return 0;
            } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DButilities.class.getName()).log(Level.SEVERE, null, ex);
            return r;
        }
}
//
static void RoomPublic(String nr, int yn){
	if(yn==1){
         try {
            Class.forName("com.mysql.jdbc.Driver");
            String sql= "UPDATE room SET isRprive = 1 WHERE Nom='" + nr + "'";
            Statement stmt = null;
            stmt = con.createStatement();
            int statut = stmt.executeUpdate(sql);
            if (statut == 1) {
                System.err.println("la requete a fonctionner");
            } else {
                System.err.println("erreur insert ");
            }				
	} catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DButilities.class.getName()).log(Level.SEVERE, null, ex);
	}  
	}
    }
// Afficher les utilisateur d'une room avec son nom
static ArrayList<String> AfficherUtilisateurRoom(String nr) {
        ArrayList<String> aroom= new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String sql = "Select a.Pseudo, u.statut, a.type_droit from users as u, acceder as a, room as r where a.Nom=r.Nom AND a.Pseudo=u.Pseudo AND a.Nom=(SELECT nom from room where Nom='"+ nr +"')";
            System.err.println(sql);
            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                 String pseudo = result.getString( "a.Pseudo" );
                 String Statut = result.getString( "u.statut" );	 
		 String Type_droit =result.getString("a.type_droit");
                 System.out.println(pseudo+" "+Statut+ " "+Type_droit);
                 aroom.add(pseudo);
                 aroom.add(Statut);
                 aroom.add(Type_droit);
                }
            return aroom;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DButilities.class.getName()).log(Level.SEVERE, null, ex);
            return aroom;
        }
    }

//Afficher les utilisateur sans celui qui execute l'appli
static ArrayList<String> getDbPseudo()
{
    ArrayList<String> p =new ArrayList<>();
    String user=Principale.u.getPseudo();
    try {
    Class.forName("com.mysql.jdbc.Driver");
            String sql = "Select Pseudo from users WHERE pseudo!='"+user+"'";
            System.err.println(sql);
            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
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

//Permet de get les room créé par l'utilisateur
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

// Permet de supprimer la room choisi / les msgs crée dans cette room et biensur tout les droits 
// relatifs à la room pour tout les autres utilisateurs
static void suppmyroom(ArrayList<String> a)
{
    for (String nom : a) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String sql1= "DELETE FROM creerroom where nom='"+nom+"'";
            System.out.println("newPackage1.DButilities.suppmyroom() SQL : "+sql1);
            Statement stmt1 = null;
            stmt1 = con.createStatement();
            int statut= stmt1.executeUpdate(sql1);
            String verif= "SELECT COUNT(*) AS count FROM ecrit WHERE nom='"+nom+"'";
            Statement s=con.createStatement();
            ResultSet result = s.executeQuery(verif);
            int i=0;
            while (result.next()){ // A RAJOUTER A CHAQUE FOIS AVEC LES CONT
                i = result.getInt("count");}
            if(i!=0){
                String sql4= "DELETE FROM ecrit WHERE nom='"+nom+"'";
                Statement stmt4 = null;
                stmt4 = con.createStatement();
                stmt4.executeUpdate(sql4);
            }
            verif= "SELECT COUNT(*) AS count FROM room WHERE nom='"+nom+"' and isRprive=1";
            s=con.createStatement();
            result = s.executeQuery(verif);
            i=0;
            while (result.next()){ // A RAJOUTER A CHAQUE FOIS AVEC LES CONT
                i = result.getInt("count");}
                if (i!=0){
                String sql3= "DELETE FROM acceder WHERE nom='"+nom+"'";
                Statement stmt3 = null;
                stmt3 = con.createStatement();
                stmt3.executeUpdate(sql3);
                }
            String sql= "DELETE FROM room WHERE nom='"+nom+"'";
            Statement stmt = null;
            stmt = con.createStatement();
            stmt.executeUpdate(sql);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DButilities.class.getName()).log(Level.SEVERE, null, ex);}
	}
}
}
