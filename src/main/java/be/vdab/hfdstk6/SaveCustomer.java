package be.vdab.hfdstk6;

import be.vdab.hfdstk6.domain.Album;
import be.vdab.hfdstk6.domain.Customer;
import be.vdab.hfdstk6.domain.Email;
import be.vdab.hfdstk6.domain.EmailType;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class SaveCustomer {
    public static void main(String[] args) {
        String pgmName = "SaveCustomer";
        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {
            emf = Persistence.createEntityManagerFactory("mysqlcontainer");
            em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();
            Email emailHome = new Email("homer@springfield.com");
            Email emailBusiness = new Email("homer@nuclear.com");
            Customer customer = new Customer();
            customer.getPhones().put("home","555-12541");
            customer.getPhones().put("mobile","555-12991");
            customer.getEmails().put(EmailType.HOME, emailHome);
            customer.getEmails().put(EmailType.BUSINESS, emailBusiness);
            System.out.println(pgmName + " - Start txn");
            tx.begin();
            em.persist(customer);
            tx.commit();
            System.out.println(pgmName + " - Commit txn");
            System.out.println(pgmName + " - Customer created");
        } finally {
            if (em != null) em.close();
            if (emf != null) emf.close();
        }

    }
}
