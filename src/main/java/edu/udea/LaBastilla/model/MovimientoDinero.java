package edu.udea.LaBastilla.model;

import java.util.Date;

public class MovimientoDinero {
    private long id;
    private String concepto;
    private float monto;
    private Empresa empresa;
    private Empleado empleado;
    private Date createdAt;
    private Date updatedAt;


    public MovimientoDinero(long id, String concepto, float monto, Empresa empresa,Empleado empleado, Date createdAt, Date updatedAt) {
        this.id = id;
        this.concepto = concepto;
        this.monto = monto;
        this.empresa = empresa;
        this.empleado = empleado;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
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
