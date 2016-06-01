/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newPackage1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import static newPackage1.DButilities.AfficherNvMess;

/**
 *
 * @author Badr
 */

//Room pour échanger des messages
public class Chatroom extends javax.swing.JFrame {
    Room r;
        String roomname=null; //nom de la room    
        String roomdesc=null; //Description de la room
        int i=0;
        ArrayList<String> a = new ArrayList<>(); //Tableau servant pour afficher les pseudo,statut,droit des utilisateurs admis dans la room
        private static Vector classes = new Vector(); //declaration d'un vecteur
        DefaultTableModel model1; //declaration de la table graphique
        DefaultListModel model; //declaration de la lise graphique

     //Methode recherchant une instance d'objet chatroom en particulier en fonction de deux attributs ici le nom et la description
    public static Chatroom getInstance(String attribut1, String attribut2) { 
            
		Chatroom tmp = new Chatroom(attribut1, attribut2); //declare une chatroom temporaire avec les attributs en paramètre
		if (classes.contains(tmp)) { //lorsque le vecteur contient la nv instance
			// on doit retrouver l'element
			Enumeration enume = classes.elements(); //on enumere les éléments du vecteur
			while (enume.hasMoreElements()) { //tant qu'il reste des éléments à comparer
				Chatroom element = (Chatroom) enume.nextElement();  //on prend les elements de chaque instance de chatroom crée
				if (element.equals(tmp)) { //si une est egale a notre chatroom temporaire
					return element; //on retourne cet élément
				}
			}
		}
		else { //on place la chatroom temporaire dans le vecteur si elle n'y est pas deja
			classes.add(tmp);
			return tmp; //retourne la chatroom temporaire
		}
                                // si on arrive là, c'est qu'il y à un problème
                                return null;
	}
    
// A suivre: les getteur et setteur de la classe chatroom
    public void setRoomname(String roomname) { 
        this.roomname = roomname;
    }

    public String getRoomdesc() {
        return roomdesc;
    }

    public void setRoomdesc(String roomdesc) {
        this.roomdesc = roomdesc;
    }

    public String getRoomname() {
        return roomname;
    }

