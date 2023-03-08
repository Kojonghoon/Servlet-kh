package com.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCTemplate {
    public JDBCTemplate() {}
    
    public static Connection getConnection() {
        Connection con  = null;
        Properties prop = new Properties();
        try {
            String currentPath = JDBCTemplate.class.getResource( "./" ).getPath();
            prop.load( new BufferedReader( new FileReader( currentPath + "driver.properties" ) ) );
            Class.forName( prop.getProperty( "driver" ) );
            con = DriverManager.getConnection( prop.getProperty( "url" ), prop.getProperty( "user" ), prop.getProperty( "pwd" ) );
        }
        catch ( Exception e ) {
            e.printStackTrace();
        }
        return con;
    }
    
    public static void close( Connection con ) {
        try {
            if ( con != null && !con.isClosed() ) {
                con.close();
            }
        }
        catch ( SQLException e ) {
            e.printStackTrace();
        }
    }
    
    public static void close( Statement stmt ) {
        try {
            if ( stmt != null && !stmt.isClosed() ) {
                stmt.close();
            }
        }
        catch ( SQLException e ) {
            e.printStackTrace();
        }
    }
    
    public static void close( ResultSet rset ) {
        try {
            if ( rset != null && !rset.isClosed() ) {
                rset.close();
            }
        }
        catch ( SQLException e ) {
            e.printStackTrace();
        }
    }
    
    public static void commit( Connection con ) {
        try {
            if ( con != null && !con.isClosed() ) {
                con.commit();
            }
        }
        catch ( SQLException e ) {
            e.printStackTrace();
        }
    }
    
    public static void rollback( Connection con ) {
        try {
            if ( con != null && !con.isClosed() ) {
                con.rollback();
            }
        }
        catch ( SQLException e ) {
            e.printStackTrace();
        }
    }
    
    public static void main( String args[] ) {
        Connection con = getConnection();
        System.out.println( con );
    }
}