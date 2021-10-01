package za.ac.nwu.domain.persistence;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import za.ac.nwu.domain.dto.MemberAccountTransactionAdditionCreateDto;
import za.ac.nwu.domain.dto.MemberAccountTransactionCreateDto;
import za.ac.nwu.domain.dto.MemberAccountTransactionDto;

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
    private Partner partnerId;
    private LocalDate transactionDate;
    private Long oldBalance;
    private Long amount;

    public MemberAccountTransaction()
    {}

    public MemberAccountTransaction(long transactionId, MemberAccount accountId, Partner partnerId, LocalDate transactionDate, Long oldBalance, Long amount) {
        this.transactionId = transactionId;
        this.accountId = accountId;
        this.partnerId = partnerId;
        this.transactionDate = transactionDate;
        this.oldBalance = oldBalance;
        this.amount = amount;
    }

    public MemberAccountTransaction(MemberAccount accountId, Partner partnerId, LocalDate transactionDate, Long oldBalance, Long amount) {
        this.accountId = accountId;
        this.partnerId = partnerId;
        this.transactionDate = transactionDate;
        this.oldBalance = oldBalance;
        this.amount = amount;
    }

    public MemberAccountTransaction(MemberAccountTransactionDto memberAccountTransactionDto){
        setAccountId(memberAccountTransactionDto.getAccountId());
        setPartnerId(memberAccountTransactionDto.getPartnerId());
        setTransactionDate(memberAccountTransactionDto.getTransactionDate());
        setOldBalance(memberAccountTransactionDto.getOldBalance());
        setAmount(memberAccountTransactionDto.getAmount());
    }

    public MemberAccountTransaction(MemberAccountTransactionCreateDto memberAccountTransactionCreateDto) {
        this.setTransactionDate(memberAccountTransactionCreateDto.getTransactionDate());
        this.setAmount(memberAccountTransactionCreateDto.getAmount());
    }

    public MemberAccountTransaction(MemberAccountTransactionAdditionCreateDto memberAccountTransactionAdditionCreateDto) {
        this.setTransactionDate(memberAccountTransactionAdditionCreateDto.getTransactionDate());
        this.setAmount(memberAccountTransactionAdditionCreateDto.getAmount());
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
    @JsonIgnore
    public MemberAccount getAccountId() {
        return accountId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="PARTNER_ID")
    @JsonIgnore
    public Partner getPartnerId() {
        return partnerId;
    }

    @Column(name="TRANSACTION_DATE")
    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    @Column(name="OLD_BALANCE")
    public Long getOldBalance() {
        return oldBalance;
    }

    @Column(name="AMOUNT")
    public Long getAmount() {
        return amount;
    }

    //endregion

    //region Mutator
    public void setTransactionId(long transactionId) {
        this.transactionId = transactionId;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MemberAccountTransaction that = (MemberAccountTransaction) o;
        return transactionId == that.transactionId && Objects.equals(accountId, that.accountId) && Objects.equals(partnerId, that.partnerId) && Objects.equals(transactionDate, that.transactionDate) && Objects.equals(oldBalance, that.oldBalance) && Objects.equals(amount, that.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transactionId, accountId, partnerId, transactionDate, oldBalance, amount);
    }
}
