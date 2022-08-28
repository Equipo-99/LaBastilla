package edu.udea.LaBastilla.model;

import java.util.Date;

public class MovimientoDinero {
    private long Id;
    private String Concepto;
    private float Monto;
    private Empleado Empleado;
    private Empresa Empresa;
    private Date CreatedAt;
    private Date UpdatedAt;

    public MovimientoDinero(long id, String concepto, float monto, edu.udea.LaBastilla.model.Empleado empleado, edu.udea.LaBastilla.model.Empresa empresa, Date createdAt, Date updatedAt) {
        Id = id;
        Concepto = concepto;
        Monto = monto;
        Empleado = empleado;
        Empresa = empresa;
        CreatedAt = createdAt;
        UpdatedAt = updatedAt;
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getConcepto() {
        return Concepto;
    }

    public void setConcepto(String concepto) {
        Concepto = concepto;
    }

    public float getMonto() {
        return Monto;
    }

    public void setMonto(float monto) {
        Monto = monto;
    }

    public edu.udea.LaBastilla.model.Empleado getEmpleado() {
        return Empleado;
    }

    public void setEmpleado(edu.udea.LaBastilla.model.Empleado empleado) {
        Empleado = empleado;
    }

    public edu.udea.LaBastilla.model.Empresa getEmpresa() {
        return Empresa;
    }

    public void setEmpresa(edu.udea.LaBastilla.model.Empresa empresa) {
        Empresa = empresa;
    }

    public Date getCreatedAt() {
        return CreatedAt;
    }

    public void setCreatedAt(Date createdAt) {
        CreatedAt = createdAt;
    }

    public Date getUpdatedAt() {
        return UpdatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        UpdatedAt = updatedAt;
    }
}
