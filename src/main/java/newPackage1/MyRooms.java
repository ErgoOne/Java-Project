/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newPackage1;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Badr
 */
public class MyRooms extends javax.swing.JFrame {

    ArrayList<String> b ;
    ArrayList<String> a;
    DefaultTableModel md; 
      public void getinfos(DefaultTableModel m) {
      
      }
    /**
     * Creates new form MyRooms
     */
    public MyRooms() {
        a = new ArrayList<>();
        b = new ArrayList<>();
        initComponents();
        jTable1.setVisible(true);
        md = (DefaultTableModel) jTable1.getModel();;
        
        
      
        a=DButilities.getmyrooms();
        	for (String name : a) {
			System.out.println(name);
		}
        int j=0;
        int i=0;
        System.out.println(a.size());
        
        while(i<a.size()){
          System.out.println("array list: "+a.get(i));
                      
	md.addRow(new Object[]{a.get(i), a.get(i+1)});
                        System.out.println("j'en suis a l'index : "+i);
                        i=i+2;
        }
          setfalse(md);
        /*for ( i = 0; i < a.size(); i++) {
                        
			md.setValueAt(a.get(j), i,0);
                        md.setValueAt(a.get(j+1), i,1); 
                        j+=2;
     
		}*/
       
    }
        public ArrayList<String> getchoixsupp (DefaultTableModel m) {
         ArrayList<String> a = new ArrayList<>();
         int x=0;
            System.out.println("newPackage1.MyRooms.getchoixsupp() ROW COUNT  : "+m.getRowCount());
         for(int i =0; i<m.getRowCount() ; i++){
          Boolean isChecked = Boolean.valueOf(m.getValueAt(i,2 ).toString());
          if(isChecked){x=1;}}
         if(x==1){
          for(int row = 0;row < m.getRowCount();row++) {
            Boolean isChecked = Boolean.valueOf(m.getValueAt(row,2 ).toString());
             if(isChecked){
             a.add((String) m.getValueAt(row, 0)); }
         }
          	for (String name : a) {
			System.out.println("SA MARCHE ? ! "+name);
		}
          return a;
          }
         else 
         {a=new ArrayList<>();
         return a;
         }
        
     }
public void setfalse(DefaultTableModel m){
     
          for(int row = 0;row < m.getRowCount();row++) {
          m.setValueAt(Boolean.FALSE, row, 2);
          }
          System.out.println("OK");
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
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        applyButton = new javax.swing.JButton();
        quitterButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nom du salon", "Descriptif", "Supprimer"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Mes salons");

        applyButton.setText("Appliquer");
        applyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                applyButtonActionPerformed(evt);
            }
        });

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
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(153, 153, 153)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(applyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(quitterButton, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(75, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(applyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(quitterButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5))
        );

        setSize(new java.awt.Dimension(537, 408));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void quitterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitterButtonActionPerformed
super.dispose();        
    }//GEN-LAST:event_quitterButtonActionPerformed

    private void applyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_applyButtonActionPerformed
         b=getchoixsupp(md);
         	for (String name : b) {
			System.out.println("DANS BUTTON : "+name);
		}
         if(b.isEmpty()){
         JOptionPane jco = new JOptionPane();    
         JOptionPane.showMessageDialog(null, "Le champ est vide", "Erreur", JOptionPane.WARNING_MESSAGE );
         //super.dispose();
         }
         else {
         DButilities.suppmyroom(b);
          JOptionPane jco = new JOptionPane();    
         
         JOptionPane.showMessageDialog(null, "Instruction executée avec succés ", "OK", JOptionPane.INFORMATION_MESSAGE );
        //super.dispose();
        super.dispose();
         }
        
    }//GEN-LAST:event_applyButtonActionPerformed

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
            java.util.logging.Logger.getLogger(MyRooms.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MyRooms.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MyRooms.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MyRooms.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MyRooms().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton applyButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton quitterButton;
    // End of variables declaration//GEN-END:variables
}
