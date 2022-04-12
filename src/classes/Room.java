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
public class Room {
    private int room_id;
    private int floor_nb;
    private int beds_nb;
    private String type;
    
    public Room(int room_id, int floor_nb, int beds_nb, String type) {
        this.room_id = room_id;
        this.floor_nb = floor_nb;
        this.beds_nb = beds_nb;
        this.type = type;
    }

    public void setBeds_nb(int beds_nb) {
        this.beds_nb = beds_nb;
    }

    public int getBeds_nb() {
        return beds_nb;
    }

    public int getRoom_id() {
        return room_id;
    }

    public int getFloor_nb() {
        return floor_nb;
    }

    public String getType() {
        return type;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }

    public void setFloor_nb(int floor_nb) {
        this.floor_nb = floor_nb;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    
    
}
