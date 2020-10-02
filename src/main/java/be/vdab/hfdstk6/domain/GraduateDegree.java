package be.vdab.hfdstk6.domain;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class GraduateDegree {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long gradDegId;
    private LocalDate dateAchieved;
    private int level;

    @ManyToOne
    @JoinColumn
    private Graduate graduate;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn
    private Degree degree;

    public GraduateDegree() {
    }

    public GraduateDegree(int level, Graduate graduate, Degree degree) {
        this.level = level;
        this.dateAchieved = LocalDate.now();
        this.graduate = graduate;
        this.degree = degree;
    }

    public long getGradDegId() {
        return gradDegId;
    }

    public LocalDate getDateAchieved() {
        return dateAchieved;
    }

    public void setDateAchieved(LocalDate dateAchieved) {
        this.dateAchieved = dateAchieved;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Graduate getGraduate() {
        return graduate;
    }

    public void setGraduate(Graduate graduate) {
        this.graduate = graduate;
    }

    public Degree getDegree() {
        return degree;
    }

    public void setDegree(Degree degree) {
        this.degree = degree;
    }

    @Override
    public String toString() {
        return "GraduateDegree{" +
                "gradDegId=" + gradDegId +
                ", dateAchieved=" + dateAchieved +
                ", level=" + level +
                ", degree=" + degree +
                '}';
    }
}
