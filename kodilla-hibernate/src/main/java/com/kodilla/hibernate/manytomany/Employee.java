package com.kodilla.hibernate.manytomany;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@NamedQueries(
        {
                @NamedQuery(
                        name = "Employee.searchByLastname",
                        query = "FROM Employee WHERE lastname = :LASTNAME"
                )
        }
)

@Entity
@Table(name="EMPLOYEES_")
public class Employee {
    private int id;
    private String firstname;
    private String lastname;
    private List<Company> companies = new ArrayList<>();

    public Employee(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }
    public Employee(){}
    @Id
    @NotNull
    @GeneratedValue
    @Column(name = "EMPLOYEE_ID", unique = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ManyToMany (cascade = CascadeType.ALL)
    @JoinTable(
            name = "JOIN_COMPANY_EMPLOYEE_",
            joinColumns = {
                    @JoinColumn(name = "EMPLOYEE_ID", referencedColumnName = "EMPLOYEE_ID")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "COMPANY_ID", referencedColumnName = "COMPANY_ID")
            }
    )
    public List<Company> getCompanies() {
        return companies;
    }

    public void setCompanies(List<Company> companies) {
        this.companies = companies;
    }

    @Column(name = "FIRSTNAME")
    @NotNull
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    @Column(name = "LASTNAME")
    @NotNull
    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
