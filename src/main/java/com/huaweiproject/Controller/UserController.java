package com.huaweiproject.Controller;

import java.util.List;

import com.huaweiproject.DTO.LoginDTO;
import com.huaweiproject.DTO.UserDTO;
import com.huaweiproject.Model.UserModel;
import com.huaweiproject.Service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;


    @GetMapping(path="/findusers")
    public List<UserModel> findUsers(){
        List<UserModel> list = userService.findAll();

        return list;
    }
    @RequestMapping(value = "/login" , method = RequestMethod.POST)
    public boolean findUser(@RequestBody LoginDTO dto) {
        boolean isUserExist = userService.find(dto.getUserId(), dto.getPassword());
        return isUserExist;
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public void signUp(@RequestBody UserDTO dto) {
        UserModel user = new UserModel();
        user.setName(dto.getFirst_name());
        user.setPassword(dto.getPassword());
        user.setSurname(dto.getLast_name());
        userService.save(user);

    }

}

