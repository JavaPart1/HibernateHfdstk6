package be.vdab.hfdstk6;

import be.vdab.hfdstk6.domain.GenderType;
import be.vdab.hfdstk6.domain.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SavePerson {
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {
            emf = Persistence.createEntityManagerFactory("mysqlcontainer");
            em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            Person person = new Person("Jan","Janssens", GenderType.MALE);
            em.persist(person);
            tx.commit();
            System.out.println("Person created");
        } finally {
            if (em != null) em.close();
            if (emf != null) emf.close();
        }

    }
}
