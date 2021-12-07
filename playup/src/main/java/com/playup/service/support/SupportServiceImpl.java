/**
 * @author Shiv Gaurang Desai
 */
package com.playup.service.support;

import com.playup.constants.ApplicationConstants;
import com.playup.dao.support.SupportDaoImpl;
import com.playup.model.support.SupportModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SupportServiceImpl implements ISupportService {
    @Autowired
    private ISupportTicketGeneratorService supportTicketGeneratorService;

    @Override
    public boolean generateSupportRequest(SupportModel supportModel)  {
        boolean isSupportRequestCreated = false;
        try{
            supportModel.setTicketNumber(supportTicketGeneratorService.generateTicketNumber(ApplicationConstants.MINIMUM_SUPPORT_TICKET_NUMBER, ApplicationConstants.MAXIMUM_SUPPORT_TICKET_NUMBER));
            isSupportRequestCreated = SupportDaoImpl.getInstance().generateSupportRequest(supportModel);
        } catch (Exception e) {
            System.out.println(e);
        }
        return isSupportRequestCreated;
    }
}
