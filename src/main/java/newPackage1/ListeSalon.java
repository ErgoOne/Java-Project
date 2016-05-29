/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newPackage1;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.Timer;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import static newPackage1.DButilities.putRoomtoSalon;

/**
 *
 * @author Jonathan
 */
public class ListeSalon extends javax.swing.JFrame {

    DefaultTableModel model;
    ArrayList<Chatroom> cr = new ArrayList<>();
     //Chatroom room;
   // Chatroom  room;
    /**
     * Creates new form ListeSalon
     * @throws java.sql.SQLException
     */
    
    
    public ListeSalon() {
        initComponents();
        model = (DefaultTableModel) jTableSalon.getModel();
        getinfos(model);
       
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                    refreshUImessage();

            }
        });

        timer.start();
    }



    private void refreshUImessage(){
        erasetab(model);
        getinfos(model);
    }

    public void getinfos(DefaultTableModel m) {
        HashMap<String, String> h = new HashMap<>();
        putRoomtoSalon(Principale.sl);
        h = Principale.sl.getSalon();

        Set cles = h.keySet();
        Iterator it = cles.iterator();
        while (it.hasNext()) {
            Object cle = it.next(); // tu peux typer plus finement ici
            Object valeur = h.get(cle); // tu peux typer plus finement ici

            m.addRow(new Object[]{cle, valeur});

        }
    }
   
  
//Remove rows one by one from the end of the table
    public void erasetab(DefaultTableModel m) {
        int rowCount = m.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            m.removeRow(i);
        }
    }

    public void close() {

        WindowEvent winClosingEvent = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
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

        popupMenu1 = new java.awt.PopupMenu();
        jLabel1 = new javax.swing.JLabel();
        exitButton = new javax.swing.JToggleButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableSalon = new javax.swing.JTable();
        refreshButton = new javax.swing.JButton();

        popupMenu1.setLabel("popupMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 22)); // NOI18N
        jLabel1.setText("Liste des salons");

        exitButton.setText("Quitter");
        exitButton.setToolTipText("");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });

        jTableSalon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Room", "Description"
            }
        ));
        jTableSalon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableSalonMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTableSalon);

        refreshButton.setText("Rafraichir");
        refreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(160, 160, 160)
                        .addComponent(refreshButton, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(exitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 11, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(exitButton)
                    .addComponent(refreshButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        // TODO add your handling code here:
        super.dispose();
    }//GEN-LAST:event_exitButtonActionPerformed

    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButtonActionPerformed
             refreshUImessage();
        
    }//GEN-LAST:event_refreshButtonActionPerformed

    private void jTableSalonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableSalonMouseClicked
        int count = cr.size();
        boolean r = false;
        Chatroom [] myArray = new Chatroom[count + 1];
        
        int index = jTableSalon.getSelectedRow();
        TableModel model= jTableSalon.getModel();
        
       
        String numroom = model.getValueAt(index, 0).toString();
        String desc = model.getValueAt(index, 1).toString();
        myArray[count] = new Chatroom(numroom, desc);
        cr.add(myArray[count]);
        System.out.println("DESSSSCCCC : "+desc);
        
        
        //room.pack();
        Chatroom ret = (Chatroom.getInstance(numroom, desc));
        ret.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //room.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ret.setVisible(true);
        ret.numRoomLabel.setText(numroom);
       ret.descri.setText(desc);
        //room.setRoomname(numroom);
        //room.setDesc(desc);
        
     
        
        
    }//GEN-LAST:event_jTableSalonMouseClicked
   

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
            java.util.logging.Logger.getLogger(ListeSalon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListeSalon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListeSalon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListeSalon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
      
                    new ListeSalon().setVisible(true);
            
                

            }
        });

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton exitButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableSalon;
    private java.awt.PopupMenu popupMenu1;
    private javax.swing.JButton refreshButton;
    // End of variables declaration//GEN-END:variables
}
