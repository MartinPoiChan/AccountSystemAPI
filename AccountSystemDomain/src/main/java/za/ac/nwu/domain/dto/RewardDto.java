package za.ac.nwu.domain.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import za.ac.nwu.domain.persistence.Reward;

import java.io.Serializable;
import java.util.Objects;

@ApiModel(value = "Reward", description = "A DTO for Reward")
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
    @ApiModelProperty(
            position = 1,
            value = "Reward Name",
            name = "RewardName",
            notes = "Reward Notes",
            dataType = "java.lang.String",
            example = "CapeUnion999",
            allowEmptyValue = false,
            required = true)
    public String getRewardName() {
        return rewardName;
    }

    @ApiModelProperty(
            position = 1,
            value = "Reward Cost",
            name = "RewardCost",
            notes = "Reward Notes",
            dataType = "java.lang.Long",
            example = "9999",
            allowEmptyValue = false,
            required = true)
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RewardDto rewardDto = (RewardDto) o;
        return mileCost == rewardDto.mileCost && Objects.equals(rewardName, rewardDto.rewardName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rewardName, mileCost);
    }
}
