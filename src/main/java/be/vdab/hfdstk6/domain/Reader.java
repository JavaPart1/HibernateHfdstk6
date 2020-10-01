package be.vdab.hfdstk6.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Reader {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long readerId;
    private String name;

    @ManyToMany
    private Set<Magazine> magazines = new HashSet<>();

    public Reader() {
    }

    public Reader(String name) {
        this.name = name;
    }

    public long getReaderId() {
        return readerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Magazine> getMagazines() {
        return magazines;
    }

    public void setMagazines(Set<Magazine> magazines) {
        this.magazines = magazines;
    }

    @Override
    public String toString() {
        return "Reader{" +
                "readerId=" + readerId +
                ", name='" + name + '\'' +
                ", magazines=" + magazines +
                '}';
    }
}
