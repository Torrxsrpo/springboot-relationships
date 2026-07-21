package programacion.springbootrelationship.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import programacion.springbootrelationship.entities.Client;

import java.util.Optional;

public interface ClientRepository extends CrudRepository<Client, Long> {

}
