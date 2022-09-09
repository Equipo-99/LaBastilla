package edu.udea.LaBastilla.model;

import javax.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "enterprise")
public class Enterprise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String name;
    @Column
    private String document;
    @Column
    private String phone;
    @Column
    private String adress;
    //@Column
    //private List<Employee> users;
    //@Column
    //private List<Transaction> transactions;
    @Column
    private Date createdAt = new Date();
    @Column
    private Date updatedAt = new Date();

    public Enterprise(String name, String document, String phone, String adress,
                      List<Employee> users) {
        this.name = name;
        this.document = document;
        this.phone = phone;
        this.adress = adress;
        //this.users = users;
    }

    public Enterprise() {
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    //public List<Employee> getUsers() {
    //    return users;
    //}

    //public void setUsers(List<Employee> users) {
    //    this.users = users;
    //}

    //public List<Transaction> getTransactions() {
    //    return transactions;
    //}

    //public void setTransactions(List<Transaction> transactions) {
    //    this.transactions = transactions;
    //}

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
