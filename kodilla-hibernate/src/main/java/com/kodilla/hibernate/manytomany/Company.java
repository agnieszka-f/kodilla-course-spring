package com.kodilla.hibernate.manytomany;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@NamedNativeQueries(
        {
                @NamedNativeQuery(
                        name = "Company.searchByThreeCharacters",
                        query = "SELECT * FROM COMPANIES_ where COMPANY_NAME LIKE CONCAT(:THREE, '%')",
                        resultClass = Company.class
                )
        }
)
@Entity
@Table(name = "COMPANIES_")
public class Company {

    private int id;
    private String name;
    protected List<Employee> employees = new ArrayList<>();

    public Company(){

    }

    public Company(String name) {
        this.name = name;
    }
    @Id
    @NotNull
    @GeneratedValue
    @Column(name = "COMPANY_ID", unique = true)
    public int getId() {
        return id;
    }
    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "companies")
    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NotNull
    @Column(name = "COMPANY_NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
