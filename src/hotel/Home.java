/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTabbedPane;

/**
 *
 * @author mahdi
 */
public class Home extends javax.swing.JFrame {

   

    /**
     * Creates new form Home
     */
    public Home() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabbebPane = new javax.swing.JTabbedPane();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        logoutMenuItem = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem1 = new javax.swing.JMenuItem();
        adminMenu = new javax.swing.JMenu();
        insertMenu = new javax.swing.JMenu();
        branchMenu = new javax.swing.JMenuItem();
        roomMenu = new javax.swing.JMenuItem();
        roomTypeMenuItem = new javax.swing.JMenuItem();
        updateMenu = new javax.swing.JMenu();
        priceMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tabbebPane.setBackground(new java.awt.Color(255, 255, 255));

        fileMenu.setBackground(new java.awt.Color(255, 255, 255));
        fileMenu.setText("File");

        logoutMenuItem.setBackground(new java.awt.Color(255, 255, 255));
        logoutMenuItem.setText("LogOut");
        logoutMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(logoutMenuItem);
        fileMenu.add(jSeparator1);

        jMenuItem1.setBackground(new java.awt.Color(255, 255, 255));
        jMenuItem1.setText("Quit");
        fileMenu.add(jMenuItem1);

        menuBar.add(fileMenu);

        adminMenu.setBackground(new java.awt.Color(255, 255, 255));
        adminMenu.setText("Edit");
        adminMenu.setEnabled(false);

        insertMenu.setBackground(new java.awt.Color(255, 255, 255));
        insertMenu.setText("Insert");

        branchMenu.setBackground(new java.awt.Color(255, 255, 255));
        branchMenu.setText("Branch");
        branchMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                branchMenuActionPerformed(evt);
            }
        });
        insertMenu.add(branchMenu);

        roomMenu.setBackground(new java.awt.Color(255, 255, 255));
        roomMenu.setText("Room");
        roomMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roomMenuActionPerformed(evt);
            }
        });
        insertMenu.add(roomMenu);

        roomTypeMenuItem.setBackground(new java.awt.Color(255, 255, 255));
        roomTypeMenuItem.setText("Room Type");
        roomTypeMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roomTypeMenuItemActionPerformed(evt);
            }
        });
        insertMenu.add(roomTypeMenuItem);

        adminMenu.add(insertMenu);

        updateMenu.setBackground(new java.awt.Color(255, 255, 255));
        updateMenu.setText("Update");

        priceMenuItem.setText("Price");
        priceMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                priceMenuItemActionPerformed(evt);
            }
        });
        updateMenu.add(priceMenuItem);

        adminMenu.add(updateMenu);

        menuBar.add(adminMenu);
        if(Hotel.getRole().equals("admin"))
        {
            adminMenu.setEnabled(true);
        }

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabbebPane, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabbebPane, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void logoutMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutMenuItemActionPerformed
        this.setVisible(false);
        Hotel.getLogin().setVisible(true);
    }//GEN-LAST:event_logoutMenuItemActionPerformed

    private void branchMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_branchMenuActionPerformed
        InsertBranch insert=new InsertBranch(this,false);
        insert.setSize(400,250);
        insert.setLocationRelativeTo(this);
        insert.setVisible(true);
    }//GEN-LAST:event_branchMenuActionPerformed

    private void roomMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roomMenuActionPerformed
        InsertRoom insert=new InsertRoom(this,false);
        insert.setSize(480,250);
        insert.setLocationRelativeTo(this);
        insert.setVisible(true);
        insert.setTitle("Room");
    }//GEN-LAST:event_roomMenuActionPerformed

    private void roomTypeMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roomTypeMenuItemActionPerformed
        try {
            InsertRoomType insertRoomType=new InsertRoomType(this,false);
            insertRoomType.setSize(400,180);
            insertRoomType.setLocationRelativeTo(this);
            insertRoomType.setVisible(true);
            insertRoomType.setTitle("Room Type");
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_roomTypeMenuItemActionPerformed

    private void priceMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_priceMenuItemActionPerformed
        UpdatePrice updatePrice=new UpdatePrice(this,false);
        updatePrice.setSize(400,220);
        updatePrice.setLocationRelativeTo(this);
        updatePrice.setVisible(true);
        updatePrice.setTitle("Price");
    }//GEN-LAST:event_priceMenuItemActionPerformed


    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu adminMenu;
    private javax.swing.JMenuItem branchMenu;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenu insertMenu;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JMenuItem logoutMenuItem;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem priceMenuItem;
    private javax.swing.JMenuItem roomMenu;
    private javax.swing.JMenuItem roomTypeMenuItem;
    private static javax.swing.JTabbedPane tabbebPane;
    private javax.swing.JMenu updateMenu;
    // End of variables declaration//GEN-END:variables

    public JTabbedPane getTabbebPane() {
        return tabbebPane;
    }

}