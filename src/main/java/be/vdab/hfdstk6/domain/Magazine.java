package be.vdab.hfdstk6.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Magazine {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long magazineId;
    private String title;

    public Magazine() {
    }

    public Magazine(String title) {
        this.title = title;
    }

    public long getMagazineId() {
        return magazineId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Magazine{" +
                "magazineId=" + magazineId +
                ", title='" + title + '\'' +
                '}';
    }
}
