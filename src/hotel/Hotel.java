/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author mahdi
 */
public class Hotel {

    /**
     * @param args the command line arguments
     */
    private static String url;
    private static int emp_id;
    private static String role;
    private static Home home;
    private static Login login;
    private static CheckIn checkIn;
    private static CheckOut checkOut;
    private static Customers customer;
    private static Reservations reservations;
    private static Employees employees;
    private static Rooms rooms;
    
    public static void main(String[] args) throws SQLException {
        url="jdbc:sqlserver://localhost:1433;databaseName=Hotel;integratedSecurity=true";
        createDataBase();
        login=new Login();
        login.setSize(415,600);
        login.setLocationRelativeTo(null);
        login.setVisible(true);
    }
    
    public static void createDataBase()
    {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection(Hotel.getUrl());
            con.close();
        } catch (Exception ex) {
            try {
                Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;integratedSecurity=true");
                Statement stat=con.createStatement();
                stat.executeUpdate("Create Database Hotel");
                con.close();
                con = DriverManager.getConnection(Hotel.url);
                stat=con.createStatement();
                stat.executeUpdate("CREATE TABLE Branch (" +
                        "Branch_Id INTEGER PRIMARY KEY," +
                        "Floors_NB INTEGER NOT NULL," +
                        "Location VARCHAR(30) NOT NULL);" +
                        " " +
                        "CREATE TABLE price(" +
                        "type varChar(10) PRIMARY KEY," +
                        "pricePerNight INT)" +
                        " " +
                        "CREATE TABLE Room (" +
                        "Room_Id INTEGER PRIMARY KEY," +
                        "Floor_NB INTEGER NOT NULL," +
                        "Beds_Nb INT," +
                        "Type VARCHAR(10) FOREIGN KEY references price(type));" +
                        " " +
                        "CREATE TABLE Reservation (" +
                        "Reserv_Id INTEGER PRIMARY KEY," +
                        "Check_In Date," +
                        "Check_Out Date);" +
                        " " +
                        "CREATE TABLE Customer (" +
                        "Cust_Id INTEGER PRIMARY KEY," +
                        "Cust_Name Varchar(20) NOT NULL," +
                        "Cust_LastName Varchar(20) NOT NULL," +
                        "Cust_PhoneNumber Varchar(20)," +
                        "Cust_Email Varchar(20));" +
                        " " +
                        "CREATE TABLE Employee (" +
                        "Emp_Id INTEGER PRIMARY KEY," +
                        "Emp_Name Varchar(20) NOT NULL," +
                        "Emp_LastName Varchar(20) NOT NULL," +
                        "Emp_PhoneNumber Varchar(20)," +
                        "Emp_Email Varchar(20)," +
                        "Emp_Salary Decimal(10,3));" +
                        " " +
                        "CREATE TABLE Log_IN (" +
                        "UserName VARCHAR(20) Primary key," +
                        "Password VARCHAR(20) NOT NULL," +
                        "Last_Seen DateTime NOT NULL," +
                        "Role VARCHAR(20) NOT NULL);" +
                        " " +
                        "CREATE TABLE has(" +
                        "Emp_Id INTEGER FOREIGN KEY references Employee(Emp_ID) ON UPDATE CASCADE ON DELETE CASCADE," +
                        "UserName VARCHAR(20) FOREIGN KEY references Log_In(UserName) ON UPDATE CASCADE ON DELETE CASCADE," +
                        "PRIMARY KEY(Emp_Id,UserName));" +
                        "" +
                        "CREATE TABLE Works(" +
                        "Emp_Id INTEGER FOREIGN KEY references Employee(Emp_ID) ON UPDATE CASCADE," +
                        "Branch_Id integer FOREIGN KEY references Branch(Branch_Id) ON UPDATE CASCADE," +
                        "PRIMARY KEY(Emp_Id,Branch_Id));" +
                        " " +
                        "CREATE TABLE Own(" +
                        "Branch_Id integer FOREIGN KEY references Branch(Branch_Id) ON UPDATE CASCADE," +
                        "Room_Id integer FOREIGN KEY references Room(Room_Id) ON UPDATE CASCADE," +
                        "PRIMARY KEY(Branch_Id,Room_Id));" +
                        " " +
                        "CREATE TABLE Make_Reservation(" +
                        "Cust_Id integer FOREIGN KEY references Customer(Cust_Id) ON UPDATE CASCADE," +
                        "Room_Id integer FOREIGN KEY references Room(Room_Id) ON UPDATE CASCADE," +
                        "Reserv_Id integer FOREIGN KEY references Reservation(Reserv_Id) ON UPDATE CASCADE," +
                        "Emp_Id INTEGER DEFAULT 1 FOREIGN KEY references Employee(Emp_ID) ON UPDATE CASCADE ON DELETE SET DEFAULT," +
                        "PRIMARY KEY(Cust_Id,Room_Id,Reserv_Id,Emp_Id));" +
                        " " +
                        "INSERT INTO price VALUES('Entry',100);" +
                        "Insert Into Employee values(0,'admin','admin','1234556','qwdf@adde',null);" +
                        "Insert Into log_in values('admin','123456',GETDATE(),'admin');" +
                        "Insert Into has values(0,'admin');");
                con.close();
            } catch (SQLException ex1) {
                Logger.getLogger(Hotel.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }
    
    public static Rooms getRooms() {
        return rooms;
    }

    public static void setRooms(Rooms rooms) {
        Hotel.rooms = rooms;
    }

    public static void setCustomer(Customers customer) {
        Hotel.customer = customer;
    }

    public static void setReservations(Reservations reservations) {
        Hotel.reservations = reservations;
    }

    public static void setEmployees(Employees employees) {
        Hotel.employees = employees;
    }

    public static Customers getCustomer() {
        return customer;
    }

    public static Reservations getReservations() {
        return reservations;
    }

    public static Employees getEmployees() {
        return employees;
    }

    public static void setCheckOut(CheckOut checkOut) {
        Hotel.checkOut = checkOut;
    }

    public static CheckOut getCheckOut() {
        return checkOut;
    }

    public static void setCheckIn(CheckIn checkIn) {
        Hotel.checkIn = checkIn;
    }

    public static CheckIn getCheckIn() {
        return checkIn;
    }

    public static Home getHome() {
        return home;
    }

    public static int getEmp_id() {
        return emp_id;
    }

    public static String getUrl() {
        return url;
    }

    public static String getRole() {
        return role;
    }

    public static Login getLogin() {
        return login;
    }

    public static void setEmp_id(int emp_id) {
        Hotel.emp_id = emp_id;
    }

    public static void setRole(String role) {
        Hotel.role = role;
    }

    public static void setHome(Home home) {
        Hotel.home = home;
    }

    public static void setLogin(Login login) {
        Hotel.login = login;
    }
    
}
