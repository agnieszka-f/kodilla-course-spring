package com.kodilla.hibernate;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.CompanyDao;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.EmployeeDao;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CompanyDaoTestSuite {
    @Autowired
    private CompanyDao companyDao;
    @Autowired
    private EmployeeDao employeeDao;

    @Test
    public void test1(){
        //Given
        Employee adamKowalski = new Employee("Adam","Kowalski");
        Company softSystem = new Company("SoftSystem");
        adamKowalski.getCompanies().add(softSystem);
        softSystem.getEmployees().add(adamKowalski);
        companyDao.save(softSystem);
        //When
        List<Employee> result1 = employeeDao.searchByLastname("Kowalski");
        //Then
        Assert.assertEquals(1, result1.size());
        //Clean
        employeeDao.delete(adamKowalski);

    }
    @Test
    public void test2(){
        //Given
        Employee magdaNowacka = new Employee("Magda","Nowacka");
        Company softSystem = new Company("SoftSystem");
        Company softStrong = new Company("SoftStrong");
        magdaNowacka.getCompanies().add(softSystem);
        magdaNowacka.getCompanies().add(softStrong);
        softStrong.getEmployees().add(magdaNowacka);
        softSystem.getEmployees().add(magdaNowacka);

        employeeDao.save(magdaNowacka);
        //When
        List<Company> result = companyDao.searchByThreeCharacters("Sof");
        //Then
        Assert.assertEquals(2,result.size());
        //Clean
        employeeDao.delete(magdaNowacka);

    }
}
