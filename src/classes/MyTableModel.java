/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mahdi
 */
public class MyTableModel extends DefaultTableModel{

    @Override
    public boolean isCellEditable(int i, int i1) {
        return false; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
