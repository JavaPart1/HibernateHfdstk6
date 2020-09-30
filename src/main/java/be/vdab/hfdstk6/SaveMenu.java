package be.vdab.hfdstk6;

import be.vdab.hfdstk6.domain.Album;
import be.vdab.hfdstk6.domain.Ingredient;
import be.vdab.hfdstk6.domain.Menu;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SaveMenu {
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {
            emf = Persistence.createEntityManagerFactory("mysqlcontainer");
            em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();
            Ingredient pasta = new Ingredient(400,"pasta");
            Ingredient rice = new Ingredient(500,"rice");
            Collection<Ingredient> ingredients = new ArrayList<>();
            ingredients.add(pasta);
            ingredients.add(rice);
            Menu menu = new Menu("Lunch",ingredients);
            System.out.println("SaveMenu - Start txn");
            tx.begin();
            em.persist(menu);
            tx.commit();
            System.out.println("SaveMenu - Commit txn");
            System.out.println("SaveMenu - Menu created");
        } finally {
            if (em != null) em.close();
            if (emf != null) emf.close();
        }

    }
}
