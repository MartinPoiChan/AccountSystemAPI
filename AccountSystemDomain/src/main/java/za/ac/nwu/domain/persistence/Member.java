package za.ac.nwu.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "MEMBER")
public class Member implements Serializable {
    private static final long serialVersionUID = 8249544561640133489L;

    private long memberId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNum;
    private Set<MemberAccount> memberAccount;

    public Member(long memberId, String firstName, String lastName, String email, String phoneNum, Set<MemberAccount> memberAccount) {
        this.memberId = memberId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNum = phoneNum;
        this.memberAccount = memberAccount;
    }

    //region Accessors
    @Id
    @Column(name="MemberId")
    public long getMemberId() {
        return memberId;
    }

    @Column(name="FirstName")
    public String getFirstName() {
        return firstName;
    }

    @Column(name="LastName")
    public String getLastName() {
        return lastName;
    }

    @Column(name="Email")
    public String getEmail() {
        return email;
    }

    @Column(name="PhoneNum")
    public String getPhoneNum() {
        return phoneNum;
    }

    @OneToMany(targetEntity = MemberAccount.class, fetch = FetchType.LAZY, mappedBy = "accountId", orphanRemoval = true, cascade = CascadeType.PERSIST)
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
}
