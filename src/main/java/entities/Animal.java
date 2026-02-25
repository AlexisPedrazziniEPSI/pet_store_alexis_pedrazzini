package entities;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date birth;

    private String couleur;

    @ManyToOne
    @JoinColumn(name = "petstore_id")
    private PetStore petstore;

    public Animal() {}

    public Animal(Date birth, String couleur, PetStore petstore) {
        this.birth = birth;
        this.couleur = couleur;
        this.petstore = petstore;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Date getBirth() {
        return birth;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setPetstore(PetStore petstore) {
        this.petstore = petstore;
    }

    public PetStore getPetstore() {
        return petstore;
    }
}
