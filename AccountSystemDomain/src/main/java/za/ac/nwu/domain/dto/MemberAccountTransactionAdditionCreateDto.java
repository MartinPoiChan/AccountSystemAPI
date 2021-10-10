package za.ac.nwu.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import za.ac.nwu.domain.persistence.MemberAccount;
import za.ac.nwu.domain.persistence.MemberAccountTransaction;
import za.ac.nwu.domain.persistence.Partner;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class MemberAccountTransactionAdditionCreateDto implements Serializable {
    private static final long serialVersionUID = -5898396210160031291L;
    private long accountId;
    private LocalDate transactionDate;
    private long oldBalance;
    private long amount;
    private boolean flag;

    public MemberAccountTransactionAdditionCreateDto(long accountId, LocalDate transactionDate, long oldBalance, long amount) {
        this.accountId = accountId;
        this.transactionDate = transactionDate;
        this.oldBalance = oldBalance;
        this.amount = amount;
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
    public long getAccountId() {
        return accountId;
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
            example = "0",
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


    @ApiModelProperty(
            position = 4,
            value = "Transaction Throw",
            name = "Flag",
            notes = "Will throw exception if true",
            dataType = "java.lang.Boolean",
            example = "True",
            allowEmptyValue = false,
            required = true)
    public boolean isFlag() {
        return flag;
    }


    //endregion

    //region Mutator

    public void setAccountId(long accountId) {
        this.accountId = accountId;
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

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    //endregion

//    @JsonIgnore
//    public MemberAccountTransaction getMATransaction(){
//        return new MemberAccountTransaction(getAccountId(),getPartnerId(),getTransactionDate(),getOldBalance(),getAmount());
//    }

}
