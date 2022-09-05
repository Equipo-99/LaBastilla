package edu.udea.LaBastilla.model;

import org.springframework.lang.NonNull;
import java.util.ArrayList;
import java.util.Date;

public class Empresa {
    private long id;
    private String name;
    private String document;
    private String phone;
    private String adress;
    private ArrayList<Empleado> users;
    private ArrayList<MovimientoDinero> transactions;
    private Date createdAt;
    private Date updatedAt;

    public Empresa(@NonNull long id, String name,
                   String document,
                   String phone,
                   String adress,
                   ArrayList<Empleado> users,
                   ArrayList<MovimientoDinero> transactions,
                   Date createdAt,
                   Date updatedAt) {
        this.id = id;
        this.name = name;
        this.document = document;
        this.phone = phone;
        this.adress = adress;
        this.users = users;
        this.transactions = transactions;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
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

    public ArrayList<Empleado> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<Empleado> users) {
        this.users = users;
    }

    public ArrayList<MovimientoDinero> getTransactions() {
        return transactions;
    }

    public void setTransactions(ArrayList<MovimientoDinero> transactions) {
        this.transactions = transactions;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) { this.createdAt = createdAt; }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) { this.updatedAt = updatedAt; }
}
