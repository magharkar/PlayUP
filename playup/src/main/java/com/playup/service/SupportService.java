/**
 * @author Shiv Gaurang Desai
 */
package com.playup.service;

import com.playup.dao.support.ISupportDao;
import com.playup.dao.support.SupportDao;
import com.playup.model.support.SupportModel;
import org.springframework.stereotype.Service;
import java.lang.*;

@Service
public class SupportService implements  ISupport{

    private SupportDao supportDao;

    @Override
    public boolean generateSupportRequest(SupportModel supportModel)  {

        boolean isSupportRequestCreated = false;
        try{
            isSupportRequestCreated = supportDao.getInstance().generateSupportRequest(supportModel);
        } catch (Exception e) {
            System.out.println(e);
        }
        return isSupportRequestCreated;

    }

}
