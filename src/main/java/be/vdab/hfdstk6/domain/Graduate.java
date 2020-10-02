package be.vdab.hfdstk6.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Graduate {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long graduateId;

    private String graduateName;

    @OneToMany(mappedBy = "graduate", cascade = CascadeType.PERSIST)
    private List<GraduateDegree> degrees = new ArrayList<>();

    public Graduate() {
    }

    public Graduate(String graduateName) {
        this.graduateName = graduateName;
    }

    public long getGraduateId() {
        return graduateId;
    }

    public String getGraduateName() {
        return graduateName;
    }

    public void setGraduateName(String graduateName) {
        this.graduateName = graduateName;
    }

    public List<GraduateDegree> getDegrees() {
        return degrees;
    }

    public void setDegrees(List<GraduateDegree> degrees) {
        this.degrees = degrees;
    }

    @Override
    public String toString() {
        return "Graduate{" +
                "graduateId=" + graduateId +
                ", graduateName='" + graduateName + '\'' +
                ", degrees=" + degrees +
                '}';
    }
}
