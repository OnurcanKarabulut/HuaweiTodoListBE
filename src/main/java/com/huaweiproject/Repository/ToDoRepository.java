package com.huaweiproject.Repository;

import java.util.List;

import com.huaweiproject.Model.ToDoModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface ToDoRepository extends CrudRepository<ToDoModel, Long> {
    @Query
    List<ToDoModel> findBylistNameOrderByCreatedateDesc(@Param(value = "listname")String listname);

    @Override
    void deleteById(Long aLong);




}
