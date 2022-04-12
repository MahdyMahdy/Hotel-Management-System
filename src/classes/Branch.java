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
public class Branch {
    private int branch_id;
    private int floors_nb;
    private String location;

    public Branch(int branch_id, int floors_nb, String location) {
        this.branch_id = branch_id;
        this.floors_nb = floors_nb;
        this.location = location;
    }

    public int getBranch_id() {
        return branch_id;
    }

    public int getFloors_nb() {
        return floors_nb;
    }

    public String getLocation() {
        return location;
    }

    public void setBranch_id(int branch_id) {
        this.branch_id = branch_id;
    }

    public void setFloors_nb(int floors_nb) {
        this.floors_nb = floors_nb;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    
    
    
}
