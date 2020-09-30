package be.vdab.hfdstk6;

import be.vdab.hfdstk6.domain.Album;
import be.vdab.hfdstk6.domain.Customer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class GetCustomer {
    public static void main(String[] args) {
        String pgmName = "GetCustomer";
        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {
            emf = Persistence.createEntityManagerFactory("mysqlcontainer");
            em = emf.createEntityManager();
            EntityTransaction tx =em.getTransaction();
            System.out.println(pgmName + " - Start txn");
            tx.begin();
            Customer customer = em.find(Customer.class, 1L);
            tx.commit();
            System.out.println(pgmName + " - Commit txn");
            System.out.println(customer.toString());
            System.out.println(pgmName + " - End of program");
        } finally {
            if (em != null) em.close();
            if (emf != null) emf.close();
        }

    }
}