    public Chatroom(String ro, String d) { // CONSTRUCTEUR (nom + description)
       
        initComponents(); //initialisation de la frame
        //initialisation des variables utilisées
        i=0;
        this.roomname=ro;
        this.roomdesc=d;
        String droit=null;
        //on recupere les droit en fonction du nom de la chatroom
        droit=DButilities.getDroitUR(roomname);

        //si le droit de l'utilisateur est read les champ envoyer et texte ne sont pas affiché
        if (droit.equals("r"))
                {
                envoyerTF.setVisible(false);
                envoyerButton.setVisible(false);
            
              }
        
        
        model = new DefaultListModel();
        affichageJL.setModel(model);
     
        model1 = (DefaultTableModel) jTable1.getModel();
        
        //on cherhce si la room est publique ou non 
        i=DButilities.ispublique(roomname);
        
        if(i==1){
            //si room privé on envoie les room en parametre pour afficher les informations correspondante
             getinfos(model1, ro);
            }
        else {
            //on envoie juste le model a la methode qui affichera les infos de droit en dur
               getinfosS(model1);
               }
        
        //recherche de l'instance en fonction de la room choisit ( nom + desc)
        this.r=Room.getInstance(ro, d);
        
        //on place dans l'array list les messages en fonction de la room
        a=DButilities.AfficherttMess(r);
        
        //appelle a la fonction d'affichage
        firtaff(a);
        
        //utilisation d'un timer pour un refresh toute les 2 secondes sur les informations affichées
        Timer timer = new Timer(2000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                    affotherstext();
                    refreshUImessage(i);     
                    }
        });

        timer.start();
    }
    
    //Methode d'affichage pour la tableModel correspondant a une room publique 
    public void getinfosS(DefaultTableModel m) {
        //on utilise ici une HashMap
        HashMap<String, String> h = new HashMap<>();
        h =DButilities.AfficherUtilisateur();

        Set cles = h.keySet();
        Iterator it = cles.iterator();
        while (it.hasNext()) {
            Object cle = it.next(); 
            String valeur = h.get(cle); 
            //placement de valeur unique pour la troisieme colonne
            if(valeur.equals("off")){m.addRow(new Object[]{cle, "Hors Ligne", "Lecture - Ecriture"});}
            else if(valeur.equals("on")) {m.addRow(new Object[]{cle, "En Ligne","Lecture - Ecriture"});}
            else { m.addRow(new Object[]{cle, "Abscent","Lecture - Ecriture"}); }

        }
    }
    //Methode utilisé par le Timer pour rafraichir les informations sur room publique et privé
    private void refreshUImessage(int i){
        if(i==1){
         erasetab(model1);
         getinfos(model1, roomname);}
        else {
            erasetab(model1);
           getinfosS(model1);
             }
        }
    
     //Methode d'affichage pour la tableModel correspondant a une room privé
    public void getinfos(DefaultTableModel m, String ro) {
        ArrayList<String> aroom = new ArrayList<>();
        //affiche les infos utilisateurs qui ont acces a cette room
        aroom =DButilities.AfficherUtilisateurRoom(ro);
        int i=0;
        
        String chg=null,chk=null;
        while(i<aroom.size()){
        //recupere les statut dans l'arraylist pour les afficher proprement
        if(aroom.get(i+1).equals("off")){
            chg = "Hors Ligne";
        }
            else if(aroom.get(i+1).equals("on")) {
                chg = "En Ligne";
            }
                else { chg = "Abscent"; }
        
        if(aroom.get(i+2).equals("rw")){
            chk = "Lecture / Ecriture";
        }
            else {chk = "Lecture Seule";}
            m.addRow(new Object[]{aroom.get(i), chg, chk});
                        i=i+3;
        }
    }

    //utiliser pour le refresh
    public void erasetab(DefaultTableModel m) {
        int rowCount = m.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            m.removeRow(i);
        }
    }
    
    public void setR(Room r) {
        this.r = r;
    }
   
    public Room getR() {
        return r;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        affichageJL = new javax.swing.JList<>();
        envoyerTF = new javax.swing.JTextField();
        numRoomLabel = new javax.swing.JLabel();
        descri = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        envoyerButton = new javax.swing.JButton();
        quitterButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        affichageJL.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                affichageJLValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(affichageJL);

        envoyerTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                envoyerTFActionPerformed(evt);
            }
        });
        envoyerTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                envoyerTFKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                envoyerTFKeyTyped(evt);
            }
        });

        numRoomLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        numRoomLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        numRoomLabel.setText("RoomX");

        descri.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        descri.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        descri.setText("tttt");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Pseudo", "Statut", "Type droit"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        envoyerButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        envoyerButton.setForeground(new java.awt.Color(0, 102, 51));
        envoyerButton.setText("Envoyer");
        envoyerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                envoyerButtonActionPerformed(evt);
            }
        });
        envoyerButton.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                envoyerButtonKeyPressed(evt);
            }
        });

        quitterButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        quitterButton.setForeground(new java.awt.Color(204, 0, 0));
        quitterButton.setText("Quitter");
        quitterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitterButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Utilisateurs du salon");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(numRoomLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(descri, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(364, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(envoyerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(quitterButton, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(envoyerTF, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numRoomLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(descri, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addGap(0, 109, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(envoyerTF, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(envoyerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(quitterButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(1058, 670));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
    //on ajoute un message 
    private void add(String s){
        afftext(s);
        
    }
    
    private void envoyerTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_envoyerTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_envoyerTFActionPerformed

    private void affichageJLValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_affichageJLValueChanged
    String selected= affichageJL.getSelectedValue().toString();
    envoyerTF.setText(selected);
       afftext(selected);
    }//GEN-LAST:event_affichageJLValueChanged

    private void envoyerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_envoyerButtonActionPerformed
       
        add(envoyerTF.getText());
        envoyerTF.setText("");
    }//GEN-LAST:event_envoyerButtonActionPerformed

    private void quitterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitterButtonActionPerformed
       super.dispose();
    }//GEN-LAST:event_quitterButtonActionPerformed

    private void envoyerButtonKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_envoyerButtonKeyPressed
        // TODO add your handling code here:
         if(evt.getKeyCode() == KeyEvent.VK_ENTER)
         {
            add(envoyerTF.getText());
            envoyerTF.setText("");
         }
    }//GEN-LAST:event_envoyerButtonKeyPressed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        // TODO add your handling code here:
         if(evt.getKeyCode() == KeyEvent.VK_ENTER)
         {
            add(envoyerTF.getText());
            envoyerTF.setText("");
         }
    }//GEN-LAST:event_formKeyPressed

    private void envoyerTFKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_envoyerTFKeyPressed
        // TODO add your handling code here:
         if(evt.getKeyCode() == KeyEvent.VK_ENTER)
         {
            add(envoyerTF.getText());
            envoyerTF.setText("");
         }
    }//GEN-LAST:event_envoyerTFKeyPressed

    private void envoyerTFKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_envoyerTFKeyTyped
        // TODO add your handling code here:
         if(evt.getKeyCode() == KeyEvent.VK_ENTER)
         {
            add(envoyerTF.getText());
            envoyerTF.setText("");
         }
    }//GEN-LAST:event_envoyerTFKeyTyped
    
    //Premier affichage des messages de la chatroom (si le model est vide)
    private void firtaff(ArrayList<String> a){
        model.clear();
     for (String str : a) {
			  model.addElement(str);
		}
     affichageJL.ensureIndexIsVisible(model.size()-1);
    }
    
    //Methode pour l'affichage et la creation dans java d'un nouveau message saisie dans la room
    private void afftext(String s){
 
        if(s != null && !s.isEmpty() && (s.trim().length() > 0)) 
        {
            Mesg m = new Mesg(s);
            m.setDate(DButilities.getdate());
            DButilities.CreerMsg(m, Principale.u, r);
        }
    }
    
   //Afficher les messages
   public void affotherstext() {
  
       a=DButilities.AfficherttMess(r);
       if(!a.isEmpty()){    
       model.clear();
		}
       for (int i = 0; i < a.size(); i++) {
			 model.addElement(a.get(i));
         
		}
        affichageJL.ensureIndexIsVisible(model.size()-1);
   }
    /**
     * @param args the command line arguments
     */
    // toto
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Chatroom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Chatroom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Chatroom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Chatroom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Chatroom("ti","to").setVisible(true);
                
            
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> affichageJL;
    public javax.swing.JLabel descri;
    private javax.swing.JButton envoyerButton;
    private javax.swing.JTextField envoyerTF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    public javax.swing.JLabel numRoomLabel;
    private javax.swing.JButton quitterButton;
    // End of variables declaration//GEN-END:variables
}
