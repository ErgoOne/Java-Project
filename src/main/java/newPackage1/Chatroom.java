/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newPackage1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;
import javax.swing.DefaultListModel;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import static newPackage1.DButilities.AfficherNvMess;

/**
 *
 * @author Badr
 */
public class Chatroom extends javax.swing.JFrame {
    Room r;
        String roomname=null;
        String roomdesc=null;
     //ArrayList<String> a;
        private static Vector classes = new Vector();
     DefaultTableModel model1;
     DefaultListModel model= new DefaultListModel();

     public static Chatroom getInstance(String attribut1, String attribut2) {
            
                System.out.println("ATTT 1 /" +attribut1 +" ATTT 2 / "+attribut2);
		Chatroom tmp = new Chatroom(attribut1, attribut2);
		if (classes.contains(tmp)) {
			// on doit retrouver l'element
			Enumeration enume = classes.elements();
			while (enume.hasMoreElements()) {
				Chatroom element = (Chatroom) enume.nextElement();
				if (element.equals(tmp)) {
					return element;
				}
			}
		}
		else {
			classes.add(tmp);
			return tmp;
		}
                                // si on arrive là, c'est qu'il y à un problème
                                return null;
	}
    public void setRoomname(String roomname) {
        this.roomname = roomname;
    }

    public String getRoomdesc() {
        return roomdesc;
    }

    public void setRoomdesc(String roomdesc) {
        this.roomdesc = roomdesc;
    }

    /**
     * Creates new form chatroom
     */



    public String getRoomname() {
        return roomname;
    }

  
    public Chatroom(String ro, String d) {
        initComponents();
        this.roomname=ro;
        this.roomdesc=d;
        
        //a= new ArrayList<>();
        
  
        //descri.getCon
        model1 = (DefaultTableModel) jTable1.getModel();
        getinfos(model1);
        System.out.println(" DESC : "+d+" ROOOMNAME : "+ro);
        this.r=Room.getInstance(ro, d);
        DButilities.AfficherttMess(r);
       Timer timer = new Timer(3000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    affotherstext();
                    refreshUImessage();
             
           }
        });

        timer.start();
    }

    private void refreshUImessage(){
    erasetab(model1);
    getinfos(model1);
    }
    
   public void getinfos(DefaultTableModel m) {
        HashMap<String, String> h = new HashMap<>();
        //putRoomtoSalon(Principale.sl);
        h =DButilities.AfficherUtilisateur();

        Set cles = h.keySet();
        Iterator it = cles.iterator();
        while (it.hasNext()) {
            Object cle = it.next(); // tu peux typer plus finement ici
            Object valeur = h.get(cle); // tu peux typer plus finement ici

            m.addRow(new Object[]{cle, valeur});

        }
    }
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
        envoyerButton = new javax.swing.JButton();
        refreshButton = new javax.swing.JButton();
        descri = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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

        numRoomLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        numRoomLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        numRoomLabel.setText("RoomX");

        envoyerButton.setText("Envoyer");
        envoyerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                envoyerButtonActionPerformed(evt);
            }
        });

        refreshButton.setText("Rafraichir");

        descri.setText("tttt");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Pseudo", "Statut"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(descri, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(numRoomLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 209, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(numRoomLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(refreshButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(envoyerButton))
                    .addComponent(envoyerTF, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(numRoomLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(descri, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(envoyerTF, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(envoyerButton)
                    .addComponent(refreshButton))
                .addContainerGap(197, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    private void add(String s){
        affichageJL.setModel(model);
        //model.addElement("TOTO");
        afftext(s);
        
    }
    private void envoyerTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_envoyerTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_envoyerTFActionPerformed

    private void envoyerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_envoyerButtonActionPerformed
   add(envoyerTF.getText());
   
    envoyerTF.setText("");
   
    }//GEN-LAST:event_envoyerButtonActionPerformed

    private void affichageJLValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_affichageJLValueChanged
    String selected= affichageJL.getSelectedValue().toString();
    envoyerTF.setText(selected);
       afftext(selected);
    }//GEN-LAST:event_affichageJLValueChanged

    private void firtaff(ArrayList<String> a){
     for (String str : a) {
			  model.addElement(str);
		}
    }
    
    private void afftext(String s){
 
        if(s != null && !s.isEmpty() && (s.trim().length() > 0)) 
        {
            //String temp= ("MSG - "+DButilities.getdate()+" : "+Principale.u.getPseudo()+ " : "+s);
        //envoyerTF.setText(temp);
        //model.addElement(temp);
        Mesg m = new Mesg(s);
        m.setDate(DButilities.getdate());
        DButilities.CreerMsg(m, Principale.u, r);
        }
    }
   public void affotherstext() {
      ArrayList<String> a = new ArrayList<>();
       a=AfficherNvMess(DButilities.getDerMsgDate(Principale.u,r),r);
       this.model.clear();
       
       
       for (String str : a) {
			  model.addElement(str);
		}
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    public javax.swing.JLabel numRoomLabel;
    private javax.swing.JButton refreshButton;
    // End of variables declaration//GEN-END:variables
}
