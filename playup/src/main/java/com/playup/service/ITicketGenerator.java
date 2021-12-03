/**
 * @author Shiv Gaurang Desai
 */
package com.playup.service;

import java.sql.SQLException;

public interface ITicketGenerator {
    int generateTicketNumber(int minimumTicketNumber, int maximumTicketNumber) throws SQLException;
}
