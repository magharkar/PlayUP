package com.playup.dao;


import com.playup.database.PlayupDBConnection;
import com.playup.model.SupportModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SupportDao implements ISupportDao{

    private static SupportDao supportDaoInstance;

    public static SupportDao getInstance () {
        if(supportDaoInstance==null) {
            supportDaoInstance = new SupportDao();
            return supportDaoInstance;
        }
        return supportDaoInstance;
    }

    @Override
    public boolean checkWhetherTicketNumberExists(int ticketNumber) throws SQLException {
        String sqlQuery = String.format("select * from Support where ticketNumber = %s;",ticketNumber);
		ResultSet resultSet = PlayupDBConnection.getInstance().readData(sqlQuery);
		if (resultSet.next()) {
            return true;
		}
		return false;
	}

    @Override
    public boolean generateSupportRequest(SupportModel supportModel) throws SQLException {
    String sqlQuery = String.format("INSERT INTO Support (ticketNumber, name, email, venue, description) VALUES (%s, '%s', '%s', '%s', '%s');",supportModel.getTicketNumber(),supportModel.getName(),supportModel.getEmail(),supportModel.getVenue(),supportModel.getDescription());
        return  PlayupDBConnection.getInstance().updateData(sqlQuery);
    }


}
