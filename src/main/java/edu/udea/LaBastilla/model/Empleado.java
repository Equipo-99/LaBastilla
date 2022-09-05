package edu.udea.LaBastilla.model;

import edu.udea.LaBastilla.enums.Enum_RoleName;

import java.util.*;

public class Empleado {
    private long id;
    private String name;
    private String email;
    private Empresa enterprise;
    private Enum_RoleName role;
    private ArrayList<MovimientoDinero> transactions;
    private Date createdAt;
    private Date updatedAt;

    public Empleado(String name, String email, Empresa enterprise, Enum_RoleName role) {
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

    public Enum_RoleName getRole() {
        return role;
    }

    public void setRole(Enum_RoleName role) {
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
