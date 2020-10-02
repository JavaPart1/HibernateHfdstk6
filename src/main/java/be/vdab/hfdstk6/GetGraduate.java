package be.vdab.hfdstk6;

import be.vdab.hfdstk6.domain.Graduate;
import be.vdab.hfdstk6.domain.School;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class GetGraduate {
    public static void main(String[] args) {
        String pgmName = GetGraduate.class.getSimpleName();
        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {
            emf = Persistence.createEntityManagerFactory("mysqlcontainer");
            em = emf.createEntityManager();
            EntityTransaction tx =em.getTransaction();
            System.out.println(pgmName + " - Start txn");
            tx.begin();
            Graduate graduate = em.find(Graduate.class, 9L);
            tx.commit();
            System.out.println(pgmName + " - Commit txn");
            System.out.println(graduate.toString());
            System.out.println(pgmName + " - End of program");
        } finally {
            if (em != null) em.close();
            if (emf != null) emf.close();
        }

    }
}
