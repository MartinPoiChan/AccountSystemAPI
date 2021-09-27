package za.ac.nwu.repo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import za.ac.nwu.domain.persistence.Currency;
import za.ac.nwu.domain.persistence.MemberAccount;
@Repository
public interface MemberAccountRepository extends JpaRepository<MemberAccount, Long> {
    @Query(value = "SELECT "+"ACCOUNT_ID,"+"MEMBER_ID,"+"MILES_BALANCE "+" FROM "+"hr.MEMBER_ACCOUNT "+"WHERE MEMBER_ID = 1", nativeQuery = true)
    MemberAccount getTest();
}