/* Cette classe sera la classe Principale de l'application comme son nom l'indique. tout les autre Frames
 * fonctions et methodes seront appelés d'ici
 *
 */
package newPackage1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;    
import static newPackage1.DButilities.auth;
import static newPackage1.DButilities.chgStatUser;
import static newPackage1.DButilities.getUser;


public class Principale extends javax.swing.JFrame {

  public static int a=1; // Var de verif
  public static String s="toto"; //String pour initialiser le User 
  public static User u=new User("test"); // Creation du User
  public Statut st=new Statut();
  public static Salon sl; // Declarion un objet Salon
  public String date = null;
  public Connection con=null;
  DefaultTableModel model; // Declaration du model qu'on utilisera par la suite
  
  
    //Constructeur de la classe et initialisation des composantes
    public Principale() {
 
        initComponents();
        u.setPseudo(s);
        getUser(u);
        nomLabel2.setText(u.getNom());
        mailLabel2.setText(u.getEmail());
        pseudoLabel2.setText(u.getPseudo());
        telLabel2.setText(u.getTel());
        statutLabel2.setText(st.getstat(u.getStatus())); // On change les valeurs de la bd par des choses lisibles
        model = (DefaultTableModel) pseudoTable.getModel(); // Declaration d'un model sur la table pseudo
        getinfos(model);
        Timer timer = new Timer(3000, new ActionListener() { // Set du timer pour recuperer les utilisateurs et leurs statuts
        public void actionPerformed(ActionEvent e) {
            refreshUImessage();     
        }
        }); 
        timer.start();
    }
    
    
    private void refreshUImessage(){
    sl=new Salon();
    erasetab(model);
    getinfos(model);
    }
    
