/**
 * @author Shiv Gaurang Desai
 */
package com.playup.dao;

import com.playup.model.SupportModel;
import java.sql.SQLException;

public interface ISupportDao {

    public boolean checkWhetherTicketNumberExists(int ticketNumber) throws SQLException;

    public boolean generateSupportRequest(SupportModel supportModel) throws SQLException;

}
