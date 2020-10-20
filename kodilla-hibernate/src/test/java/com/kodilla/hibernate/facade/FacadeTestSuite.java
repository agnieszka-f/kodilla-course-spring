package com.kodilla.hibernate.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.CompanyDao;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.EmployeeDao;
import com.kodilla.hibernate.manytomany.facade.Facade;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FacadeTestSuite {
    @Autowired
    private CompanyDao companyDao;
    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private Facade facade;

    @Test
    public void test1(){
        //Given
        Company company1 = new Company("Budimex Soft");
        companyDao.save(company1);
        Company company2 = new Company("Macrologic");
        companyDao.save(company2);
        Company company3 = new Company("Ivona Software");
        companyDao.save(company3);
        //When
        List<Company> result = facade.getCompanyByFragmentName("oft");
        //Then
        Assert.assertEquals(2,result.size());
        //Clean
        companyDao.deleteAll();
    }
    @Test
    public void test2(){
        //Given
        Employee employee1 = new Employee("Anna","Kotowska");
        employeeDao.save(employee1);
        Employee employee2 = new Employee("Ewelina", "Mirowska");
        employeeDao.save(employee2);
        Employee employee3 = new Employee("Jonna", "Gąska");
        employeeDao.save(employee3);
        //When
        List<Employee> result = facade.getEmployByFragmentLastame("owska");
        //Then
        Assert.assertEquals(2,result.size());
        //Clean
        employeeDao.deleteAll();
    }
}
