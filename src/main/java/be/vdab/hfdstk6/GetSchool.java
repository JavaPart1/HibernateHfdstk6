package be.vdab.hfdstk6;

import be.vdab.hfdstk6.domain.Patient;
import be.vdab.hfdstk6.domain.School;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class GetSchool {
    public static void main(String[] args) {
        String pgmName = "GetSchool";
        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {
            emf = Persistence.createEntityManagerFactory("mysqlcontainer");
            em = emf.createEntityManager();
            EntityTransaction tx =em.getTransaction();
            System.out.println(pgmName + " - Start txn");
            tx.begin();
            School school = em.find(School.class, 3L);

            tx.commit();
            System.out.println(pgmName + " - Commit txn");
            System.out.println(school.toString());
            System.out.println(pgmName + " - End of program");
        } finally {
            if (em != null) em.close();
            if (emf != null) emf.close();
        }

    }
}
