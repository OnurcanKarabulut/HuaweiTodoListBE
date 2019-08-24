package com.huaweiproject.Controller;

import com.huaweiproject.DTO.DeleteDTO;
import com.huaweiproject.DTO.ToDoDTO;
import com.huaweiproject.DTO.ToDoListDTO;
import com.huaweiproject.DTO.UpdateDTO;
import com.huaweiproject.Model.ToDoListModel;
import com.huaweiproject.Model.ToDoModel;
import com.huaweiproject.Response.TodoListResponse;
import com.huaweiproject.Service.IToDoListService;
import com.huaweiproject.Service.IToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/todo")

public class TodoController {
    @Autowired
    private IToDoService todoService;
    @Autowired
    private IToDoListService todoListService;

    @GetMapping(path="/findtodo")
    public List<ToDoModel> findToDo(){
        List<ToDoModel> list = todoService.findAll();

        return list;
    }
    @RequestMapping(value = "/findtodoItems/{listname}", method = RequestMethod.GET)
    public List<ToDoModel> findByUserId(@PathVariable(name = "listname") String username){
        List<ToDoModel> todoList = todoService.findByListName(username);
        return todoList;
    }

    @RequestMapping(value = "/addtodo" , method = RequestMethod.POST)
    public void saveToDo(@RequestBody ToDoDTO dto) {
        ToDoModel model = new ToDoModel();
        model.setUsername(dto.getUsername());
        model.setListName(dto.getListname());
        model.setDescription(dto.getDescription());
        model.setDate(dto.getDate());
        model.setTodo(dto.getTodo());
        model.setCreatedate(new Date());
        model.setIsChecked(dto.isChecked());
        todoService.save(model);
    }

    @RequestMapping(value = "/findtodolists/{username}", method = RequestMethod.GET)
    public List<ToDoListModel> findByUserName(@PathVariable(name = "username") String username){
        List<ToDoListModel> todolistModelList = todoListService.findByUserName(username);
        return todolistModelList;
    }
    @RequestMapping(value = "/createList" , method = RequestMethod.POST)
    public boolean saveToDoList(@RequestBody ToDoListDTO dto){
        List<ToDoListModel> todoList = todoListService.findByUserName(dto.getUsername());
        for(ToDoListModel todoListModel : todoList){
            if(todoListModel.getListName().equals(dto.getListname())){
                return true;
            }
        }
        ToDoListModel model = new ToDoListModel();
        model.setListName(dto.getListname());
        model.setUserName(dto.getUsername());
        todoListService.save(model);
        return false;
    }
    @RequestMapping(value = "/deleteList" , method = RequestMethod.DELETE)
    public void deleteToDoList(@RequestBody DeleteDTO dto){
        todoListService.deleteById(dto.getId());
    }
    @RequestMapping(value = "/deleteToDoItem" , method = RequestMethod.DELETE)
    public void deleteToDoItem(@RequestBody DeleteDTO dto){
        todoService.deleteById(dto.getId());
    }

    @RequestMapping(value = "/updateIsCompleted" , method = RequestMethod.POST)
    public void isCompleted(@RequestBody UpdateDTO dto){
       ToDoModel model=  todoService.find(dto.getId());
       model.setIsChecked(dto.isChecked());
       todoService.save(model);
    }
}
