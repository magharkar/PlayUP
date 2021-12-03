/**
 * @author Shiv Gaurang Desai
 */
package com.playup.dao.support;

import com.playup.constants.ApplicationConstants;
import com.playup.database.PlayupDBConnection;
import com.playup.model.support.SupportModel;
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
        String sqlQuery = String.format(ApplicationConstants.CHECK_SUPPORT_TICKET_NUMBER_QUERY,ticketNumber);
		ResultSet resultSet = PlayupDBConnection.getInstance().readData(sqlQuery);
		if (resultSet.next()) {
            return true;
		}
		return false;
	}

    @Override
    public boolean generateSupportRequest(SupportModel supportModel) throws SQLException {
        String sqlQuery = String.format(ApplicationConstants.INSERT_SUPPORT_REQUEST_QUERY,supportModel.getTicketNumber(),supportModel.getName(),supportModel.getEmail(),supportModel.getVenue(),supportModel.getDescription());
        return  PlayupDBConnection.getInstance().updateData(sqlQuery);
    }
}
