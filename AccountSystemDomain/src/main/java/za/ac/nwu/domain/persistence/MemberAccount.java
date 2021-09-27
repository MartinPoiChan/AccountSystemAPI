package za.ac.nwu.domain.persistence;

import com.fasterxml.jackson.annotation.JsonBackReference;


import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "MEMBER_ACCOUNT", schema = "hr")

public class MemberAccount implements Serializable{
    private static final long serialVersionUID = -5676186722169564290L;

    private long accountId;
    private long milesBalance;
    private Set<MemberAccountTransaction> memberAccountTransactions;
    private Member memberId;

    public MemberAccount(){

    }

    public MemberAccount(long accountId, Member memberId, long milesBalance) {
        this.accountId = accountId;
        this.memberId = memberId;
        this.milesBalance = milesBalance;
    }

    //region Accessor
    @Id
    @Column(name="ACCOUNT_ID")
    public long getAccountId() {
        return accountId;
    }
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="MEMBER_ID")
    @JsonBackReference
    public Member getMemberId() {
        return memberId;
    }

    @Column(name="MILES_BALANCE")
    public long getMilesBalance() {
        return milesBalance;
    }

//    @OneToMany(targetEntity = MemberAccountTransaction.class, fetch = FetchType.LAZY, mappedBy = "accountId", orphanRemoval = true, cascade = CascadeType.PERSIST)
//    public Set<MemberAccountTransaction> getMemberAccountTransactions(){
//        return memberAccountTransactions;
//    }

    //endregion

    //region Mutator
    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    public void setMemberId(Member memberId) {
        this.memberId = memberId;
    }

    public void setMilesBalance(long milesBalance) {
        this.milesBalance = milesBalance;
    }

//    public void setMemberAccountTransactions(Set<MemberAccountTransaction> memberAccountTransactions) {
//        this.memberAccountTransactions = memberAccountTransactions;
//    }
    //endregion
}

