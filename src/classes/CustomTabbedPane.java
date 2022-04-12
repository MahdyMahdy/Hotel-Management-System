/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import hotel.Login;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JTabbedPane;

/**
 *
 * @author mahdi
 */
public class CustomTabbedPane extends JTabbedPane{

    private BufferedImage backgroundImage;

    @Override
    public void paintComponent(Graphics grphcs) {
        super.paintComponent(grphcs); 
        grphcs.drawImage(backgroundImage, 0,0,this.getWidth(),this.getHeight(), this);
    }

    public CustomTabbedPane() {
        super();
        try {
            this.backgroundImage=ImageIO.read(new File("src\\images\\home.jpg"));
        } catch (IOException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
}
