package programacion.springbootrelationship.entities;

import jakarta.persistence.*;


@Entity
@Table(name="invoices")
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private Long total;

    //Many es porque es esta entidad: Muchas facturas a un cliente
    @ManyToOne
//    @JoinColumn(name = "client_id") por default lo crea con este nombre
    private Client client;


    public Invoice() {
    }

    public Invoice(String description, Long total) {
        this.total = total;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Client getClient() {
        return client;
    }
    public void setClient(Client client) {
        this.client = client;
    }


    @Override
    public String toString() {
        return "Invoice{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", total=" + total +
                '}';
    }
}



