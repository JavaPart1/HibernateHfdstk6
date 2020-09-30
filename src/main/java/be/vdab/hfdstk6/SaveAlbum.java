package be.vdab.hfdstk6;

import be.vdab.hfdstk6.domain.Address;
import be.vdab.hfdstk6.domain.Album;
import be.vdab.hfdstk6.domain.GenderType;
import be.vdab.hfdstk6.domain.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class SaveAlbum {
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {
            emf = Persistence.createEntityManagerFactory("mysqlcontainer");
            em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();
            Album album = new Album("The Album","Alb Albamovich");
            List<String> trackers = new ArrayList<>();
            trackers.add("Track1");
            trackers.add("Track2");
            trackers.add("Track3");
            album.setTracks(trackers);
            System.out.println("SaveAlbum - Start txn");
            tx.begin();
            em.persist(album);
            tx.commit();
            System.out.println("SaveAlbum - Commit txn");
            System.out.println("SaveAlbum - Album created");
        } finally {
            if (em != null) em.close();
            if (emf != null) emf.close();
        }

    }
}
