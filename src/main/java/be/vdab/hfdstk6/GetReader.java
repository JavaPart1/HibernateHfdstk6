package be.vdab.hfdstk6;

import be.vdab.hfdstk6.domain.Reader;
import be.vdab.hfdstk6.domain.School;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class GetReader {
    public static void main(String[] args) {
        String pgmName = "GetReader";
        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {
            emf = Persistence.createEntityManagerFactory("mysqlcontainer");
            em = emf.createEntityManager();
            EntityTransaction tx =em.getTransaction();
            System.out.println(pgmName + " - Start txn");
            tx.begin();
            Reader reader = em.find(Reader.class, 1L);
            tx.commit();
            System.out.println(pgmName + " - Commit txn");
            System.out.println(reader.toString());
            System.out.println(pgmName + " - End of program");
        } finally {
            if (em != null) em.close();
            if (emf != null) emf.close();
        }

    }
}
