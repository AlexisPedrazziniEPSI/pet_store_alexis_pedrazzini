package entities;

import jakarta.persistence.*;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String number;

    private String street;

    private String zipCode;

    private String city;

    @OneToOne
    @JoinColumn(name = "petstore_address")
    private PetStore petstore;

    public Address() {}

    public Address(Long id, String number, String street, String zipCode, String city, PetStore petstore) {
        this.number = number;
        this.street = street;
        this.zipCode = zipCode;
        this.city = city;
        this.petstore = petstore;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public PetStore getPetstore() {
        return petstore;
    }

    public void setPetstore(PetStore petstore) {
        this.petstore = petstore;
    }
}