    public void getinfos(DefaultTableModel m) {
    HashMap<String, String> h = new HashMap<>();
    h =DButilities.AfficherUtilisateur();
    Set cles = h.keySet();
    Iterator it = cles.iterator();
    while (it.hasNext()) {
            Object cle = it.next(); // tu peux typer plus finement ici
            String valeur = h.get(cle); // tu peux typer plus finement ici
            if(valeur.equals("off")){m.addRow(new Object[]{cle, "Hors Ligne"});}
            else if(valeur.equals("on")) {m.addRow(new Object[]{cle, "En Ligne"});}
            else { m.addRow(new Object[]{cle, "Abscent"}); }
        }
    }
    public void erasetab(DefaultTableModel m) {
        int rowCount = m.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            m.removeRow(i);
        }
    }
      
  
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        loginButton = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        cancelButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        nomLabel = new javax.swing.JLabel();
        mailLabel = new javax.swing.JLabel();
        pseudoLabel = new javax.swing.JLabel();
        telLabel = new javax.swing.JLabel();
        statutLabel = new javax.swing.JLabel();
        statutComboBox = new javax.swing.JComboBox<>();
        creerSalonButton = new javax.swing.JButton();
        deconnexionButton = new javax.swing.JButton();
        nomLabel2 = new javax.swing.JLabel();
        mailLabel2 = new javax.swing.JLabel();
        pseudoLabel2 = new javax.swing.JLabel();
        telLabel2 = new javax.swing.JLabel();
        statutLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        listeSalonButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        pseudoTable = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        mesSalonsButton = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        jLabel1.setText("Bienvenue sur le chat  STRI, veuillez rentrer votre identifiant.");

        jLabel2.setText("Identifiant :");

        loginButton.setText("Envoyer");
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Annuler");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonClicked(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Button-Turn-On-icon.png"))); // NOI18N

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialog1Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialog1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(34, 34, 34))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialog1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)))
                .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cancelButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(loginButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(36, 36, 36))
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialog1Layout.createSequentialGroup()
                .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jDialog1Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jDialog1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextField1)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(6, 6, 6))
                            .addGroup(jDialog1Layout.createSequentialGroup()
                                .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cancelButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jDialog1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(24, 24, 24))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 204, 204));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        nomLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        nomLabel.setText("Nom :");

        mailLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        mailLabel.setText("Mail :");

        pseudoLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        pseudoLabel.setText("Pseudo :");

        telLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        telLabel.setText("Tel :");

        statutLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        statutLabel.setText("Statut :");

        statutComboBox.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        statutComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "En ligne", "Occupé" }));
        statutComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statutComboBoxClicked(evt);
            }
        });

        creerSalonButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        creerSalonButton.setText("Créer un salon");
        creerSalonButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                creerSalonButtonActionPerformed(evt);
            }
        });

        deconnexionButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        deconnexionButton.setForeground(new java.awt.Color(204, 0, 0));
        deconnexionButton.setText("Déconnexion");
        deconnexionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deconnexionButtonActionPerformed(evt);
            }
        });

        nomLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        nomLabel2.setText("jLabel4");

        mailLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        mailLabel2.setText("jLabel5");

        pseudoLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        pseudoLabel2.setText("jLabel6");

        telLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        telLabel2.setText("jLabel7");

        statutLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        statutLabel2.setText("jLabel8");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bloggif_574adaee2581a.png"))); // NOI18N

        listeSalonButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        listeSalonButton.setText("Liste des salons");
        listeSalonButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listeSalonButtonActionPerformed(evt);
            }
        });

        pseudoTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Pseudo", "Statut"
            }
        ));
        pseudoTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pseudoTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(pseudoTable);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Liste d'utilisateurs");

        mesSalonsButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        mesSalonsButton.setText("Mes  salons ");
        mesSalonsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mesSalonsButtonActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Vos informations");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nomLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(mailLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pseudoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(telLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(statutLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(statutLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(statutComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(telLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(mailLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(nomLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(48, 48, 48))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(pseudoLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(30, 30, 30))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(creerSalonButton, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(listeSalonButton, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(180, 180, 180))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(190, 190, 190)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(mesSalonsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel5))
                            .addComponent(deconnexionButton, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(listeSalonButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(creerSalonButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(mesSalonsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nomLabel)
                            .addComponent(nomLabel2))
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(mailLabel)
                            .addComponent(mailLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(pseudoLabel)
                            .addComponent(pseudoLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(telLabel)
                            .addComponent(telLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(statutLabel)
                            .addComponent(statutLabel2)
                            .addComponent(statutComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(deconnexionButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void statutComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statutComboBoxActionPerformed
    
    }//GEN-LAST:event_statutComboBoxActionPerformed

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_loginButtonActionPerformed

    private void cancelButtonClicked(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonClicked
        System.exit(0);
    }//GEN-LAST:event_cancelButtonClicked

    private void deconnexionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deconnexionButtonActionPerformed
        chgStatUser(u,"off"); // Si deconnexion changement du status en offline
        System.exit(0); 
    }//GEN-LAST:event_deconnexionButtonActionPerformed

    private void statutComboBoxClicked(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statutComboBoxClicked
        String g=statutComboBox.getSelectedItem().toString();
        statutLabel2.setText(g);
        chgStatUser(u, st.getstat(g)); // Changement du statut sur la base.
    }//GEN-LAST:event_statutComboBoxClicked

    private void creerSalonButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_creerSalonButtonActionPerformed
       new CreerSalon().setVisible(true);
    }//GEN-LAST:event_creerSalonButtonActionPerformed

    private void listeSalonButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listeSalonButtonActionPerformed
              new ListeSalon().setVisible(true);
    }//GEN-LAST:event_listeSalonButtonActionPerformed

    private void mesSalonsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mesSalonsButtonActionPerformed
       new MyRooms().setVisible(true);
    }//GEN-LAST:event_mesSalonsButtonActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        chgStatUser(u,"off");
        System.out.println("newPackage1.Principale.formWindowClosing() BYE BYE");
        System.exit(0); // Pour commencer
    }//GEN-LAST:event_formWindowClosing

    private void pseudoTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pseudoTableMouseClicked
        ArrayList<String> a = new ArrayList<>();
        UserInfo us = new UserInfo();
        us.setVisible(true);
        int index = pseudoTable.getSelectedRow();
        TableModel model= pseudoTable.getModel();
        String pseudo = model.getValueAt(index, 0).toString();
        String status = model.getValueAt(index, 1).toString();
        a=DButilities.GetInfoUser (pseudo);
        User ux = new User(a.get(0));
        ux.setNom(a.get(1));
        ux.setEmail(a.get(2));
        ux.setTel(a.get(3));
        ux.setStatus(status);
        us.mailLabel2.setText(ux.getEmail());
        us.nomLabel2.setText(ux.getNom());
        us.pseudoLabel2.setText(ux.getPseudo());
        us.telLabel2.setText(ux.getTel());
        us.statutLabel2.setText(ux.getStatus());
    }//GEN-LAST:event_pseudoTableMouseClicked
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) { 
      do
      {   
        String reponse=null;   
        JOptionPane jco = new JOptionPane();  //Declaration d'une JOP faisant office de platforme de connexion
        reponse = jco.showInputDialog(null, "Veuillez rentrer votre identifiant.","Connexion", JOptionPane.YES_NO_CANCEL_OPTION);
        s=reponse;
        int rep=0;
        if(reponse == null) {System.exit(0);} // si cancel (Joption_cancel vaut null) alors sortir
        if(!reponse.isEmpty()){ rep=auth(reponse);}// Si rep pas vide alors verif du pseudo
        else {rep=5;}// Sinon dire que le champ est vide
        if(rep==1)
        {
             JOptionPane.showMessageDialog(null, "Bienvenue " + reponse+".", "Authentification réussie", JOptionPane.INFORMATION_MESSAGE);
             break;
        }
         else if(rep==5)
             {
             JOptionPane.showMessageDialog(null, "Le champ est vide", "Erreur", JOptionPane.WARNING_MESSAGE );   
             }     
         else if(rep==0){
             JOptionPane.showMessageDialog(null, "Pseudo introuvable", "Erreur", JOptionPane.WARNING_MESSAGE );
             }
       }while(a==1);
      try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                
                new Principale().setVisible(true);
                new Principale().setResizable(false);   
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton creerSalonButton;
    private javax.swing.JButton deconnexionButton;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton listeSalonButton;
    private javax.swing.JButton loginButton;
    private javax.swing.JLabel mailLabel;
    private javax.swing.JLabel mailLabel2;
    private javax.swing.JButton mesSalonsButton;
    private javax.swing.JLabel nomLabel;
    private javax.swing.JLabel nomLabel2;
    private javax.swing.JLabel pseudoLabel;
    private javax.swing.JLabel pseudoLabel2;
    private javax.swing.JTable pseudoTable;
    private javax.swing.JComboBox<String> statutComboBox;
    private javax.swing.JLabel statutLabel;
    private javax.swing.JLabel statutLabel2;
    private javax.swing.JLabel telLabel;
    private javax.swing.JLabel telLabel2;
    // End of variables declaration//GEN-END:variables
}
