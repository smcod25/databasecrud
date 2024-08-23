package com.springboot.databasecrud.services;

import com.springboot.databasecrud.model.TodoModel;
import com.springboot.databasecrud.repo.TodoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TodoServices {
    //Add todo
    //get todo
    //delete todo
    //update todo
    @Autowired
    private TodoDAO dao;

    public TodoModel addtodo(TodoModel todoModel)
    {
        return dao.save(todoModel);
    }

    public List<TodoModel> getTodo()
    {
        return dao.findAll();
    }

    public void deleteTodo(int todoId){
        dao.deleteById(todoId);
    }
    public TodoModel updateTodo(int todoId, TodoModel todoModel)
    {
        todoModel.setTaskId(todoId);
        return dao.save(todoModel);
    }
}
