package za.ac.nwu.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "MEMBER_ACCOUNT_TRANSACTION", schema = "hr")

public class MemberAccountTransaction implements Serializable{
    private static final long serialVersionUID = 2952115518194746513L;

    private long transactionId;
    private MemberAccount accountId;
    private Reward rewardId;
    private LocalDate transactionDate;
    private Long oldBalance;
    private Long newBalance;

    public MemberAccountTransaction()
    {}

    public MemberAccountTransaction(long transactionId, MemberAccount accountId, Reward rewardId, LocalDate transactionDate, Long oldBalance, Long newBalance) {
        this.transactionId = transactionId;
        this.accountId = accountId;
        this.rewardId = rewardId;
        this.transactionDate = transactionDate;
        this.oldBalance = oldBalance;
        this.newBalance = newBalance;
    }

    public MemberAccountTransaction(MemberAccount accountId, Reward rewardId, LocalDate transactionDate, Long oldBalance, Long newBalance) {
        this.accountId = accountId;
        this.rewardId = rewardId;
        this.transactionDate = transactionDate;
        this.oldBalance = oldBalance;
        this.newBalance = newBalance;
    }

    //region Accessor
    @Id
    @SequenceGenerator(name = "MEMBER_ACCOUNT_TRANSACTION_SEQ", sequenceName = "hr.MEMBER_ACCOUNT_TRANSACTION_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MEMBER_ACCOUNT_TRANSACTION_SEQ")
    @Column(name="TRANSACTION_ID")
    public long getTransactionId() {
        return transactionId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="ACCOUNT_ID")
    public MemberAccount getAccountId() {
        return accountId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="REWARD_ID")
    public Reward getRewardId() {
        return rewardId;
    }

    @Column(name="TRANSACTION_DATE")
    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    @Column(name="OLD_BALANCE")
    public Long getOldBalance() {
        return oldBalance;
    }

    @Column(name="NEW_BALANCE")
    public Long getNewBalance() {
        return newBalance;
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

    public void setOldBalance(Long oldBalance) {
        this.oldBalance = oldBalance;
    }

    public void setNewBalance(Long newBalance) {
        this.newBalance = newBalance;
    }

    //endregion

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MemberAccountTransaction that = (MemberAccountTransaction) o;
        return transactionId == that.transactionId && Objects.equals(accountId, that.accountId) && Objects.equals(rewardId, that.rewardId) && Objects.equals(transactionDate, that.transactionDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transactionId, accountId, rewardId, transactionDate);
    }
}
