package newPackage1;

import java.awt.Panel;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.xml.bind.annotation.XmlElementDecl;
import static newPackage1.DButilities.auth;
import static newPackage1.DButilities.chgStatUser;
import static newPackage1.DButilities.getUser;

public class Principale extends javax.swing.JFrame {

   public static int a=1;
   public static String s="toto";
   public User u=new User("test");
   public Statut st=new Statut();
   
         
   

   
    public Principale() {
 
        initComponents();
        
         
        
       
        
          
    }
      
  
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonPanel = new javax.swing.JPanel();
        profilButton = new javax.swing.JButton();
        salonButton = new javax.swing.JButton();
        creerSalonButton = new javax.swing.JButton();
        displayPanel = new javax.swing.JPanel();

        jLabel1.setText("Bienvenue sur le chat  STRI, veuillez rentrer votre identifiant.");

        jLabel2.setText("Identifiant :");

        jButton1.setText("Envoyer");

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jDialog1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog1Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(jLabel1)
                .addGap(26, 26, 26)
                .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        profilButton.setText("Profil");
        buttonPanel.add(profilButton);

        salonButton.setText("Salon");
        buttonPanel.add(salonButton);

        creerSalonButton.setText("Creer Salon");
        buttonPanel.add(creerSalonButton);

        getContentPane().add(buttonPanel, java.awt.BorderLayout.NORTH);

        javax.swing.GroupLayout displayPanelLayout = new javax.swing.GroupLayout(displayPanel);
        displayPanel.setLayout(displayPanelLayout);
        displayPanelLayout.setHorizontalGroup(
            displayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 653, Short.MAX_VALUE)
        );
        displayPanelLayout.setVerticalGroup(
            displayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        getContentPane().add(displayPanel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents
  
 
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
            //System.exit(0);
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
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel buttonPanel;
    private javax.swing.JButton creerSalonButton;
    private javax.swing.JPanel displayPanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton profilButton;
    private javax.swing.JButton salonButton;
    // End of variables declaration//GEN-END:variables
}
