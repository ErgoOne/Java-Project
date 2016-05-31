/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newPackage1;

import java.awt.Toolkit;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import javafx.beans.binding.Bindings;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;



/**
 *
 * @author Jonathan
 */
public class CreerSalon extends javax.swing.JFrame {

    DefaultTableModel md; 
    public String statut;
    public int ispublic=0;
    /**
     * Creates new form CreerSalon
     */
    public CreerSalon() {
        initComponents();
       
    }

    
    
     // A changer pour afficher les pseudos à la place des salons
     public void getinfos(DefaultTableModel m) {
        //HashMap<String, String> h = new HashMap<>();
        ArrayList<String> h = new ArrayList<>();
      //  putRoomtoSalon(Principale.sl);
        h = DButilities.getDbPseudo();

        for (String p : h) {
                        m.addRow(new Object[]{p});
                        
		}
    }
     
     public ArrayList<String> getchoixdroit(DefaultTableModel m) {
         ArrayList<String> a = new ArrayList<>();
         for(int row = 0;row < m.getRowCount();row++) {
              a.add((String) m.getValueAt(row, 0));
              Boolean isChecked = Boolean.valueOf(m.getValueAt(row, 1).toString());
              Boolean isChecked2 = Boolean.valueOf(m.getValueAt(row, 2).toString());
              if(isChecked){a.add("1");}
              else {a.add("0");}
              
         if(isChecked2){a.add("1");}
         else {a.add("0");}
         }     
         return a;
     }
     public void setfalse(DefaultTableModel m){
     
          for(int row = 0;row < m.getRowCount();row++) {
          m.setValueAt(Boolean.FALSE, row, 1);
          m.setValueAt(Boolean.FALSE, row, 2);
          }
          System.out.println("OK");
     }
   

    
    public void close(){
        
        WindowEvent winClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        titleLabel = new javax.swing.JLabel();
        nomLabel = new javax.swing.JLabel();
        descLabel = new javax.swing.JLabel();
        nomTF = new javax.swing.JTextField();
        descTF = new javax.swing.JTextField();
        creerButton = new javax.swing.JButton();
        publicRB = new javax.swing.JRadioButton();
        privateRB = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        creerSalonTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        quitterButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        titleLabel.setFont(new java.awt.Font("Times New Roman", 1, 22)); // NOI18N
        titleLabel.setText("Créer un salon ");

        nomLabel.setText("Nom :");

        descLabel.setText("Descriptif :");

        nomTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomTFActionPerformed(evt);
            }
        });

        creerButton.setText("Créer");
        creerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                creerButtonActionPerformed(evt);
            }
        });

        buttonGroup1.add(publicRB);
        publicRB.setText("Public");
        publicRB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                publicRBActionPerformed(evt);
            }
        });

        buttonGroup1.add(privateRB);
        privateRB.setText("Privé");
        privateRB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                privateRBActionPerformed(evt);
            }
        });

        creerSalonTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Pseudo", "Read", "Write"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Boolean.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(creerSalonTable);

        jLabel1.setText("Type salon : ");

        jLabel2.setText("Astuce => Pour restreindre l'accés à votre salon : ");

        jLabel3.setText("Cliquez sur Privé !");

        quitterButton.setText("Quitter");
        quitterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitterButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(titleLabel)
                .addGap(260, 260, 260))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addGap(89, 89, 89)
                        .addComponent(privateRB))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(nomLabel)
                            .addComponent(descLabel))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(descTF, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                                .addComponent(nomTF))
                            .addComponent(publicRB)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(creerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(quitterButton))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nomLabel)
                            .addComponent(nomTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(descLabel)
                            .addComponent(descTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(publicRB)
                            .addComponent(privateRB)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(creerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(quitterButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(4, 4, 4))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nomTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomTFActionPerformed

    private void creerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_creerButtonActionPerformed
        // TODO add your handling code here:
       ArrayList<String> a = new ArrayList<>();
       boolean ispresent=false;
       if (nomTF.getText().isEmpty()) {JOptionPane.showMessageDialog(null, "Le champ room ne doit pas être vide !", "Alert", JOptionPane.ERROR_MESSAGE);
        super.dispose();}
       else {
           if(ispublic==0)
           {
        a=getchoixdroit(md);
           }
        ispresent = DButilities.creationRoom(Principale.sl,Principale.u ,nomTF.getText(),descTF.getText(), a);
        if(ispresent){
        JOptionPane.showMessageDialog(null, "Le nom de la room existe dejà !", "Alert", JOptionPane.ERROR_MESSAGE);
        super.dispose();
        }
        else  {
            JOptionPane.showMessageDialog(null, "Room Ajoutée", "Info", JOptionPane.INFORMATION_MESSAGE);
        super.dispose();
        }}
       
       
    }//GEN-LAST:event_creerButtonActionPerformed

    private void publicRBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_publicRBActionPerformed
    creerSalonTable.setVisible(false);
    ispublic=1;
    }//GEN-LAST:event_publicRBActionPerformed

    private void privateRBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_privateRBActionPerformed

        creerSalonTable.setVisible(true);
        md = (DefaultTableModel) creerSalonTable.getModel();
        erasetab(md);
       
        getinfos(md);
         setfalse(md);
    }//GEN-LAST:event_privateRBActionPerformed

    private void quitterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitterButtonActionPerformed
       super.dispose();
    }//GEN-LAST:event_quitterButtonActionPerformed

    public void erasetab(DefaultTableModel m) {
        int rowCount = m.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            m.removeRow(i);
        }
    }
    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(CreerSalon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreerSalon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreerSalon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreerSalon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CreerSalon().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton creerButton;
    private javax.swing.JTable creerSalonTable;
    private javax.swing.JLabel descLabel;
    private javax.swing.JTextField descTF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel nomLabel;
    private javax.swing.JTextField nomTF;
    private javax.swing.JRadioButton privateRB;
    private javax.swing.JRadioButton publicRB;
    private javax.swing.JButton quitterButton;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}
