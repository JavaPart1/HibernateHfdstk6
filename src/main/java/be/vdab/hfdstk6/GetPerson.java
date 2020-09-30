package be.vdab.hfdstk6;

import be.vdab.hfdstk6.domain.Person;

import javax.persistence.*;

public class GetPerson {
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {
            emf = Persistence.createEntityManagerFactory("mysqlcontainer");
            em = emf.createEntityManager();
            EntityTransaction tx =em.getTransaction();
            System.out.println("GetPerson - Start txn");
            tx.begin();
            Person person = em.find(Person.class, 4L);
            tx.commit();
            System.out.println("GetPerson - Commit txn");
            System.out.println(person.toString());
            System.out.println("GetPerson - End of program");
        } finally {
            if (em != null) em.close();
            if (emf != null) emf.close();
        }

    }
}
