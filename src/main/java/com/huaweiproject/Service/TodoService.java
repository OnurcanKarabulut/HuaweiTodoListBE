package com.huaweiproject.Service;

import com.huaweiproject.Model.ToDoModel;
import com.huaweiproject.Repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TodoService implements IToDoService {
    @Autowired
    private ToDoRepository repository;

    @Override
    public void save(ToDoModel model) {
        repository.save(model);
    }

    @Override
    public List<ToDoModel> findAll() {
        List<ToDoModel> list = (List<ToDoModel>) repository.findAll();
        return list;
    }

    @Override
    public List<ToDoModel> findByListName(String listname) {
        List<ToDoModel> list = (List<ToDoModel>) repository.findBylistName(listname);
        return list;
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public ToDoModel find(Long id) {
        List<ToDoModel> list = (List<ToDoModel>) repository.findAll();
        for(ToDoModel model : list){
            if(model.getId() == id){
                return model;
            }
        }
        return null;
    }
}
