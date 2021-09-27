package za.ac.nwu.logic.flow.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.domain.dto.RewardDto;
import za.ac.nwu.domain.persistence.Reward;
import za.ac.nwu.logic.flow.RewardService;
import za.ac.nwu.repo.persistence.RewardRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Component
public class RewardServiceImpl implements RewardService {
    private RewardRepository rewardRepository;

    @Autowired
    public RewardServiceImpl(RewardRepository rewardRepository){
        this.rewardRepository =rewardRepository;
    }

    @Override
    public List<RewardDto> getAllRewards() {
        List<RewardDto> rewardDtos = new ArrayList<>();
        try {
            for (Reward reward : rewardRepository.findAll()) {
                rewardDtos.add(new RewardDto(reward));
            }
        }
        catch (Exception e){
            throw new RuntimeException("Unable to read from DB", e);
        }
        return rewardDtos;
    }
}
