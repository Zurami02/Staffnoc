package com.mbtec.staffnoc.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    private static final String URL = "jdbc:mysql://localhost:3306/nocstaff?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    private static Connection connection;

    private Conexao(){

    }

    public static Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()){
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
            }
        }catch (ClassNotFoundException e){
            System.err.println("Driver not found: " + e.getMessage());
        }catch (SQLException e){
            System.err.println("Erro on connecting the DB: " + e.getMessage());
        }
        return connection;
    }

    public static void closeConnection(){
        try{
            if (connection != null && !connection.isClosed()){
                connection.close();
            }
        } catch (SQLException e) {
            System.err.println("Erro on closing the connection");
        }
    }
}
