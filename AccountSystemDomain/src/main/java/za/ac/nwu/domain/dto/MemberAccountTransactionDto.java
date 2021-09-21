package za.ac.nwu.domain.dto;

import za.ac.nwu.domain.persistence.MemberAccount;
import za.ac.nwu.domain.persistence.MemberAccountTransaction;
import za.ac.nwu.domain.persistence.Reward;

import java.io.Serializable;
import java.time.LocalDate;

public class MemberAccountTransactionDto implements Serializable {

    private static final long serialVersionUID = -5898396210160031291L;
    private MemberAccount accountId;
    private Reward rewardId;
    private LocalDate transactionDate;

    public MemberAccountTransactionDto(MemberAccount accountId, Reward rewardId, LocalDate transactionDate) {
        this.accountId = accountId;
        this.rewardId = rewardId;
        this.transactionDate = transactionDate;
    }

    public MemberAccountTransactionDto(MemberAccountTransaction memberAccountTransaction) {
        this.setAccountId(memberAccountTransaction.getAccountId());
        this.setRewardId(memberAccountTransaction.getRewardId());
        this.setTransactionDate(memberAccountTransaction.getTransactionDate());
    }

    //region Accessor

    public MemberAccount getAccountId() {
        return accountId;
    }

    public Reward getRewardId() {
        return rewardId;
    }

    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    //endregion

    //region Mutator

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
