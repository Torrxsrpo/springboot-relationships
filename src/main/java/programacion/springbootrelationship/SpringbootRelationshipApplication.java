package programacion.springbootrelationship;

import java.util.Arrays;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import programacion.springbootrelationship.entities.Address;
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
        RemoveAddressByfindById();

    }

       @Transactional
    public void RemoveAddressByfindById(){
        Optional<Client> optionalClient = clientRepository.findById(2L);
        if(optionalClient.isPresent()){
            Client client = optionalClient.get();
            Address address1 = new Address("Street 1", 39, "California");
            Address address2 = new Address("Vasco de gama", 3932, "Miami");
            client.setAddresses(Arrays.asList(address1, address2));

            clientRepository.save(client);
            System.out.println(client);

            Optional<Client> optionalClient2 = clientRepository.findOne(2L);
            optionalClient2.ifPresent(c -> {
                c.getAddresses().remove(address2);
                clientRepository.save(c);
                System.out.println(c);
            });
        }
    }


   

    
    @Transactional
    public void RemoveAddress(){
        Client client = new Client("Carlos", "Antonio");
        Address address1 = new Address("Street 1", 39, "California");
        Address address2 = new Address("Vasco de gama", 3932, "Miami");
        client.getAddresses().add(address1);
        client.getAddresses().add(address2);
        clientRepository.save(client);
        System.out.println(client);

        Optional<Client> optionalClient = clientRepository.findById(3L);
        optionalClient.ifPresent(c -> {
            c.getAddresses().remove(address1);
            clientRepository.save(c);
            System.out.println(c);
        });

    }

    @Transactional
    public void oneTomanyById(){
        Optional<Client> optionalClient = clientRepository.findById(2L);
        if(optionalClient.isPresent()){
            Client client = optionalClient.get();
            Address address1 = new Address("Street 1", 39, "California");
            Address address2 = new Address("Vasco de gama", 3932, "Miami");
            client.setAddresses(Arrays.asList(address1, address2));

            clientRepository.save(client);
            System.out.println(client);
        }




    }
    @Transactional
    public void oneTomany(){
        Client client = new Client("Carlos", "Antonio");
        Address address1 = new Address("Street 1", 39, "California");
        Address address2 = new Address("Vasco de gama", 3932, "Miami");
        client.getAddresses().add(address1);
        client.getAddresses().add(address2);
        clientRepository.save(client);
        System.out.println(client);

    }
    @Transactional
    public void manyToOneCreateClient(){

        Client client = new  Client("john", "fown");
        clientRepository.save(client);
        Invoice invoice = new  Invoice("Compras de oficina", 2000L );
        invoice.setClient(client);
        Invoice invoiceDB = invoiceRepository.save(invoice);
        System.out.println(invoiceDB);
    }
    @Transactional
    public void manyToOneFindByIdClient(){

        Optional<Client> Optionalclient = clientRepository.findById(1L);
        if(Optionalclient.isPresent()){
            Client client = Optionalclient.get();
            System.out.println(client);
            Invoice invoice = new  Invoice("Compras de oficina", 2000L );
            invoice.setClient(client);
            Invoice invoiceDB = invoiceRepository.save(invoice);
            System.out.println(invoiceDB);
        }
        }


}


