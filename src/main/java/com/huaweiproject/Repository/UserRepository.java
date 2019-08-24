package com.huaweiproject.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.huaweiproject.Model.UserModel;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends CrudRepository<UserModel, Long> {
    @Query
    UserModel findByname(@Param(value = "name")String name);
}