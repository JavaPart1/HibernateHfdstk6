package be.vdab.hfdstk6.domain;

import javax.persistence.*;

@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long patientId;
    private String patientName;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    private MedicalFile medicalFile;

    public Patient() {
    }

    public Patient(String patientName) {
        this.patientName = patientName;
    }

    public long getPatientId() {
        return patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public MedicalFile getMedicalFile() {
        return medicalFile;
    }

    public void setMedicalFile(MedicalFile medicalFile) {
        this.medicalFile = medicalFile;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "patientId=" + patientId +
                ", patientName='" + patientName + '\'' +
                ", medicalFile=" + medicalFile +
                '}';
    }
}
