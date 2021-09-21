package za.ac.nwu.domain.dto;

import za.ac.nwu.domain.persistence.Reward;

import java.io.Serializable;

public class RewardDto implements Serializable {

    private static final long serialVersionUID = -8954717361700421623L;

    private String rewardName;
    private long mileCost;

    public RewardDto(String rewardName, long mileCost) {
        this.rewardName = rewardName;
        this.mileCost = mileCost;
    }

    public RewardDto(Reward reward) {
        this.setRewardName(reward.getRewardName());
        this.setMileCost(reward.getMileCost());
    }

    //region Accessor

    public String getRewardName() {
        return rewardName;
    }

    public long getMileCost() {
        return mileCost;
    }

    //endregion

    //region Mutator

    public void setRewardName(String rewardName) {
        this.rewardName = rewardName;
    }

    public void setMileCost(long mileCost) {
        this.mileCost = mileCost;
    }

    //endregion


    //region Accessor

    //endregion

    //region Mutator

    //endregion
}
