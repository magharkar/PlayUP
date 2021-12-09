package com.playup.dao.support;

import com.playup.constants.QueryConstants;
import com.playup.database.PlayupDBConnection;
import com.playup.model.support.SupportModel;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Shiv Gaurang Desai
 */
public class SupportDaoImpl implements ISupportDao{
    private static SupportDaoImpl supportDaoImplInstance;

    private SupportDaoImpl(){}

    public static SupportDaoImpl getInstance () {
        if(supportDaoImplInstance ==null) {
            supportDaoImplInstance = new SupportDaoImpl();
            return supportDaoImplInstance;
        }
        return supportDaoImplInstance;
    }

    @Override
    public boolean checkWhetherTicketNumberExists(int ticketNumber) throws SQLException {
        String sqlQuery = String.format(QueryConstants.CHECK_SUPPORT_TICKET_NUMBER_QUERY,ticketNumber);
		ResultSet resultSet = PlayupDBConnection.getInstance().readData(sqlQuery);
		if (resultSet!=null&&resultSet.next()) {
            return true;
		}
		return false;
	}

    @Override
    public boolean generateSupportRequest(SupportModel supportModel) throws SQLException {
        String sqlQuery = String.format(QueryConstants.INSERT_SUPPORT_REQUEST_QUERY,supportModel.getTicketNumber(),supportModel.getName(),supportModel.getEmail(),supportModel.getVenue(),supportModel.getDescription());
        return  PlayupDBConnection.getInstance().updateData(sqlQuery);
    }
}
