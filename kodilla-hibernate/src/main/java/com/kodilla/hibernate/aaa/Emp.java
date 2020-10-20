package com.kodilla.hibernate.aaa;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Emp {
    private int id;
    private String lastname;
    private Set<Pho> setPhons = new HashSet<>();

    public Emp(){}

    @Id
    @NotNull
    @GeneratedValue
    @Column(unique = true)
    public int getId() {
        return id;
    }
    @OneToMany(mappedBy = "owner")
    public Set<Pho> getSetPhons() {
       return setPhons;
    }

    public void setSetPhons(Set<Pho> setPhons) {
        this.setPhons = setPhons;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }


}
