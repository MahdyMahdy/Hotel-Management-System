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
public class Own {
    private int branch_id;
    private int room_id;

    public Own(int branch_id, int room_id) {
        this.branch_id = branch_id;
        this.room_id = room_id;
    }

    public int getBranch_id() {
        return branch_id;
    }

    public int getRoom_id() {
        return room_id;
    }

    public void setBranch_id(int branch_id) {
        this.branch_id = branch_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }
    
    
}
