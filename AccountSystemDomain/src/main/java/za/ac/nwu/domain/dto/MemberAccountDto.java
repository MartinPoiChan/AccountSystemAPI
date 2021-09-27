package za.ac.nwu.domain.dto;

import za.ac.nwu.domain.persistence.Member;
import za.ac.nwu.domain.persistence.MemberAccount;

import java.io.Serializable;

public class MemberAccountDto implements Serializable {

    private static final long serialVersionUID = 9147676098643481864L;

    private Member memberId;
    private long milesBalance;

    public MemberAccountDto(Member memberId, long milesBalance) {
        this.memberId = memberId;
        this.milesBalance = milesBalance;
    }

    //  Removed the member id you should probably replace that twat
    public MemberAccountDto(MemberAccount memberAccount) {
        this.setMilesBalance(memberAccount.getMilesBalance());
        this.setMemberId(memberAccount.getMemberId());
    }
    //region Accessor
    public Member getMemberId() {
        return memberId;
    }

    public long getMilesBalance() {
        return milesBalance;
    }
    //endregion

    //region Mutator
    public void setMemberId(Member memberId) {
        this.memberId = memberId;
    }

    public void setMilesBalance(long milesBalance) {
        this.milesBalance = milesBalance;
    }
    //endregion
}
