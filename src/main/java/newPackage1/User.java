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

//Classe représentant un utilisateur
public class User {

    //declaration variable d'un utilisateur
    private String pseudo;
    private String nom;
    private String email;
    private String tel;
    private String status; //on, off, abs
    
    //CONSTRUCTEUR avec une chaine de caractère pseudo devant etre donné en parametre
    public User(String p)
    {
    this.pseudo=p;
    }

    //getteur et setteur
    public String getPseudo() {
        return pseudo;   
    }
    
    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNom() {
        return nom;
    }

    public String getEmail() {
        return email;
    }

    public String getTel() {
        return tel;
    }

    public String getStatus() {
        return status;
    }
    
    //Affiche les infos d'un utlisateur
    public void hello()
    {
        System.out.println("\nYOO : "+getPseudo()+" "+getEmail()+" "+getTel()+" "+getStatus()+"");
    }
    
}
