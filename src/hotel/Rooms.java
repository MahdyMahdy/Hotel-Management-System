/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel;


import classes.renderer;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.JOptionPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreeSelectionModel;

/**
 *
 * @author mahdi
 */
public class Rooms extends javax.swing.JPanel {

    /**
     * Creates new form Rooms
     */
    private DefaultTreeModel roomsModel;
    private Connection con;
    private BufferedImage backgroundImage;
    @Override
    public void paintComponent(Graphics grphcs) {
        super.paintComponent(grphcs); 
        grphcs.drawImage(backgroundImage, 0,0,this.getWidth(),this.getHeight(), this);
    }
    public Rooms() {
        try {
            this.backgroundImage=ImageIO.read(new File("src\\images\\home.jpg"));
        } catch (IOException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con =DriverManager.getConnection(Hotel.getUrl());
            Statement stat=con.createStatement();
            DefaultMutableTreeNode hotel=new DefaultMutableTreeNode("Hotel");
            roomsModel=new DefaultTreeModel(hotel);
            ResultSet set=stat.executeQuery("SELECT branch_id FROM branch ORDER BY branch_id ASC");
            ArrayList<String> branchList=new ArrayList<>();
            while(set.next())
            {
                branchList.add(""+set.getInt(1));
            }
            for(int i=0;i<branchList.size();i++)
            {
                DefaultMutableTreeNode branch=new DefaultMutableTreeNode("Branch "+branchList.get(i));
                roomsModel.insertNodeInto(branch, hotel, hotel.getChildCount());
                set=stat.executeQuery("SELECT floors_nb FROM branch WHERE branch.branch_id="+branchList.get(i));
                ArrayList<String> floorList=new ArrayList<>();
                if(set.next())
                {
                    for(int k=0;k<set.getInt(1);k++)
                    {
                        floorList.add(""+(k+1));
                    }
                }
                for(int j=0;j<floorList.size();j++)
                {
                    DefaultMutableTreeNode floor=new DefaultMutableTreeNode("Floor "+floorList.get(j));
                    roomsModel.insertNodeInto(floor, branch, branch.getChildCount());
                    set=stat.executeQuery("SELECT room.room_id FROM room,own WHERE own.branch_id="+branchList.get(i)
                            +"and room.room_id=own.room_id and room.floor_nb="+floorList.get(j));
                    ArrayList<String> roomList=new ArrayList<>();
                    while(set.next())
                    { 
                        roomList.add(""+set.getInt(1));
                    }
                    for(int p=0;p<roomList.size();p++)
                    {
                        set=stat.executeQuery("SELECT COUNT(*) FROM room WHERE room.room_id="+roomList.get(p)
                                +" and room.room_id not in(SELECT make_reservation.room_id FROM make_reservation,reservation "
                                        +"WHERE make_reservation.reserv_id=reservation.reserv_id AND "
                                        + "reservation.check_out IS NULL)");
                        set.next();
                        int count=set.getInt(1);
                        DefaultMutableTreeNode room = null;
                        if(count>0)
                        {
                            room=new DefaultMutableTreeNode("Room "+roomList.get(p)+" (AVAILBLE)");
                        }
                        else
                        {
                            room=new DefaultMutableTreeNode("Room "+roomList.get(p)+" (NOT AVAILBLE)");
                        }
                        roomsModel.insertNodeInto(room, floor, floor.getChildCount());
                    }
                }
            }
            con.close();
            }catch(ClassNotFoundException | SQLException e){
                System.out.println(e.getMessage());
            }
        initComponents();
        this.getRoomsTree().setCellRenderer(new renderer());
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
        roomsTree = new javax.swing.JTree();
        checkInButton = new javax.swing.JButton();
        pathTextField = new javax.swing.JTextField();
        pathLabel = new javax.swing.JLabel();
        checkOutButton = new javax.swing.JButton();

        roomsTree.setModel(this.roomsModel);
        roomsTree.setSelectionRows(null);
        roomsTree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        roomsTree.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                roomsTreeMouseClicked(evt);
            }
        });
        roomsTree.addTreeWillExpandListener(new javax.swing.event.TreeWillExpandListener() {
            public void treeWillCollapse(javax.swing.event.TreeExpansionEvent evt)throws javax.swing.tree.ExpandVetoException {
            }
            public void treeWillExpand(javax.swing.event.TreeExpansionEvent evt)throws javax.swing.tree.ExpandVetoException {
                expand(evt);
            }
        });
        roomsTree.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                none(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                none(evt);
            }
        });
        jScrollPane1.setViewportView(roomsTree);

        checkInButton.setBackground(new Color(255,255,255));
        checkInButton.setText("To CheckIn");
        checkInButton.setEnabled(false);
        checkInButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkInButtonActionPerformed(evt);
            }
        });

        pathTextField.setEditable(false);

        pathLabel.setText("Path : ");

        checkOutButton.setBackground(new java.awt.Color(255, 255, 255));
        checkOutButton.setText("To CheckOut");
        checkOutButton.setEnabled(false);
        checkOutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkOutButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 469, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(checkInButton)
                        .addGap(18, 18, 18)
                        .addComponent(checkOutButton)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pathLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pathTextField)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pathTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pathLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkInButton)
                    .addComponent(checkOutButton))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void checkInButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkInButtonActionPerformed
        Object[] path=Rooms.roomsTree.getSelectionPath().getPath();
        if(path.length!=0)
        {
            if(path[path.length-1].toString().endsWith("(AVAILBLE)"))
            {
                try {
                    Hotel.getHome().getTabbebPane().setSelectedIndex(0);
                    int branchId=Integer.parseInt(path[1].toString().split(" ")[1]);
                    Hotel.getCheckIn().getBranchComboBox().setSelectedItem(branchId);
                    int roomId=Integer.parseInt(path[path.length-1].toString().split(" ")[1]);
                    this.con=DriverManager.getConnection(Hotel.getUrl());
                    Statement stat=this.con.createStatement();
                    ResultSet set=stat.executeQuery("SELECT type,beds_nb FROM room WHERE room_id="+roomId);
                    if(set.next())
                    {
                        String type=set.getString(1);
                        Hotel.getCheckIn().getRoomTypeComboBox().setSelectedItem(type);
                        int beds=set.getInt(2);
                        Hotel.getCheckIn().getBedsNbComboBox().setSelectedItem(beds);
                        Hotel.getCheckIn().setTargetRoomId(roomId);
                        Hotel.getCheckIn().getRoomTypeNotesTextArea()
                                .setText("Target room : "+roomId+"\n************************");
                    }
                    stat.close();
                    con.close();
                            } catch (SQLException ex) {
                    Logger.getLogger(Rooms.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_checkInButtonActionPerformed

    private void expand(javax.swing.event.TreeExpansionEvent evt)throws javax.swing.tree.ExpandVetoException {//GEN-FIRST:event_expand
        
    }//GEN-LAST:event_expand

    private void roomsTreeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_roomsTreeMouseClicked
        try {
            String path=this.getRoomsTree().getSelectionPath().toString();
        path=path.substring(1, path.length()-1);
        String[] p=path.split(",");
        if(p[p.length-1].startsWith(" Room"))
        {
            String[] p1=p[p.length-1].split(" ");
            path="";
            for(int i=0;i<p.length-1;i++)
            {
                path+=p[i]+"\\";
            }
            path+=p1[1]+" ";
            path+=p1[2];
            if(p1[p1.length-1].endsWith("(AVAILBLE)"))
            {
                this.checkInButton.setEnabled(true);
                this.checkOutButton.setEnabled(false);
            }
            else
            {
                this.checkOutButton.setEnabled(true);
                this.checkInButton.setEnabled(false);
            }
        }
        else
        {
            this.checkInButton.setEnabled(false);
            this.checkOutButton.setEnabled(false);
            path="";
            int i;
            for(i=0;i<p.length-1;i++)
            {
                path+=p[i]+"\\";
            }
            path+=p[i];
        }
        this.pathTextField.setText(path);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_roomsTreeMouseClicked

    private void none(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_none
        String path=this.getRoomsTree().getSelectionPath().toString();
        path=path.substring(1, path.length()-1);
        String[] p=path.split(",");
        if(p[p.length-1].startsWith(" Room"))
        {
            String[] p1=p[p.length-1].split(" ");
            path="";
            for(int i=0;i<p.length-1;i++)
            {
                path+=p[i]+"\\";
            }
            path+=p1[1]+" ";
            path+=p1[2];
            if(p1[p1.length-1].endsWith("(AVAILBLE)"))
            {
                this.checkInButton.setEnabled(true);
                this.checkOutButton.setEnabled(false);
            }
            else
            {
                this.checkOutButton.setEnabled(true);
                this.checkInButton.setEnabled(false);
            }
        }
        else
        {
            this.checkInButton.setEnabled(false);
            this.checkOutButton.setEnabled(false);
            path="";
            int i;
            for(i=0;i<p.length-1;i++)
            {
                path+=p[i]+"\\";
            }
            path+=p[i];
        }
        this.pathTextField.setText(path);
    }//GEN-LAST:event_none

    private void checkOutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkOutButtonActionPerformed
        Object[] path=Rooms.roomsTree.getSelectionPath().getPath();
        if(path.length!=0)
        {
            if(path[path.length-1].toString().endsWith("(NOT AVAILBLE)"))
            {
                try {
                    int roomId=Integer.parseInt(path[path.length-1].toString().split(" ")[1]);
                    this.con=DriverManager.getConnection(Hotel.getUrl());
                    Statement stat=this.con.createStatement();
                    ResultSet set=stat.executeQuery("SELECT reservation.reserv_id FROM make_reservation,reservation "
                            + "WHERE make_reservation.room_id="+roomId+" AND reservation.check_out is null");
                    if(set.next())
                    {
                        Hotel.getCheckOut().getReservationIdTextField().setText(""+set.getInt(1));
                        Hotel.getCheckOut().getCheckIdButton().doClick();
                        Hotel.getHome().getTabbebPane().setSelectedIndex(1);
                    }
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Rooms.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_checkOutButtonActionPerformed

    public JTree getRoomsTree() {
        return roomsTree;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton checkInButton;
    private javax.swing.JButton checkOutButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel pathLabel;
    private javax.swing.JTextField pathTextField;
    private static javax.swing.JTree roomsTree;
    // End of variables declaration//GEN-END:variables
}
