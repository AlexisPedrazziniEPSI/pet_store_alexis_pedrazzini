package entities;

import entities.enums.ProdType;
import jakarta.persistence.*;
import java.util.Set;

@Entity
public class Product {
    // définiton des valeurs de l'entité
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;

    private String label;

    @Enumerated(EnumType.STRING)
    private ProdType type;

    private double price;

    @ManyToMany(mappedBy = "products") // On fait le mappage sur la clé primaire qui est référencer dans la classe PetStore
    private Set<PetStore> petStores;

    public Product() {} // constructeur vide

    public Product(String code, String label, ProdType type, double price) { // constructeur avec paramètres
        this.code = code;
        this.label = label;
        this.type = type;
        this.price = price;
    }

    // getters et setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public ProdType getType() {
        return type;
    }

    public void setType(ProdType type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Set<PetStore> getPetStores() {
        return petStores;
    }

    public void setPetStores(Set<PetStore> petStores) {
        this.petStores = petStores;
    }
}
