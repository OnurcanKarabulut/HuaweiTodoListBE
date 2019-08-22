package com.huaweiproject.Repository;

import com.huaweiproject.Model.ToDoListModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ToDoListRepository  extends CrudRepository<ToDoListModel, Long> {
    List<ToDoListModel> findByuserName(@Param(value = "username")String username);

    @Override
    void deleteById(Long aLong);
}
