package com.huaweiproject.Service;

import com.huaweiproject.Model.UserModel;

import java.util.List;



public interface IUserService {

    List<UserModel> findAll();
    UserModel save(UserModel model);
    boolean find(String name, String password);
    UserModel findByName(String name);
}
