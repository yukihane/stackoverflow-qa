package com.example.en62724909;

import java.util.Date;
import javax.validation.Valid;
import org.springframework.stereotype.Service;

@Service
public class ToDoService {

    public String retrieveTodos(final String user) {
        return "retrieveTodos " + user;
    }

    public String retrieveTodo(final int id) {
        return "retrieveTodo " + id;
    }

    public void updateToDo(@Valid final ToDo todo) {
        // TODO Auto-generated method stub

    }

    public void addTodo(final String user, final String description, final Date targetDate, final boolean b) {
        // TODO Auto-generated method stub

    }

    public void deleteTodo(final int id) {
        // TODO Auto-generated method stub

    }

}
