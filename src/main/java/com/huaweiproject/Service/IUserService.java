package com.huaweiproject.Service;

import com.huaweiproject.Model.UserModel;

import java.util.List;



public interface IUserService {

    List<UserModel> findAll();
    void save(UserModel model);
    boolean find(String name, String password);
}
