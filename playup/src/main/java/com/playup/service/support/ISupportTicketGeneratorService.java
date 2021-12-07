/**
 * @author Shiv Gaurang Desai
 */
package com.playup.service.support;

import java.sql.SQLException;

public interface ISupportTicketGeneratorService {
    int generateTicketNumber(int minimumTicketNumber, int maximumTicketNumber) throws SQLException;
}
