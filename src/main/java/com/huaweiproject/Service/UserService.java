package com.huaweiproject.Service;

import com.huaweiproject.Model.UserModel;
import com.huaweiproject.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository repository;

    @Override
    public List<UserModel> findAll() {
        List<UserModel> userList = (List<UserModel>) repository.findAll();
        return userList;
    }

    @Override
    public void save(UserModel model) {
        repository.save(model);
    }

    @Override
    public boolean find(String name, String password) {
        List<UserModel> userList = (List<UserModel>) repository.findAll();
        for(UserModel user : userList) {
            if(user.getName().contentEquals(name) && user.getPassword().contentEquals(password)  ) {
                return true;
            }
        }
        return false;
    }



}

