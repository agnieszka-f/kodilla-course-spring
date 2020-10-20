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
                ),
                @NamedQuery(
                       name = "Employee.searchByFragmentLastname",
                        query = "FROM Employee WHERE lastname like CONCAT('%', :FRG, '%')"
                )
        }
)

@Entity
@Table(name="employees_")
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
    @Column(name = "employee_id", unique = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ManyToMany (cascade = CascadeType.ALL)
    @JoinTable(
            name = "join_company_employee_",
            joinColumns = {
                    @JoinColumn(name = "employee_id", referencedColumnName = "employee_id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "company_id", referencedColumnName = "company_id")
            }
    )
    public List<Company> getCompanies() {
        return companies;
    }

    public void setCompanies(List<Company> companies) {
        this.companies = companies;
    }

    @Column(name = "firstname")
    @NotNull
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    @Column(name = "lastname")
    @NotNull
    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
