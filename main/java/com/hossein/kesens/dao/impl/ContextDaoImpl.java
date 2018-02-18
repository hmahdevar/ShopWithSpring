package com.hossein.kesens.dao.impl;

import com.hossein.kesens.dao.ContextDao;
import com.hossein.kesens.model.content.Context;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by hossein on 5/9/17.
 */
@Repository
@Transactional
public class ContextDaoImpl implements ContextDao {
    @Autowired
    SessionFactory sessionFactory;

    public Context getContextById(int contextId) {
        Session session = sessionFactory.getCurrentSession();
        Context context = (Context) session.load(Context.class, contextId);
        session.flush();
        return context;
    }

    public Context getContextByContext(String context){
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(Context.class);
        Context context1 = (Context) criteria.add(Restrictions.eq("context", context)).uniqueResult();
        session.flush();
        return context1;
    }

    public void addContext(Context context) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(context);
        session.flush();
    }

    public void updateContext(Context context) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(context);
        session.flush();
    }

    public void removeContext(Context context) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(context);
        session.flush();
    }
}
