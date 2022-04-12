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
public class MakeReservation {
    private int cust_id;
    private int room_id;
    private int reserv_id;
    private int emp_id;

    public MakeReservation(int cust_id, int room_id, int reserv_id, int emp_id) {
        this.cust_id = cust_id;
        this.room_id = room_id;
        this.reserv_id = reserv_id;
        this.emp_id = emp_id;
    }

    public int getCust_id() {
        return cust_id;
    }

    public int getRoom_id() {
        return room_id;
    }

    public int getReserv_id() {
        return reserv_id;
    }

    public int getEmp_id() {
        return emp_id;
    }

    public void setCust_id(int cust_id) {
        this.cust_id = cust_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }

    public void setReserv_id(int reserv_id) {
        this.reserv_id = reserv_id;
    }

    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }
    
    
}
