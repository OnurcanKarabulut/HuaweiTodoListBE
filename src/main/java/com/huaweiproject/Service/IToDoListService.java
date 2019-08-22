package com.huaweiproject.Service;

import com.huaweiproject.Model.ToDoListModel;

import java.util.List;

public interface IToDoListService {

    void save(ToDoListModel model);
    List<ToDoListModel> findByUserName(String username);
    List<ToDoListModel> findAll();
    void deleteById(Long id);
}
