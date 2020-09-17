package com.kodilla.hibernate.invoice;
//
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "_invoice_")
public class Invoice {
    private int id;
    private String number;
    private List<Item> listItem = new ArrayList<>();

    public Invoice(){}

    public Invoice(String number) {
        this.number = number;
    }
    @Id
    @NotNull
    @GeneratedValue
    @Column(name="invoice_id",unique = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @Column(name="invoice_number")
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
    @OneToMany(
            targetEntity = Item.class,
            mappedBy = "invoice",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    public List<Item> getListItem() {
        return listItem;
    }

    public void setListItem(List<Item> listItem) {
        this.listItem = listItem;
    }
}
