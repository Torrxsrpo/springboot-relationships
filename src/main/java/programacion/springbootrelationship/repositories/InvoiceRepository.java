package programacion.springbootrelationship.repositories;

import org.springframework.data.repository.CrudRepository;
import programacion.springbootrelationship.entities.Invoice;

public interface InvoiceRepository extends CrudRepository<Invoice, Long> {

}
