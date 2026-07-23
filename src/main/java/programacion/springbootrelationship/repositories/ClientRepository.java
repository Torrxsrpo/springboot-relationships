package programacion.springbootrelationship.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import programacion.springbootrelationship.entities.Client;

import java.util.Optional;

public interface ClientRepository extends CrudRepository<Client, Long> {
    @Query("select c from Client c left join fetch c.addresses where c.id = ?1")
    Optional<Client> findOne(Long id); 

}
