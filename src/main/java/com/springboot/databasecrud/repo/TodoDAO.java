package com.springboot.databasecrud.repo;

import com.springboot.databasecrud.model.TodoModel;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface TodoDAO
        extends CrudRepository<TodoModel, Integer> {

    @Override
    List<TodoModel> findAll();
}
