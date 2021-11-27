package com.playup.service;
import com.playup.dao.SupportDao;
import com.playup.model.SupportModel;
import org.springframework.stereotype.Service;

import java.lang.*;

@Service
public class SupportService implements  ISupport{

    @Override
    public boolean generateSupportRequest(SupportModel supportModel)  {
        boolean isSupportRequestCreated = false;
        try{
            isSupportRequestCreated = SupportDao.getInstance().generateSupportRequest(supportModel);
        } catch (Exception e) {
            System.out.println(e);
        }
        return isSupportRequestCreated;
    }

}
