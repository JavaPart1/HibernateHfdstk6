package be.vdab.hfdstk6;

import be.vdab.hfdstk6.domain.Album;
import be.vdab.hfdstk6.domain.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class GetAlbum {
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {
            emf = Persistence.createEntityManagerFactory("mysqlcontainer");
            em = emf.createEntityManager();
            EntityTransaction tx =em.getTransaction();
            System.out.println("GetAlbum - Start txn");
            tx.begin();
            Album album = em.find(Album.class, 2L);
            tx.commit();
            System.out.println("GetAlbum - Commit txn");
            System.out.println(album.toString());
            System.out.println("GetAlbum - End of program");
        } finally {
            if (em != null) em.close();
            if (emf != null) emf.close();
        }

    }
}
