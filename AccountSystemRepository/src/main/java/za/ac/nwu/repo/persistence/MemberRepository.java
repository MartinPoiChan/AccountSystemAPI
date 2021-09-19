package za.ac.nwu.repo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.nwu.domain.persistence.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Member findByMemberId(long memberId);
    Member findFirstByMemberId(long memberId);
}