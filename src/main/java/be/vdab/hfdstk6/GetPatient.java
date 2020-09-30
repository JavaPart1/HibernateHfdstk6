package be.vdab.hfdstk6;

import be.vdab.hfdstk6.domain.Customer;
import be.vdab.hfdstk6.domain.Patient;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class GetPatient {
    public static void main(String[] args) {
        String pgmName = "GetPatient";
        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {
            emf = Persistence.createEntityManagerFactory("mysqlcontainer");
            em = emf.createEntityManager();
            EntityTransaction tx =em.getTransaction();
            System.out.println(pgmName + " - Start txn");
            tx.begin();
            Patient patient = em.find(Patient.class, 1L);
            tx.commit();
            System.out.println(pgmName + " - Commit txn");
            System.out.println(patient.toString());
            System.out.println(pgmName + " - End of program");
        } finally {
            if (em != null) em.close();
            if (emf != null) emf.close();
        }

    }
}
