package be.vdab.hfdstk6.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Organisation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long organisationId;
    private String organisationName;

    @ManyToMany(mappedBy = "organisations")
    private Set<Member> members = new HashSet<>();

    public Organisation() {
    }

    public Organisation(String organisationName) {
        this.organisationName = organisationName;
    }

    public long getOrganisationId() {
        return organisationId;
    }

    public String getOrganisationName() {
        return organisationName;
    }

    public void setOrganisationName(String organisationName) {
        this.organisationName = organisationName;
    }

    public Set<Member> getMembers() {
        return members;
    }

    public void setMembers(Set<Member> members) {
        this.members = members;
    }

    @Override
    public String toString() {
        return "Organisation{" +
                "organisationId=" + organisationId +
                ", organisationName='" + organisationName + '\'' +
                ", members=" + members +
                '}';
    }
}
