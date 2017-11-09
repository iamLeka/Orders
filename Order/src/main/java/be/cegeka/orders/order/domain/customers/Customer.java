package be.cegeka.orders.order.domain.customers;

import javax.persistence.*;

@Entity
@Table(name = "CUSTOMERS")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CUSTOMER_ID")
    private int id;
    @Column(name = "LAST_NAME")
    private String lastName;
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "ADRESS")
    private String adress;
    @Column(name = "PHONE")
    private String phone;

    private Customer() {
    }

    public Customer(int id, String lastName, String firstName, String email, String adress, String phone) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.adress = adress;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }
}
