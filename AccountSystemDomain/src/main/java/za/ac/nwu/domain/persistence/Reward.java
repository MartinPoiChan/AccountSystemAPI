package za.ac.nwu.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "CURRENCY")

public class Reward implements Serializable{
    private static final long serialVersionUID = 4933211794946159713L;

    private Set<MemberAccountTransaction> memberAccountTransactions;
    private long rewardId;
    private String rewardName;
    private long mileCost;

    //region Accessor
    @Id
    @Column(name="RewardId")
    public long getRewardId() {
        return rewardId;
    }

    @Column(name="RewardName")
    public String getRewardName() {
        return rewardName;
    }

    @Column(name="MileCost")
    public long getMileCost() {
        return mileCost;
    }

    @OneToMany(targetEntity = MemberAccountTransaction.class, fetch = FetchType.LAZY, mappedBy = "accountId", orphanRemoval = true, cascade = CascadeType.PERSIST)
    public Set<MemberAccountTransaction> getMemberAccountTransactions(){
        return memberAccountTransactions;
    }

    //endregion

    //region Mutator
    public void setRewardId(long rewardId) {
        this.rewardId = rewardId;
    }

    public void setRewardName(String rewardName) {
        this.rewardName = rewardName;
    }

    public void setMileCost(long mileCost) {
        this.mileCost = mileCost;
    }

    public void setMemberAccountTransactions(Set<MemberAccountTransaction> memberAccountTransactions) {
        this.memberAccountTransactions = memberAccountTransactions;
    }

    //endregion
}


