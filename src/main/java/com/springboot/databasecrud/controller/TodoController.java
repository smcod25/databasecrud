package com.springboot.databasecrud.controller;

import com.springboot.databasecrud.model.TodoModel;
import com.springboot.databasecrud.services.TodoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Scanner;

@RestController
public class TodoController {

    //create first print name api
    @GetMapping(value = "/add")
    public String addno(){

        JFrame frame=new JFrame("Add");
        JLabel alabel=new JLabel("Enter A:");
        JTextField atext=new JTextField();
        alabel.setBounds(10,80,100,30);
        atext.setBounds(80,80,100,30);

        JLabel blabel=new JLabel("Enter B:");
        JTextField btext=new JTextField();
        blabel.setBounds(10,120,100,30);
        btext.setBounds(80,120,100,30);

        JButton addb=new JButton("Add");
        addb.setBounds(50,150,100,30);

        JLabel re=new JLabel();
        re.setBounds(10,185,100,30);

        frame.add(alabel);
        frame.add(atext);
        frame.add(blabel);
        frame.add(btext);
        frame.add(addb);
        frame.add(re);

        addb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(atext.getText().isEmpty()&& btext.getText().isEmpty())
                {
                    JOptionPane.showMessageDialog(null,"Invalid Input");
                }
                else {
                    int a =Integer.parseInt(atext.getText());
                    int b=Integer.parseInt(btext.getText());
                    int result=a+b;

                     re.setText(String.valueOf(result));
                    JOptionPane.showMessageDialog(null,re.getText());

                }
            }
        });

        frame.setLayout(null);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setSize(500,400);


        return re.getText();
    }

    @Autowired
    private TodoServices todoServices;
    @PostMapping()
    public TodoModel addTodo(@RequestBody TodoModel todoModel)
    {
        return todoServices.addtodo(todoModel);
    }
    @GetMapping()
    public List<TodoModel> getTodos()
    {
        return todoServices.getTodo();
    }

    @DeleteMapping(value = "/{todoId}")
    public void deleteTickets(@PathVariable("todoId") int todoId)
    {
        todoServices.deleteTodo(todoId);
    }

    @PutMapping(value = "/{todoId}")
    public TodoModel updateTodo(@PathVariable("todoId") int todoId,
                                @RequestBody TodoModel model){
        return todoServices.updateTodo(todoId,model);
    }


}
