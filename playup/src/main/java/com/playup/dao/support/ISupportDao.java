package com.playup.dao.support;

import com.playup.model.support.SupportModel;
import java.sql.SQLException;

/**
 * @author Shiv Gaurang Desai
 */

public interface ISupportDao {
    boolean checkWhetherTicketNumberExists(int ticketNumber) throws SQLException;
    boolean generateSupportRequest(SupportModel supportModel) throws SQLException;
}
