package newPackage1;

import java.awt.CardLayout;
import java.awt.Panel;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import javax.swing.ButtonGroup;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.xml.bind.annotation.XmlElementDecl;
     
import static newPackage1.DButilities.auth;
import static newPackage1.DButilities.chgStatUser;
import static newPackage1.DButilities.getUser;



public class Principale extends javax.swing.JFrame {

   public static int a=1;
   public static String s="papa";
  public static User u=new User("test");
   public Statut st=new Statut();
   public static Salon sl=new Salon();
   
         
   

   
    public Principale() {
 
        initComponents();
        
          u.setPseudo(s);
                getUser(u);
        
       nomLabel2.setText(u.getNom());
        mailLabel2.setText(u.getEmail());
     pseudoLabel2.setText(u.getPseudo());
       telLabel2.setText(u.getTel());
      statutLabel2.setText(st.getstat(u.getStatus())); // On change les valeurs de la bd par des trucs lisibles
        
       
        
          
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

        nomLabel.setText("Nom :");

        mailLabel.setText("Mail :");

        pseudoLabel.setText("Pseudo :");

        telLabel.setText("Tel :");

        statutLabel.setText("Statut :");

        statutComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "En ligne", "Occupé" }));
        statutComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statutComboBoxClicked(evt);
            }
        });

        creerSalonButton.setText("Créer un salon");
        creerSalonButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                creerSalonButtonActionPerformed(evt);
            }
        });

        deconnexionButton.setText("Déconnexion");
        deconnexionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deconnexionButtonActionPerformed(evt);
            }
        });

        nomLabel2.setText("jLabel4");

        mailLabel2.setText("jLabel5");

        pseudoLabel2.setText("jLabel6");

        telLabel2.setText("jLabel7");

        statutLabel2.setText("jLabel8");

        jLabel4.setIcon(new javax.swing.ImageIcon("C:\\Users\\Jonathan\\Desktop\\strilogo1.png")); // NOI18N
        jLabel4.setText("jLabel4");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(statutComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(nomLabel)
                            .addComponent(pseudoLabel)
                            .addComponent(mailLabel)
                            .addComponent(telLabel)
                            .addComponent(statutLabel))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nomLabel2)
                            .addComponent(mailLabel2)
                            .addComponent(pseudoLabel2)
                            .addComponent(telLabel2)
                            .addComponent(statutLabel2))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addComponent(creerSalonButton, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(deconnexionButton, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(90, 90, 90))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(deconnexionButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(creerSalonButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(73, 73, 73))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nomLabel)
                    .addComponent(nomLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mailLabel)
                    .addComponent(mailLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pseudoLabel)
                    .addComponent(pseudoLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(telLabel)
                    .addComponent(telLabel2))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(statutLabel)
                    .addComponent(statutLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(statutComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
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
        chgStatUser(u,"off");
        System.exit(0); // Pour commencer
    }//GEN-LAST:event_deconnexionButtonActionPerformed

    private void statutComboBoxClicked(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statutComboBoxClicked
        String g=statutComboBox.getSelectedItem().toString();
        statutLabel2.setText(g);
        chgStatUser(u, st.getstat(g)); // Changement du statut sur la base.
    }//GEN-LAST:event_statutComboBoxClicked

    private void creerSalonButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_creerSalonButtonActionPerformed
       new CreerSalon().setVisible(true);
       
    }//GEN-LAST:event_creerSalonButtonActionPerformed
  
 
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
       
         
      do
        {   
       
           
            JOptionPane jco = new JOptionPane();  
   String reponse = jco.showInputDialog(null, "Veuillez rentrer votre identifiant.","Connexion", JOptionPane.YES_NO_CANCEL_OPTION);
   s=reponse;
   int rep=auth(reponse);     
   if(rep==1)
        {
            JOptionPane.showMessageDialog(null, "Bienvenue " + reponse+".", "Authentification réussie", JOptionPane.INFORMATION_MESSAGE);
            break;
        }
        else
            {
            JOptionPane.showMessageDialog(null, "Erreur !", "Erreur", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
                
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
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton loginButton;
    private javax.swing.JLabel mailLabel;
    private javax.swing.JLabel mailLabel2;
    private javax.swing.JLabel nomLabel;
    private javax.swing.JLabel nomLabel2;
    private javax.swing.JLabel pseudoLabel;
    private javax.swing.JLabel pseudoLabel2;
    private javax.swing.JComboBox<String> statutComboBox;
    private javax.swing.JLabel statutLabel;
    private javax.swing.JLabel statutLabel2;
    private javax.swing.JLabel telLabel;
    private javax.swing.JLabel telLabel2;
    // End of variables declaration//GEN-END:variables
}
