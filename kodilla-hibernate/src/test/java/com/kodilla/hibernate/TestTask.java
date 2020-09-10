package com.kodilla.hibernate;

import com.kodilla.hibernate.task.Task;
import com.kodilla.hibernate.task.TaskDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestTask {
    @Autowired
    private TaskDao taskDao;

    @Test
    public void test1(){
        Task task = new Task("opis",2);
        taskDao.save(task);
        List<Task> result = taskDao.findByDuration(task.getDuration());
        result.stream().forEach(x->System.out.println("-------"+x.getCreated()));
    }
}
