package com.hossein.kesens.dao;

import com.hossein.kesens.model.content.Context;

/**
 * Created by hossein on 5/9/17.
 */
public interface ContextDao {

    public Context getContextById(int contextId);

    public Context getContextByContext(String context);

    public void addContext(Context context);

    public void updateContext(Context context);

    public void removeContext(Context context);
}
