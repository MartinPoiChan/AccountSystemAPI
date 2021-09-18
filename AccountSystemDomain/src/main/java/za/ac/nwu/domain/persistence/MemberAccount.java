package za.ac.nwu.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "MEMBER_ACCOUNT")

public class MemberAccount implements Serializable{
    private static final long serialVersionUID = -5676186722169564290L;

    private long accountId;
    private Member memberId;
    private long milesBalance;
    private Set<MemberAccountTransaction> memberAccountTransactions;

    //region Accessor
    @Id
    @Column(name="AccountId")
    public long getAccountId() {
        return accountId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="MemberId")
    public Member getMemberId() {
        return memberId;
    }

    @Column(name="MilesBalance")
    public long getMilesBalance() {
        return milesBalance;
    }

    @OneToMany(targetEntity = MemberAccountTransaction.class, fetch = FetchType.LAZY, mappedBy = "accountId", orphanRemoval = true, cascade = CascadeType.PERSIST)
    public Set<MemberAccountTransaction> getMemberAccountTransactions(){
        return memberAccountTransactions;
    }

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

    public void setMemberAccountTransactions(Set<MemberAccountTransaction> memberAccountTransactions) {
        this.memberAccountTransactions = memberAccountTransactions;
    }
//endregion
}

