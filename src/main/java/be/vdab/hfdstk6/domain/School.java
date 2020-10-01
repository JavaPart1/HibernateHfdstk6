package be.vdab.hfdstk6.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long schoolId;

    private String schoolName;

    @OneToMany(mappedBy = "school")
    @OrderBy("studentName DESC")
    private List<Student> students = new ArrayList<>();

    public School() {
    }

    public School(String schoolName) {
        this.schoolName = schoolName;
    }

    public long getSchoolId() {
        return schoolId;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "School{" +
                "schoolId=" + schoolId +
                ", schoolName='" + schoolName + '\'' +
                ", students=" + students +
                '}';
    }
}
