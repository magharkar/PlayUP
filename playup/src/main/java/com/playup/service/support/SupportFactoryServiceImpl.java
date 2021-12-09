package com.playup.service.support;

import com.playup.model.support.SupportFactory;
import com.playup.model.support.SupportModel;
import org.springframework.stereotype.Service;

/**
 * @author Shiv Gaurang Desai
 */
@Service
public class SupportFactoryServiceImpl implements  ISupportFactoryService{
    @Override
    public SupportModel getSupportModel() {
        return SupportFactory.generateSupportModel();
    }
}
