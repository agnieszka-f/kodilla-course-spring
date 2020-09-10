package com.kodilla.hibernate.aaa;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Tests {
    @Autowired
    private EmpDao empDao;
    @Autowired
    private PhoDao phoDao;
    @Test
    public void test(){
        Emp emp1 = new Emp();
        emp1.setLastname("Ada");

        Pho pho1 = new Pho();
        pho1.setNumber("232974235");
        pho1.setOwner(emp1);

        //empDao.save(emp1);
        phoDao.save(pho1);


        //phoDao.deleteAll();
        //empDao.deleteAll();

    }
    @Test
    public void test2(){
        Emp emp2 = new Emp();
        emp2.setLastname("Beata");
        Pho pho01 = new Pho();
        Pho pho02 = new Pho();
        pho01.setNumber("645375543");
        pho02.setNumber("765453756");

        pho01.setOwner(emp2);
        pho02.setOwner(emp2);

        empDao.save(emp2);
        //phoDao.save(pho01);
        //phoDao.save(pho02);



        //phoDao.save(pho01);
        //phoDao.save(pho02);
    }
    @Test
    public void test3(){

            Emp emp1 = new Emp();
            emp1.setLastname("Ad");

            Pho pho1 = new Pho();
            pho1.setNumber("232974235");
            pho1.setOwner(emp1);

            //empDao.save(emp1);
            phoDao.save(pho1);
            int id = emp1.getId();
            Optional<Emp> temp = empDao.findById(id);

            if(temp.isPresent()){
                Emp tempEmp = temp.get();
                System.out.println(tempEmp.getLastname());
            }

    }
}
