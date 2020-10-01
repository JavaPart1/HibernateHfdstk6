package be.vdab.hfdstk6;

import be.vdab.hfdstk6.domain.Organisation;
import be.vdab.hfdstk6.domain.Reader;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class GetOrganisation {
    public static void main(String[] args) {
        String pgmName = GetOrganisation.class.getSimpleName();
        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {
            emf = Persistence.createEntityManagerFactory("mysqlcontainer");
            em = emf.createEntityManager();
            EntityTransaction tx =em.getTransaction();
            System.out.println(pgmName + " - Start txn");
            tx.begin();
            Organisation organisation = em.find(Organisation.class, 1L);
            tx.commit();
            System.out.println(pgmName + " - Commit txn");
            System.out.println(organisation.toString());
            System.out.println(pgmName + " - End of program");
        } finally {
            if (em != null) em.close();
            if (emf != null) emf.close();
        }

    }
}
