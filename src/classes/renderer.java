/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;

/**
 *
 * @author mahdi
 */
public class renderer extends DefaultTreeCellRenderer {

    @Override
    public Component getTreeCellRendererComponent(JTree jtree, Object o, boolean bln, boolean bln1, boolean bln2, int i, boolean bln3) {
        Component component = super.getTreeCellRendererComponent(jtree, o, bln, bln1, bln2, i, bln3);
        DefaultMutableTreeNode node=(DefaultMutableTreeNode)o;
        if(node.getUserObject().toString().startsWith("Room"))
        {
            ImageIcon icon;
            if(node.getUserObject().toString().endsWith("(AVAILBLE)"))
            {
                icon=new ImageIcon("src\\images\\roomAv.png");
            }
            else
            {
                icon=new ImageIcon("src\\images\\roomNotAv.png");
            }
            setIcon(icon);
        }
        else if(node.getUserObject().toString().startsWith("Floor"))
        {
            ImageIcon icon=new ImageIcon("src\\images\\floor.png");
            setIcon(icon);
        }
        else if(node.getUserObject().toString().startsWith("Branch"))
        {
            ImageIcon icon=new ImageIcon("src\\images\\branch.png");
            setIcon(icon);
        }
        else if(node.getUserObject().toString().startsWith("Hotel"))
        {
            ImageIcon icon=new ImageIcon("src\\images\\hotelicon.png");
            setIcon(icon);
        }
        else if(node.getUserObject().toString().startsWith("Informations"))
        {
            ImageIcon icon=new ImageIcon("src\\images\\info.png");
            setIcon(icon);
        }
        return component;
    }
    
    
    
}
