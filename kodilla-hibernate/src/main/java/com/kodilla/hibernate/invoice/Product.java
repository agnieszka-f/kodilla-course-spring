package com.kodilla.hibernate.invoice;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity(name="_product_")
public class Product {
    private int id;
    private String name;
    private List<Item> items = new ArrayList<>();

    public Product(){}

    public Product(String name) {
        this.name = name;
    }
    @Id
    @NotNull
    @GeneratedValue
    @Column(name="product_id",unique = true)
    public int getId() {
        return id;
    }
    @OneToMany(
            targetEntity = Item.class,
            mappedBy = "product",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public void setId(int id) {
        this.id = id;
    }
    @Column(name = "product_name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
