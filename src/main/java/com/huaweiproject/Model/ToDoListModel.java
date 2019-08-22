package com.huaweiproject.Model;

import javax.persistence.*;

@Entity
@Table(name = "todolist")
public class ToDoListModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id ;
    private String ListName;
    private String userName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getListName() {
        return ListName;
    }

    public void setListName(String listName) {
        ListName = listName;
    }
}
