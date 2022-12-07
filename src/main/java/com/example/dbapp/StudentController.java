package com.example.dbapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
public class StudentController {

    @Autowired
    DBManager dbmanager;

    @PostMapping("/insert_me")
    public void insertstudent(@RequestBody() student s) throws SQLException {
        dbmanager.insertinfo(s);
        return;
    }

    @GetMapping("/get_all_std")
    public void getallstd() throws SQLException {
        dbmanager.getinfo();
    }
}
