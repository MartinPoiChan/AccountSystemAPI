package za.ac.nwu.domain.persistence;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "MEMBER", schema = "hr")
public class Member implements Serializable {
    private static final long serialVersionUID = 8249544561640133489L;

    private long memberId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNum;
    private Set<MemberAccount> memberAccount;

    public Member()
    {}

    public Member(long memberId, String firstName, String lastName, String email, String phoneNum) {
        this.memberId = memberId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNum = phoneNum;
    }

    //region Accessors
    @Id
    @Column(name="MEMBER_ID")
    public long getMemberId() {
        return memberId;
    }

    @Column(name="FIRST_NAME")
    public String getFirstName() {
        return firstName;
    }

    @Column(name="LAST_NAME")
    public String getLastName() {
        return lastName;
    }

    @Column(name="EMAIL")
    public String getEmail() {
        return email;
    }

    @Column(name="PHONE_NUM")
    public String getPhoneNum() {
        return phoneNum;
    }

    @OneToMany(targetEntity = MemberAccount.class, fetch = FetchType.EAGER, mappedBy = "memberId", cascade = CascadeType.ALL)
    @JsonIgnore
    public Set<MemberAccount> getMemberAccount(){
        return memberAccount;
    }

    //endregion

    //region Mutators
    public void setMemberId(long memberId) {
        this.memberId = memberId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public void setMemberAccount(Set<MemberAccount> memberAccount) {
        this.memberAccount = memberAccount;
    }
    //endregion


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return memberId == member.memberId && Objects.equals(firstName, member.firstName) && Objects.equals(lastName, member.lastName) && Objects.equals(email, member.email) && Objects.equals(phoneNum, member.phoneNum) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(memberId, firstName, lastName, email, phoneNum);
    }
}
