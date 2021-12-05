/**
 * @author Shiv Gaurang Desai
 */
package com.playup.dao.support;

import com.playup.model.support.SupportModel;
import java.sql.SQLException;

public interface ISupportDao {
    boolean checkWhetherTicketNumberExists(int ticketNumber) throws SQLException;
    boolean generateSupportRequest(SupportModel supportModel) throws SQLException;
}
