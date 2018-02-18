package com.hossein.kesens.service.impl;

import com.hossein.kesens.dao.AccessDao;
import com.hossein.kesens.model.access.Authorities;
import com.hossein.kesens.model.access.Users;
import com.hossein.kesens.service.AccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by hossein on 4/24/17.
 */
@Service
public class AccessServiceImpl implements AccessService{
    @Autowired
    private AccessDao accessDao;
    public void addUser(Users user) {
        accessDao.addUser(user);
    }

    public void updateUser(Users user) {
        accessDao.updateUser(user);

    }

    public void removeUser(Users user) {
        accessDao.removeUser(user);

    }

    public void addAuthority(Authorities authority) {
        accessDao.addAuthority(authority);
    }

    public void updateAuthority(Authorities authority) {
        accessDao.updateAuthority(authority);
    }

    public void removeAuthority(Authorities authority) {
        accessDao.removeAuthority(authority);
    }

    public Users getUserById(int userId) {
        return accessDao.getUserById(userId);
    }

    public Users getUserByEmail(String userEmail) {
        return accessDao.getUserByEmail(userEmail);
    }
}
