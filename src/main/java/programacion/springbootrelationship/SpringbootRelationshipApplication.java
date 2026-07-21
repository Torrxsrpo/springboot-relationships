package programacion.springbootrelationship;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import programacion.springbootrelationship.entities.Client;
import programacion.springbootrelationship.entities.Invoice;
import programacion.springbootrelationship.repositories.ClientRepository;
import programacion.springbootrelationship.repositories.InvoiceRepository;

@SpringBootApplication
public class SpringbootRelationshipApplication implements CommandLineRunner {
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private InvoiceRepository invoiceRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringbootRelationshipApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        manyToOne();

    }

    public void manyToOne(){

        Client client = new  Client("john", "fown");
        clientRepository.save(client);
        Invoice invoice = new  Invoice("Compras de oficina", 2000L );
        invoice.setClient(client);
        Invoice invoiceDB = invoiceRepository.save(invoice);
        System.out.println(invoiceDB);
    }
}


