package za.ac.nwu.repo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.nwu.domain.persistence.MemberAccount;

public interface MemberAccountRepository extends JpaRepository<MemberAccount, Long> {
    MemberAccount findByAccountId(long accountId);
}