package functions;

import entities.*;
import entities.enums.FishLivEnv;
import entities.enums.ProdType;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("petstore");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        // --- Création des produits ---
        Product p1 = new Product("P001", "Croquettes", ProdType.FOOD, 20.0);
        Product p2 = new Product("P002", "Laisse", ProdType.ACCESSORY, 15.0);
        Product p3 = new Product("P003", "Shampoing", ProdType.CLEANNING, 10.0);
        em.persist(p1);
        em.persist(p2);
        em.persist(p3);

        // --- Création des PetStores et Adresses ---
        
        // PetStore 1
        Address a1 = new Address();
        a1.setNumber("1");
        a1.setStreet("Rue de la Paix");
        a1.setZipCode("75000");
        a1.setCity("Paris");
        
        PetStore ps1 = new PetStore("PetStore Paris", "Jean Dupont", a1);
        a1.setPetstore(ps1);
        
        Set<Product> products1 = new HashSet<>();
        products1.add(p1);
        products1.add(p2);
        ps1.setProducts(products1);
        
        em.persist(ps1);

        // PetStore 2
        Address a2 = new Address();
        a2.setNumber("10");
        a2.setStreet("Avenue des Champs");
        a2.setZipCode("69000");
        a2.setCity("Lyon");

        PetStore ps2 = new PetStore("PetStore Lyon", "Marie Curie", a2);
        a2.setPetstore(ps2);
        
        Set<Product> products2 = new HashSet<>();
        products2.add(p2);
        products2.add(p3);
        ps2.setProducts(products2);
        
        em.persist(ps2);

        // PetStore 3
        Address a3 = new Address();
        a3.setNumber("5");
        a3.setStreet("Boulevard de la Mer");
        a3.setZipCode("13000");
        a3.setCity("Marseille");

        PetStore ps3 = new PetStore("PetStore Marseille", "Paul Martin", a3);
        a3.setPetstore(ps3);
        
        Set<Product> products3 = new HashSet<>();
        products3.add(p1);
        products3.add(p3);
        ps3.setProducts(products3);
        
        em.persist(ps3);

        // --- Création des Animaux ---
        
        // Animaux pour PetStore 1
        Cat c1 = new Cat("CHIP001");
        c1.setBirth(new Date());
        c1.setCouleur("Noir");
        c1.setPetstore(ps1);
        em.persist(c1);

        Cat c2 = new Cat("CHIP002");
        c2.setBirth(new Date());
        c2.setCouleur("Blanc");
        c2.setPetstore(ps1);
        em.persist(c2);

        Fish f1 = new Fish(FishLivEnv.FRESH_WATER);
        f1.setBirth(new Date());
        f1.setCouleur("Rouge");
        f1.setPetstore(ps1);
        em.persist(f1);

        // Animaux pour PetStore 2
        Cat c3 = new Cat("CHIP003");
        c3.setBirth(new Date());
        c3.setCouleur("Gris");
        c3.setPetstore(ps2);
        em.persist(c3);

        Fish f2 = new Fish(FishLivEnv.SEA_WATER);
        f2.setBirth(new Date());
        f2.setCouleur("Bleu");
        f2.setPetstore(ps2);
        em.persist(f2);

        // Animaux pour PetStore 3
        Fish f3 = new Fish(FishLivEnv.FRESH_WATER);
        f3.setBirth(new Date());
        f3.setCouleur("Jaune");
        f3.setPetstore(ps3);
        em.persist(f3);

        em.getTransaction().commit();

        // --- Requête pour extraire les animaux d'une animalerie ---
        Long petStoreId = ps1.getId();
        System.out.println("Animaux du PetStore " + ps1.getName() + " :");

        List<Animal> animals = em.createQuery("SELECT a FROM Animal a WHERE a.petstore.id = :id", Animal.class)
                .setParameter("id", petStoreId)
                .getResultList();

        for (Animal animal : animals) {
            System.out.println("Animal ID: " + animal.getId() + ", Couleur: " + animal.getCouleur() + ", Type: " + animal.getClass().getSimpleName());
        }

        em.close();
        emf.close();
    }
}
