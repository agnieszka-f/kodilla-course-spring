package com.kodilla.hibernate.aaa;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Pho {
    private long id;
    private String number;
    private Emp owner;

    public Pho(){}

    @Id
    @NotNull
    @GeneratedValue
    @Column(unique = true)
    public long getId() {
        return id;
    }
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "OWNER_TEL_ID")
    public Emp getOwner() {
        return owner;
    }

    public void setOwner(Emp owner) {
        this.owner = owner;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
