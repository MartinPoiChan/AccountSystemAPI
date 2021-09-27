package za.ac.nwu.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import za.ac.nwu.domain.persistence.MemberAccount;
import za.ac.nwu.domain.persistence.MemberAccountTransaction;
import za.ac.nwu.domain.persistence.Reward;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@ApiModel(value = "MemberAccountTransaction", description = "A DTO for MemberAccountTransaction")
public class MemberAccountTransactionDto implements Serializable {

    private static final long serialVersionUID = -5898396210160031291L;
    private MemberAccount accountId;
    private Reward rewardId;
    private LocalDate transactionDate;
    private Long oldBalance;
    private Long newBalance;

    public MemberAccountTransactionDto(MemberAccount accountId, Reward rewardId, LocalDate transactionDate, Long oldBalance, Long newBalance) {
        this.accountId = accountId;
        this.rewardId = rewardId;
        this.transactionDate = transactionDate;
        this.oldBalance = oldBalance;
        this.newBalance = newBalance;
    }

    public MemberAccountTransactionDto(MemberAccountTransaction memberAccountTransaction) {
        this.setAccountId(memberAccountTransaction.getAccountId());
        this.setRewardId(memberAccountTransaction.getRewardId());
        this.setTransactionDate(memberAccountTransaction.getTransactionDate());
        this.setOldBalance(memberAccountTransaction.getOldBalance());
        this.setNewBalance(memberAccountTransaction.getNewBalance());
    }

    //region Accessor
    @ApiModelProperty(
            position = 1,
            value = "Account ID",
            name = "AccountId",
            notes = "Account Id from MemberAccount table",
            dataType = "java.lang.Long",
            example = "1",
            allowEmptyValue = false,
            required = true)
    public MemberAccount getAccountId() {
        return accountId;
    }

    @ApiModelProperty(
            position = 2,
            value = "Reward ID",
            name = "RewardId",
            notes = "Reward Id from Reward table",
            dataType = "java.lang.Long",
            example = "1",
            allowEmptyValue = false,
            required = true)
    public Reward getRewardId() {
        return rewardId;
    }

    @ApiModelProperty(
            position = 3,
            value = "Transaction Date",
            name = "TransactionDate",
            notes = "Transaction Date",
            dataType = "java.lang.String",
            example = "2020-01-01",
            allowEmptyValue = false,
            required = true)
    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    @ApiModelProperty(
            position = 4,
            value = "Transaction Old Balance",
            name = "OldBalance",
            notes = "Balance before the transaction",
            dataType = "java.lang.Long",
            example = "15",
            allowEmptyValue = false,
            required = true)
    public Long getOldBalance() {
        return oldBalance;
    }

    @ApiModelProperty(
            position = 4,
            value = "Transaction New Balance",
            name = "NewBalance",
            notes = "Balance after the transaction",
            dataType = "java.lang.Long",
            example = "10",
            allowEmptyValue = false,
            required = true)
    public Long getNewBalance() {
        return newBalance;
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

    public void setOldBalance(Long oldBalance) {
        this.oldBalance = oldBalance;
    }

    public void setNewBalance(Long newBalance) {
        this.newBalance = newBalance;
    }

    //endregion

    @JsonIgnore
    public MemberAccountTransaction getMATransaction(){
        return new MemberAccountTransaction(getAccountId(),getRewardId(),getTransactionDate(),getOldBalance(),getNewBalance());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MemberAccountTransactionDto that = (MemberAccountTransactionDto) o;
        return Objects.equals(accountId, that.accountId) && Objects.equals(rewardId, that.rewardId) && Objects.equals(transactionDate, that.transactionDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountId, rewardId, transactionDate);
    }
}
