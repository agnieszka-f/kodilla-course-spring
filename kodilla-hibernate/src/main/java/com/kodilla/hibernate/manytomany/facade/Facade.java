package com.kodilla.hibernate.manytomany.facade;


import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.CompanyDao;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.EmployeeDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Facade {
    @Autowired
    private CompanyDao companyDao;
    @Autowired
    private EmployeeDao employeeDao;

    private static final Logger LOGGER = LoggerFactory.getLogger(Facade.class);

    public List<Company> getCompanyByFragmentName(String fragment){
        List<Company> lists = companyDao.searchByFragmentCompanyName(fragment);

        if(!lists.isEmpty()) {
            LOGGER.info("Lista znalezionych firm na podstawie fragmentu nazwy: " + fragment);
            for (Company c : lists) {
                System.out.println(c.getName());
            }
        }  else LOGGER.info("Nie znaleziono firm na zawierających w nazwie: " + fragment);

        return lists;
    }
    public List<Employee> getEmployByFragmentLastame(String fragment){
        List<Employee> lists = employeeDao.searchByFragmentLastname(fragment);

        if(!lists.isEmpty()) {
            LOGGER.info("Lista znalezionych pracowników na podstawie fragmentu nazwiska: " + fragment);
            for (Employee e : lists) {
                System.out.println(e.getFirstname() + " " + e.getLastname());
            }
        } else LOGGER.info("Nie znaleziono pracowników na podstawie fragmentu nazwiska: " + fragment);
        return lists;
    }
}
