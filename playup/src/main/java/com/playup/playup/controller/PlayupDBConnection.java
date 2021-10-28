package com.playup.playup.controller;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

public class PlayupDBConnection {
    public static List<String> dbConnect() {
        String sqlSelectAllUsers = "SELECT * FROM User";
        String connectionUrl = "jdbc:mysql://db-5308.cs.dal.ca:3306/CSCI5308_1_DEVINT";
        List<String> names = new ArrayList<String>();
        try (Connection connect = DriverManager.getConnection(
                connectionUrl, "CSCI5308_1_DEVINT_USER", "piWai3foh6iechee");
            PreparedStatement ps = connect.prepareStatement(sqlSelectAllUsers);
            ResultSet rs = ps.executeQuery()) {
        	while (rs.next()) {
                String name = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String fullName = name + " " + lastName;
                names.add(fullName);
            }
            if(connect != null) {
                connect.close();
                System.out.println("Connection closed");
            }    
        }catch(Exception e) {
            System.out.println(e);
        }
		return names;
    }
}
