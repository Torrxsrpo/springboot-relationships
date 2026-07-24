package programacion.springbootrelationship.entities;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(name="last_name")
    private String lastName;
    //    @JoinColumn(name="client_id")
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true) //OrphanRemoval: Si se elimina un cliente, se eliminan sus direcciones asociadas o su direccion se elimina completamente de la base de datos, no solo de la lista de direcciones del cliente
    @JoinTable(name = "tbl_client_address", joinColumns = @JoinColumn(name = "client_id"), inverseJoinColumns = @JoinColumn(name = "address_id"),
    uniqueConstraints = @UniqueConstraint(columnNames = {"address_id"}))
    private Set<Address> addresses;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy="client")
    private List<Invoice> invoices;


    public Client() {
        addresses = new HashSet<>(); //revisar porque cambio todo a HashSet en vez de List 
        invoices = new ArrayList<>();
    }

    public Client(String name, String lastName) {
        this();
        this.name = name;
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }

    public List<Invoice> getInvoices() {
        return invoices;
    }

    public void setInvoices(List<Invoice> invoices) {
        this.invoices = invoices;
    }

    public Client addInvoice(Invoice invoice){
        invoices.add(invoice);
        invoice.setClient(this);  
        return this;  
    }



    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", LastName='" + lastName + '\'' +
                ", addresses=" + addresses + '\'' +
                ", invoices=" + invoices + '\'' +
                '}'
                ;
    }


}
