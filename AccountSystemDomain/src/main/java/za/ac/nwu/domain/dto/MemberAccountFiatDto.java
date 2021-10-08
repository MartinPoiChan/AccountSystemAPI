package za.ac.nwu.domain.dto;

import za.ac.nwu.domain.persistence.Currency;
import za.ac.nwu.domain.persistence.Member;
import za.ac.nwu.domain.persistence.MemberAccount;

import java.io.Serializable;

public class MemberAccountFiatDto implements Serializable {
    private static final long serialVersionUID = -7802230356670664496L;

    private Member memberId;
    private long milesBalance;
    private Currency currency;
    private long fiat;

    public MemberAccountFiatDto(Member memberId, long milesBalance, Currency currency, long fiat) {
        this.memberId = memberId;
        this.milesBalance = milesBalance;
        this.currency = currency;
        this.fiat = fiat;
    }

    public MemberAccountFiatDto(MemberAccount memberAccount) {
        setMemberId(memberAccount.getMemberId());
        setMilesBalance(memberAccount.getMilesBalance());
        setCurrency(memberAccount.getCurrencyId());
        //currency = memberAccount.getCurrencyId();
        setFiat(currency.milesConv*memberAccount.getMilesBalance());
    }

    //region Accessors
    public Member getMemberId() {
        return memberId;
    }

    public long getMilesBalance() {
        return milesBalance;
    }

    public Currency getCurrency() {
        return currency;
    }

    public long getFiat() {
        return fiat;
    }

    //endregion

    //region Mutators
    public void setMemberId(Member memberId) {
        this.memberId = memberId;
    }

    public void setMilesBalance(long milesBalance) {
        this.milesBalance = milesBalance;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public void setFiat(long fiat) {
        this.fiat = fiat;
    }

    //endregion
}
