package be.vdab.hfdstk6;

import be.vdab.hfdstk6.domain.Album;
import be.vdab.hfdstk6.domain.Menu;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class GetMenu {
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {
            emf = Persistence.createEntityManagerFactory("mysqlcontainer");
            em = emf.createEntityManager();
            EntityTransaction tx =em.getTransaction();
            System.out.println("GetMenu - Start txn");
            tx.begin();
            Menu menu = em.find(Menu.class, 2);
            tx.commit();
            System.out.println("GetMenu - Commit txn");
            System.out.println(menu.toString());
            System.out.println("GetMenu - End of program");
        } finally {
            if (em != null) em.close();
            if (emf != null) emf.close();
        }

    }
}
