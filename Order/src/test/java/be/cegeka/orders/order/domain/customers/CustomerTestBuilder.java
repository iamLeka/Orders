package be.cegeka.orders.order.domain.customers;


import org.springframework.test.util.ReflectionTestUtils;

public class CustomerTestBuilder {
    private int id;
    private String lastName;
    private String firstName;
    private String email;
    private String address;
    private String phone;

    public static CustomerTestBuilder aCustomer(){
        return new CustomerTestBuilder()
                .withLastName("Karpisek")
                .withFirstName("Len")
                .withEmail("piemeljongennegenenzestigenhalf@hetejongen.xxx")
                .withAddress("kerkstraat 25, moskou")
                .withPhone("neen");
                    }

    public CustomerTestBuilder withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public CustomerTestBuilder withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public CustomerTestBuilder withEmail(String email) {
        this.email = email;
        return this;
    }

    public CustomerTestBuilder withAddress(String address) {
        this.address = address;
        return this;
    }

    public CustomerTestBuilder withPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public CustomerTestBuilder withID(int id){
        this.id = id;
        return this;
    }

    public Customer build(){
        Customer customer = new Customer(lastName,firstName,email,address,phone);
        ReflectionTestUtils.setField(customer, "id", id);
        return customer;
    }
}
