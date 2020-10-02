package be.vdab.hfdstk6.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Degree {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long degreeId;
    private String degreeName;

    @OneToMany(mappedBy = "degree")
    private List<GraduateDegree> graduates = new ArrayList<>();

    public Degree() {
    }

    public Degree(String degreeName) {
        this.degreeName = degreeName;
    }

    public long getDegreeId() {
        return degreeId;
    }

    public String getDegreeName() {
        return degreeName;
    }

    public void setDegreeName(String degreeName) {
        this.degreeName = degreeName;
    }

    public List<GraduateDegree> getGraduates() {
        return graduates;
    }

    public void setGraduates(List<GraduateDegree> graduates) {
        this.graduates = graduates;
    }

    @Override
    public String toString() {
        return "Degree{" +
                "degreeId=" + degreeId +
                ", degreeName='" + degreeName + '\'' +
                '}';
    }
}
