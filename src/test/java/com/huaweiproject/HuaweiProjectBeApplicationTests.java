package com.huaweiproject;

import static org.hamcrest.Matchers.is;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;

import static org.mockito.Mockito.when;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;



import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import java.util.ArrayList;

import java.util.Date;
import java.util.List;

import com.huaweiproject.Controller.TodoController;
import com.huaweiproject.Model.ToDoListModel;
import com.huaweiproject.Model.ToDoModel;
import com.huaweiproject.Model.UserModel;
import com.huaweiproject.Repository.ToDoListRepository;
import com.huaweiproject.Repository.UserRepository;
import com.huaweiproject.Service.ToDoListService;
import com.huaweiproject.Service.TodoService;
import com.huaweiproject.Service.UserService;
import org.junit.Before;

import org.junit.Test;

import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.http.MediaType;

import org.springframework.test.context.junit4.SpringRunner;

import org.springframework.test.web.servlet.MockMvc;



import org.springframework.web.context.WebApplicationContext;
@RunWith(SpringRunner.class)
@SpringBootTest
public class HuaweiProjectBeApplicationTests {

	@Autowired
	private UserService service;

	@Autowired
	private ToDoListService toDoListService;

	@MockBean
	private UserRepository repository;

	@MockBean
	private ToDoListRepository todoListRepository;

	MockMvc mockMvc;

	@Autowired
	protected WebApplicationContext wac;

	@Autowired
	TodoController todoController;

	@MockBean
	TodoService todoService;

	private  List<ToDoModel> list;

	@Test
	public void getSaveUserTest(){
	UserModel user = new UserModel();
	user.setName("onur");
	user.setSurname("kara");
	user.setPassword("1234");
	when(repository.save(user)).thenReturn(user);
	assertEquals(user,service.save(user));
	}

	@Test
	public void getFindUserLists(){
		ToDoListModel todoList = new ToDoListModel();
		todoList.setUserName("onur");
		todoList.setListName("1.liste");
		List<ToDoListModel> list = new ArrayList<ToDoListModel>();
		list.add(todoList);
		when(todoListRepository.findByuserName("onur")).thenReturn(list);
		assertEquals(list,toDoListService.findByUserName("onur"));
	}

	@Before
	public void setup() throws Exception {

		this.mockMvc = standaloneSetup(this.todoController).build();
		ToDoModel todo1 = new ToDoModel();
		todo1.setListName("1.liste");
		todo1.setIsChecked(true);
		todo1.setDescription("12");
		todo1.setDate(new Date(20190824));
		todo1.setUsername("onur");
		todo1.setCreatedate(new Date(20190824));
		todo1.setTodo("1.liste 1.eleman");

		list= new ArrayList<ToDoModel>();
		list.add(todo1);
	}

	@Test
	public void testGetTodoItems() throws Exception {

		when(todoService.findByListName(any(String.class))).thenReturn(list);

		mockMvc.perform(get("/todo/findtodoItems/1.liste").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(jsonPath("[0]todo",is("1.liste 1.eleman")));

	}
}
