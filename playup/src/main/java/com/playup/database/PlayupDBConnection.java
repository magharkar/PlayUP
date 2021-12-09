/**
 * @author vibhorbhatnagar
 */

package com.playup.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PlayupDBConnection {

	private static PlayupDBConnection instance;
	private static Connection connect = null;

	public static PlayupDBConnection getInstance() {
		if (instance == null) {
			instance = new PlayupDBConnection();
		}
		return instance;
	}

	private PlayupDBConnection() {
		connect = null;
		try {
			connect = DriverManager.getConnection("jdbc:mysql://db-5308.cs.dal.ca:3306/CSCI5308_1_DEVINT",
					"CSCI5308_1_DEVINT_USER", "piWai3foh6iechee");
			if (connect == null) {
				connect.close();
				return;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return;
		} 
	}

	public ResultSet readData(String query){
		synchronized (connect) {
			try {
				// Read the data from the table
				PreparedStatement ps = connect.prepareStatement(query);
				ResultSet rs = ps.executeQuery();
				if (rs == null) {
					connect.close();
					return null;
				}
				return rs;
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
	}

	public boolean updateData(String query) throws SQLException {
		synchronized (connect) {
			// Update the data in the table
			try {

				PreparedStatement ps = connect.prepareStatement(query);
				ps.executeUpdate();
				return true;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}

		}
	}

	public void stop() throws SQLException {
		connect.close();
	}

}
