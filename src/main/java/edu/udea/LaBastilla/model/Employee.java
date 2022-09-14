//Aquí inician los import
package edu.udea.LaBastilla.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import edu.udea.LaBastilla.enums.Enum_RoleName;
import javax.persistence.*;
import java.util.Date;
import java.util.List;
//Aquí finalizan los import

/*CLASE MODELO PARA EMPLEADO. SE CREA UNA TABLA Y DOS
 * RELACIONES PARA EMPRESAS Y TRANSACCIONES DADO EL 
 * DIAGRAMA DE ENTIDAD RELACIÓN*/

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

    @ManyToOne
    private Enterprise enterprise;

    @Column
    @Enumerated(EnumType.STRING)
    private Enum_RoleName role;

    @OneToMany(mappedBy = "employee")
    @JsonIgnore
    private List<Transaction> transactions;

    @Column
    private Date createdAt = new Date();

    @Column
    private Date updatedAt = new Date();

    public Employee(long id, String name, String email, Enterprise enterprise, Enum_RoleName role, List<Transaction> transactions, Date createdAt, Date updatedAt) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.enterprise = enterprise;
        this.role = role;
        this.transactions = transactions;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Employee() {}

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
