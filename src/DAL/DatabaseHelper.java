/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Jason
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
   
    /**
     * get the total data count for a database table
     * @param table which table is in query
     * @return data count
     */
    public static int getDataCount(String queryTable){
        try{
            DatabaseHelper DbHelper  = new DatabaseHelper();
            Statement statement = DbHelper.getConnection().createStatement();
            String query = "select count(*) from "+queryTable;
            ResultSet rs = statement.executeQuery(query);
            rs.next();
            return rs.getInt(1);
        }catch(SQLException e){
            e.printStackTrace();
        }
        return 0;
    }
    
}

