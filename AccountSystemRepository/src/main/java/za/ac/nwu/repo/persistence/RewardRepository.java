package za.ac.nwu.repo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.nwu.domain.persistence.Reward;

public interface RewardRepository extends JpaRepository<Reward, Long> {
    Reward findByRewardId(long rewardId);
}