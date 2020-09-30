package be.vdab.hfdstk6.domain;

import javax.persistence.*;

@Entity
public class MedicalFile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long medicalFileId;
    private float height;
    private float weight;

    @OneToOne(mappedBy = "medicalFile")
    private Patient patient;

    public MedicalFile() {
    }

    public MedicalFile(float height, float weight) {
        this.height = height;
        this.weight = weight;
    }

    public long getMedicalFileId() {
        return medicalFileId;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    @Override
    public String toString() {
        return "MedicalFile{" +
                "medicalFileId=" + medicalFileId +
                ", height=" + height +
                ", weight=" + weight +
                '}';
    }
}
