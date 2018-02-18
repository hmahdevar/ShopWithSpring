package com.hossein.kesens.dao;
import com.hossein.kesens.model.access.*;
/**
 * Created by hossein on 4/16/17.
 */
public interface AccessDao {

    public void addUser(Users user);
    public void updateUser(Users user);
    public void removeUser(Users user);
    public void addAuthority(Authorities authority);
    public void updateAuthority(Authorities authority);
    public void removeAuthority(Authorities authority);

    public Users getUserById(int userId);
    public Users getUserByEmail(String userEmail);
}
