package edu.udea.LaBastilla.model;

import java.util.*;

public class Empleado {
    private long id;
    private String name;
    private String email;
    private Empresa enterprise;
    private Rol role;
    private ArrayList<MovimientoDinero> transactions;
    private Date createdAt;
    private Date updatedAt;

    public Empleado(String name, String email, Empresa enterprise, Rol role) {
        this.name = name;
        this.email = email;
        this.enterprise = enterprise;
        this.role = role;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Empresa getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(Empresa enterprise) {
        this.enterprise = enterprise;
    }

    public Rol getRole() {
        return role;
    }

    public void setRole(Rol role) {
        this.role = role;
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
