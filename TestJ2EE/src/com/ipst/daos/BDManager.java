package com.ipst.daos;
import java.sql.Connection;
import java.sql.DriverManager;


public class BDManager {
    private static String url = "jdbc:mysql://localhost:3306/garbagecollector";
    //private static String driver = "com.mysql.jdbc.Driver";
    private static String login = "root";
    private static String password = "ipst";
    
    public static Connection getConnexion() throws Exception{
        //Class c = Class.forName("com.mysql.jdbc.Driver");
        //Driver d = (Driver) c.newInstance();
        //DriverManager.registerDriver(d);
    	Class.forName("com.mysql.jdbc.Driver");
        Connection cnx = DriverManager.getConnection(url, login, password);
        return cnx;
    }
}
