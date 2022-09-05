package edu.udea.LaBastilla.model;

import java.util.Date;

public class transaction {
    private long id;
    private String concept;
    private float amount;
    private Enterprise enterprise;
    private Employee employee;
    private Date createdAt;
    private Date updatedAt;


    public transaction(long id, String concept, float amount, Enterprise enterprise, Employee employee, Date createdAt, Date updatedAt) {
        this.id = id;
        this.concept = concept;
        this.amount = amount;
        this.enterprise = enterprise;
        this.employee = employee;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Employee getEmpleado() {
        return employee;
    }

    public void setEmpleado(Employee employee) {
        this.employee = employee;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getConcept() {
        return concept;
    }

    public void setConcept(String concept) {
        this.concept = concept;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public Enterprise getEmpresa() {
        return enterprise;
    }

    public void setEmpresa(Enterprise enterprise) {
        this.enterprise = enterprise;
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
