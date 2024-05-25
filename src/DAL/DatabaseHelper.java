/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Tommer Hu 22160969
 */
public class DatabaseHelper {
    
    private Connection conn;
    
    
    public DatabaseHelper() throws SQLException{
        establishConnection();
    }
    
    
    public Connection getConnection(){
        return this.conn;
    }
    
    
    public void closeConnection() throws SQLException{
        if(conn!=null){
            conn.close();
        }
    }
    
    /**
     * Establish the connection with the embedded database.
     * Invoked at constructor.
     */
    public void establishConnection() throws SQLException{
        String url = "jdbc:derby:CarManagerDB_Ebd;create=true";
        this.conn = DriverManager.getConnection(url,"carManager","carManager");
        System.out.println(url+"connected.");
    }
   
}

