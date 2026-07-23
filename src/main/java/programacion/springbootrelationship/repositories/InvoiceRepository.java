package programacion.springbootrelationship.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import programacion.springbootrelationship.entities.Invoice;

public interface InvoiceRepository extends CrudRepository<Invoice, Long> {
 
    @Query("select i from Invoice i left join fetch i.client where i.client.id = ?1")
    List<Invoice> findByClient(Long id);  

}
