package za.ac.nwu.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "MEMBER_ACCOUNT_TRANSACTION")

public class MemberAccountTransaction implements Serializable{
    private static final long serialVersionUID = 2952115518194746513L;

    private long transactionId;
    private MemberAccount accountId;
    private Reward rewardId;
    private LocalDate transactionDate;

    //region Accessor
    @Id
    @Column(name="TransactionId")
    public long getTransactionId() {
        return transactionId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="AccountId")
    public MemberAccount getAccountId() {
        return accountId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="RewardId")
    public Reward getRewardId() {
        return rewardId;
    }

    @Column(name="TransactionDate")
    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    //endregion

    //region Mutator

    public void setTransactionId(long transactionId) {
        this.transactionId = transactionId;
    }

    public void setAccountId(MemberAccount accountId) {
        this.accountId = accountId;
    }

    public void setRewardId(Reward rewardId) {
        this.rewardId = rewardId;
    }

    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }

    //endregion


}
