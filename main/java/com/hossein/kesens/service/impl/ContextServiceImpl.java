package com.hossein.kesens.service.impl;

import com.hossein.kesens.dao.ContextDao;
import com.hossein.kesens.model.content.Context;
import com.hossein.kesens.service.ContextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by hossein on 5/9/17.
 */
@Service
public class ContextServiceImpl implements ContextService {
    @Autowired
    private ContextDao contextDao;

    public String get(String context) {

        Context context1 = getContextByContext(context);
        return context1.getText();
    }

    public Context getContextById(int contextId) {
        return contextDao.getContextById(contextId);
    }

    public Context getContextByContext(String context) {
        Context context1 = contextDao.getContextByContext(context);
        if (context1 == null) {
            context1 = new Context();
            context1.setContext(context);
            context1.setText(context);
            contextDao.addContext(context1);
        }

        return context1;
    }

    public void addContext(Context context) {
        contextDao.addContext(context);
    }

    public void updateContext(Context context) {
        contextDao.updateContext(context);
    }

    public void removeContext(Context context) {
        contextDao.removeContext(context);
    }
}
