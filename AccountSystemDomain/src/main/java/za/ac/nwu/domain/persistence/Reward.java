package za.ac.nwu.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;

import java.util.Set;

@Entity
@Table(name = "REWARD", schema = "hr")
public class Reward implements Serializable{
    private static final long serialVersionUID = 4933211794946159713L;

    public Set<MemberAccountTransaction> memberAccountTransactions;
    public long rewardId;
    public String rewardName;
    public long mileCost;

    public Reward(){

    }

    public Reward( long rewardId, String rewardName, long mileCost) {
        this.rewardId = rewardId;
        this.rewardName = rewardName;
        this.mileCost = mileCost;
    }

    //region Accessor
    @Id
    @SequenceGenerator(name = "REWARD_SEQ", sequenceName = "hr.REWARD_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "REWARD_SEQ")
    @Column(name="REWARD_ID")
    public long getRewardId() {
        return rewardId;
    }

    @Column(name="REWARD_NAME")
    public String getRewardName() {
        return rewardName;
    }

    @Column(name="MILES_COST")
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


