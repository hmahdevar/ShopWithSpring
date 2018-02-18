package com.hossein.kesens.service;

import com.hossein.kesens.model.access.Authorities;
import com.hossein.kesens.model.access.Users;

/**
 * Created by hossein on 4/24/17.
 */

public interface AccessService {

    public void addUser(Users user);
    public void updateUser(Users user);
    public void removeUser(Users user);
    public void addAuthority(Authorities authority);
    public void updateAuthority(Authorities authority);
    public void removeAuthority(Authorities authority);

    public Users getUserById(int userId);
    public Users getUserByEmail(String userEmail);
}
