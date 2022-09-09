package edu.udea.LaBastilla.model;

import edu.udea.LaBastilla.enums.Enum_RoleName;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String name;
    @Column
    private String email;
    @Column
    private Enterprise enterprise;
    @Column
    private Enum_RoleName role;
    @Column
    private List<Transaction> transactions;
    @Column
    private Date createdAt;
    @Column
    private Date updatedAt;

    public Employee(String name, String email,
                    Enterprise enterprise, Enum_RoleName role) {
        this.name = name;
        this.email = email;
        this.enterprise = enterprise;
        this.role = role;
    }

    public Employee() {
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

    public Enterprise getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(Enterprise enterprise) {
        this.enterprise = enterprise;
    }

    public Enum_RoleName getRole() {
        return role;
    }

    public void setRole(Enum_RoleName role) {
        this.role = role;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
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
