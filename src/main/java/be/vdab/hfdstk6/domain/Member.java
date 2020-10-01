package be.vdab.hfdstk6.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long memberId;
    private String memberName;

    @ManyToMany
    @JoinTable(name = "ORG_MEMBER", joinColumns = @JoinColumn(name = "MEM_ID"),
            inverseJoinColumns = @JoinColumn(name = "ORG_ID"))
    private Set<Organisation> organisations = new HashSet<>();

    public Member() {
    }

    public Member(String memberName) {
        this.memberName = memberName;
    }

    public long getMemberId() {
        return memberId;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public Set<Organisation> getOrganisations() {
        return organisations;
    }

    public void setOrganisations(Set<Organisation> organisations) {
        this.organisations = organisations;
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberId=" + memberId +
                ", memberName='" + memberName + '\'' +
                '}';
    }
}
