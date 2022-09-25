package edu.udea.LaBastilla.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="profile")
public class Profile {
    @Id
    private String id;
    @Column
    private String image;
    @Column
    private String phone;
    @OneToOne
    private Employee employee;
    @Column
    private Date createdAt = new Date();
    @Column
    private Date updatedAt = new Date();

    public Profile(String id, String image, String phone, Employee employee) {
        this.id = id;
        this.image = image;
        this.phone = phone;
        this.employee = employee;
    }

    public Profile() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
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
