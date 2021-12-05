/**
 * @author Shiv Gaurang Desai
 */
package com.playup.service.support;

import com.playup.model.support.SupportModel;
import java.sql.SQLException;

public interface ISupportService {
    boolean generateSupportRequest(SupportModel supportModel) throws SQLException;
}
