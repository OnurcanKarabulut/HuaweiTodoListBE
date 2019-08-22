package com.huaweiproject.Repository;

import org.springframework.data.repository.CrudRepository;
import com.huaweiproject.Model.UserModel;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends CrudRepository<UserModel, Long> {

}