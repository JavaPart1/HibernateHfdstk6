package be.vdab.hfdstk6;

import be.vdab.hfdstk6.domain.Magazine;
import be.vdab.hfdstk6.domain.Reader;
import be.vdab.hfdstk6.domain.School;
import be.vdab.hfdstk6.domain.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SaveReader {
    public static void main(String[] args) {
        String pgmName = "SaveReader";
        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {
            emf = Persistence.createEntityManagerFactory("mysqlcontainer");
            em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();
            // Domain creations
            Set<Magazine> magazineSet = new HashSet<>();
            Magazine hln = new Magazine("HLN");
            Magazine stan = new Magazine("De Standaard");
            Magazine tijd = new Magazine("De Tijd");
            magazineSet.add(hln);
            magazineSet.add(stan);
            magazineSet.add(tijd);
            Reader reader = new Reader("Night Reader");
            reader.setMagazines(magazineSet);
            System.out.println(pgmName + " - Start txn");
            tx.begin();
            em.persist(reader);
            em.persist(hln);
            em.persist(stan);
            em.persist(tijd);
            tx.commit();
            System.out.println(pgmName + " - Commit txn");
            System.out.println(pgmName + " - Reader created");
        } finally {
            if (em != null) em.close();
            if (emf != null) emf.close();
        }

    }
}
