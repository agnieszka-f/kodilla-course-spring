/*package com.kodilla.hibernate;

import com.kodilla.hibernate.task.Task;
import com.kodilla.hibernate.task.TaskDao;
import com.kodilla.hibernate.task.TaskFinancialDetails;
import com.kodilla.hibernate.task.TaskFinancialDetailsDao;
import com.kodilla.hibernate.tasklist.TaskList;
import com.kodilla.hibernate.tasklist.TaskListDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestTask {
    @Autowired
    private TaskDao taskDao;
    @Autowired
    private TaskListDao taskListDao;
    @Autowired
    private TaskFinancialDetailsDao taskFinancialDetailsDao;

    @Test
    public void test1(){
        Task task = new Task("opis",2);
        taskDao.save(task);
        List<Task> result = taskDao.findByDuration(task.getDuration());
        result.stream().forEach(x->System.out.println(x.getId()+"-------"+x.getCreated()));
        System.out.println("Liczba wszystkich zadań: "+taskDao.count());
        System.out.println("Czy zadanie o id=4 istnieje: "+taskDao.existsById(4));
    }
    @Test
    public void test2(){
        TaskList taskList = new TaskList("Lista nr 1", "Opis....");
        taskListDao.save(taskList);
        Optional<TaskList> result = taskListDao.findById(taskList.getId());
        System.out.println(result.isPresent());
    }
    @Test
    public void test3(){
        TaskFinancialDetails taskFinancialDetails = new TaskFinancialDetails(new BigDecimal(200),false);
        Task task = new Task("opłacić...",2);
        task.setTaskFinancialDetails(taskFinancialDetails);
        taskDao.save(task);

        List<TaskFinancialDetails> result = taskFinancialDetailsDao.findAll();
        result.stream().forEach(x -> System.out.println(x.getId()));
    }
    @Test
    public void test4(){
        Task task1 = new Task("opis 00",3);
        Task task2 = new Task("opis 11",0);

        TaskList taskList = new TaskList("Nowa lista zadań", "opis listy");
        taskList.getTaskList().add(task1);
        taskList.getTaskList().add(task2);

        taskListDao.save(taskList);
        List<Task> result = taskDao.findByDuration(0);
        System.out.println(result.size());
    }
    @Test
    public void test6(){
        Task task1 = new Task("opis 00",3);
        Task task2 = new Task("opis 11",0);

        TaskList taskList = new TaskList("Nowa lista zadań", "opis listy");
        taskListDao.save(taskList);
        task1.setTaskList(taskList);
        task2.setTaskList(taskList);

        taskDao.save(task1);
        taskDao.save(task2);
    }
    @Test
    public void test7(){
        Task task1 = new Task("opis 00",3);
        Task task2 = new Task("opis 11",0);

        TaskList taskList = new TaskList("Nowa lista zadań", "opis listy");

        taskList.getTaskList().add(task1);
        taskList.getTaskList().add(task2);

        taskListDao.save(taskList);
    }
    @Test
    public void test5(){
        taskDao.deleteAll();
        taskListDao.deleteAll();
        taskFinancialDetailsDao.deleteAll();
    }
}*/
