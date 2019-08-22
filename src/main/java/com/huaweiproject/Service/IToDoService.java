package com.huaweiproject.Service;

import com.huaweiproject.Model.ToDoModel;

import java.util.List;



public interface IToDoService {
    void save(ToDoModel model);
    List<ToDoModel> findAll();
    List<ToDoModel> findByListName(String listname);
    void deleteById(Long id);
}

