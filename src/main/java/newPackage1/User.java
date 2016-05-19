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
public class User {


    private String pseudo;
    private String nom;
    private String email;
    private String tel;
    private String status;
    
    public User(String p)
    {
    this.pseudo=p;
    }

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
    
    public void hello()
    {
        System.out.println("\nYOO : "+getPseudo()+" "+getEmail()+" "+getTel()+" "+getStatus()+"");
    }
    
}
