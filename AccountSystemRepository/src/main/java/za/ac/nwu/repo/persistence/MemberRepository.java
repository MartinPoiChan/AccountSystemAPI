package za.ac.nwu.repo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.nwu.domain.persistence.Member;
@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    Member findByMemberId(long memberId);
    Member findFirstByMemberId(long memberId);
}