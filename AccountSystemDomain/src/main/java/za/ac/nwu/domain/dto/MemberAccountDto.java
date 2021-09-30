package za.ac.nwu.domain.dto;

import za.ac.nwu.domain.persistence.Currency;
import za.ac.nwu.domain.persistence.Member;
import za.ac.nwu.domain.persistence.MemberAccount;

import java.io.Serializable;

public class MemberAccountDto implements Serializable {

    private static final long serialVersionUID = 9147676098643481864L;

    private Member memberId;
    private long milesBalance;
    private long plays;
    private Currency currencyId;

    public MemberAccountDto(Member memberId, long milesBalance, long plays, Currency currencyId) {
        this.memberId = memberId;
        this.milesBalance = milesBalance;
        this.plays = plays;
        this.currencyId = currencyId;
    }

    public MemberAccountDto(MemberAccount memberAccount) {
        this.setMilesBalance(memberAccount.getMilesBalance());
        this.setMemberId(memberAccount.getMemberId());
        this.setPlays(memberAccount.getPlays());
        this.setCurrencyId(memberAccount.getCurrencyId());
    }
    //region Accessor


    public Member getMemberId() {
        return memberId;
    }

    public long getMilesBalance() {
        return milesBalance;
    }

    public long getPlays() {
        return plays;
    }

    public Currency getCurrencyId() {
        return currencyId;
    }

    //endregion

    //region Mutator

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


    //endregion
}
