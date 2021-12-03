/**
 * @author Shiv Gaurang Desai
 */
package com.playup.service;

import com.playup.model.support.SupportModel;
import java.sql.SQLException;

public interface ISupport {
    boolean generateSupportRequest(SupportModel supportModel) throws SQLException;
}
