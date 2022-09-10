//Aquí inician los import
package edu.udea.LaBastilla.repository;
import edu.udea.LaBastilla.model.Enterprise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//Aquí finalizan los import

/*CLASE DE INTERFAZ PARA LA EMPRESA CON JPA */

@Repository
public interface EnterpriseRepository extends JpaRepository<Enterprise, Long> {}
