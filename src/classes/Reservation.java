/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 *
 * @author mahdi
 */
public class Reservation {
    private int id;
    private String check_in;
    private String check_out;

    public Reservation(int id, String check_in, String check_out) {
        this.id = id;
        this.check_in = check_in;
        this.check_out = check_out;
    }

    public int getId() {
        return id;
    }

    public String getCheck_in() {
        return check_in;
    }

    public String getCheck_out() {
        return check_out;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCheck_in(String check_in) {
        this.check_in = check_in;
    }

    public void setCheck_out(String check_out) {
        this.check_out = check_out;
    }
    
    
}
