package za.ac.nwu.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import za.ac.nwu.domain.persistence.MemberAccount;
import za.ac.nwu.domain.persistence.MemberAccountTransaction;
import za.ac.nwu.domain.persistence.Partner;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@ApiModel(value = "MemberAccountTransaction", description = "A DTO for MemberAccountTransaction")
public class MemberAccountTransactionDto implements Serializable {

    private static final long serialVersionUID = -5898396210160031291L;
    private MemberAccount accountId;
    private Partner partnerId;
    private LocalDate transactionDate;
    private Long oldBalance;
    private Long amount;

    public MemberAccountTransactionDto(MemberAccount accountId, Partner partnerId, LocalDate transactionDate, Long oldBalance, Long amount) {
        this.accountId = accountId;
        this.partnerId = partnerId;
        this.transactionDate = transactionDate;
        this.oldBalance = oldBalance;
        this.amount = amount;
    }

    public MemberAccountTransactionDto(MemberAccountTransaction memberAccountTransaction) {
        this.setAccountId(memberAccountTransaction.getAccountId());
        this.setPartnerId(memberAccountTransaction.getPartnerId());
        this.setTransactionDate(memberAccountTransaction.getTransactionDate());
        this.setOldBalance(memberAccountTransaction.getOldBalance());
        this.setAmount(memberAccountTransaction.getAmount());
    }

    //region Accessor
    @ApiModelProperty(
            position = 1,
            value = "Account ID",
            name = "AccountId",
            notes = "Account Id from MemberAccount table",
            dataType = "java.lang.Long",
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
            allowEmptyValue = false,
            required = true)
    public Partner getPartnerId() {
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

    public void setAccountId(MemberAccount accountId) {
        this.accountId = accountId;
    }

    public void setPartnerId(Partner partnerId) {
        this.partnerId = partnerId;
    }

    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }

    public void setOldBalance(Long oldBalance) {
        this.oldBalance = oldBalance;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    //endregion

    @JsonIgnore
    public MemberAccountTransaction getMATransaction(){
        return new MemberAccountTransaction(getAccountId(),getPartnerId(),getTransactionDate(),getOldBalance(),getAmount());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MemberAccountTransactionDto that = (MemberAccountTransactionDto) o;
        return Objects.equals(accountId, that.accountId) && Objects.equals(partnerId, that.partnerId) && Objects.equals(transactionDate, that.transactionDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountId, partnerId, transactionDate);
    }
}
