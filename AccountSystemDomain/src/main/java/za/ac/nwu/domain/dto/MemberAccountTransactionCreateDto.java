package za.ac.nwu.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import za.ac.nwu.domain.persistence.MemberAccount;
import za.ac.nwu.domain.persistence.MemberAccountTransaction;
import za.ac.nwu.domain.persistence.Partner;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class MemberAccountTransactionCreateDto implements Serializable {
    private static final long serialVersionUID = -5898396210160031291L;
    private long accountId;
    private long partnerId;
    private LocalDate transactionDate;
    private long oldBalance;
    private long amount;

    public MemberAccountTransactionCreateDto(long accountId, long partnerId, LocalDate transactionDate, long oldBalance, long amount) {
        this.accountId = accountId;
        this.partnerId = partnerId;
        this.transactionDate = transactionDate;
        this.oldBalance = oldBalance;
        this.amount = amount;
    }

//    public MemberAccountTransactionCreateDto(MemberAccountTransaction memberAccountTransaction) {
//        this.setTransactionDate(memberAccountTransaction.getTransactionDate());
//        this.setOldBalance(memberAccountTransaction.getOldBalance());
//        this.setAmount(memberAccountTransaction.getAmount());
//    }

    //region Accessor
    @ApiModelProperty(
            position = 1,
            value = "Account ID",
            name = "AccountId",
            notes = "Account Id from MemberAccount table",
            dataType = "java.lang.Long",
            allowEmptyValue = false,
            required = true)
    public long getAccountId() {
        return accountId;
    }

    @ApiModelProperty(
            position = 2,
            value = "Reward ID",
            name = "RewardId",
            notes = "Reward Id from Reward table",
            dataType = "java.lang.Long",
            allowEmptyValue = false,
            required = true)
    public long getPartnerId() {
        return partnerId;
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
            value = "Transaction Amount",
            name = "Amount",
            notes = "Balance after the transaction",
            dataType = "java.lang.Long",
            example = "10",
            allowEmptyValue = false,
            required = true)
    public Long getAmount() {
        return amount;
    }

    //endregion

    //region Mutator

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    public void setPartnerId(long partnerId) {
        this.partnerId = partnerId;
    }

    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }

    public void setOldBalance(long oldBalance) {
        this.oldBalance = oldBalance;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }


    //endregion

//    @JsonIgnore
//    public MemberAccountTransaction getMATransaction(){
//        return new MemberAccountTransaction(getAccountId(),getPartnerId(),getTransactionDate(),getOldBalance(),getAmount());
//    }

}
