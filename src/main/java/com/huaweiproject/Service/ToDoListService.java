package com.huaweiproject.Service;

import com.huaweiproject.Model.ToDoListModel;
import com.huaweiproject.Model.ToDoModel;
import com.huaweiproject.Repository.ToDoListRepository;
import com.huaweiproject.Repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ToDoListService implements IToDoListService {
    @Autowired
    private ToDoListRepository repository;

      @Override
    public void save(ToDoListModel model) {
        repository.save(model);
    }

    @Override
    public List<ToDoListModel> findByUserName(String username) {
        List<ToDoListModel> list = (List<ToDoListModel>) repository.findByuserName(username);
        return list;
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
