package com.playup.service.support;

import java.sql.SQLException;

/**
 * @author Shiv Gaurang Desai
 */

public interface ISupportTicketGeneratorService {
    int generateTicketNumber(int minimumTicketNumber, int maximumTicketNumber) throws SQLException;
}
