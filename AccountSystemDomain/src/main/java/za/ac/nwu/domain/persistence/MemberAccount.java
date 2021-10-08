package za.ac.nwu.domain.persistence;

import com.fasterxml.jackson.annotation.JsonIgnore;
import za.ac.nwu.domain.dto.MemberAccountDto;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "MEMBER_ACCOUNT", schema = "hr")

public class MemberAccount implements Serializable{
    private static final long serialVersionUID = -5676186722169564290L;

    private long accountId;
    private long milesBalance;
    private Set<MemberAccountTransaction> memberAccountTransactions;
    private Member memberId;
    private Currency currencyId;
    private long plays;


    public MemberAccount(){

    }

    public MemberAccount(long accountId, Member memberId, long milesBalance, long plays, Currency currencyId) {
        this.accountId = accountId;
        this.memberId = memberId;
        this.milesBalance = milesBalance;
        this.plays = plays;
        this.currencyId = currencyId;
    }

    public MemberAccount(MemberAccountDto memberAccountDto){
        this.setMemberId(memberAccountDto.getMemberId());
        this.setMilesBalance(memberAccountDto.getMilesBalance());
        this.setPlays(memberAccountDto.getPlays());
        this.setCurrencyId(memberAccountDto.getCurrencyId());
    }

    public MemberAccount(MemberAccount memberAccount) {
        this.setAccountId(memberAccount.getAccountId());
        this.setMemberId(memberAccount.getMemberId());
        this.setMilesBalance(memberAccount.getMilesBalance());
        this.setPlays(memberAccount.getPlays());
        this.setCurrencyId(memberAccount.getCurrencyId());
    }

    //region Accessor
    @Id
    @Column(name="ACCOUNT_ID")
    public long getAccountId() {
        return accountId;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="MEMBER_ID")
    @JsonIgnore
    public Member getMemberId() {
        return memberId;
    }

    @Column(name="MILES_BALANCE")
    public long getMilesBalance() {
        return milesBalance;
    }

    @Column(name="PLAYS")
    public long getPlays() {
        return plays;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CURRENCY_ID")
    @JsonIgnore
    public Currency getCurrencyId() {
        return currencyId;
    }

    @OneToMany(targetEntity = MemberAccountTransaction.class, fetch = FetchType.LAZY, mappedBy = "accountId", cascade = CascadeType.ALL)
    @JsonIgnore
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

    public void setPlays(long plays) {
        this.plays = plays;
    }

    public void setCurrencyId(Currency currencyId) {
        this.currencyId = currencyId;
    }

    public void setMemberAccountTransactions(Set<MemberAccountTransaction> memberAccountTransactions) {
        this.memberAccountTransactions = memberAccountTransactions;
    }
    //endregion
}

