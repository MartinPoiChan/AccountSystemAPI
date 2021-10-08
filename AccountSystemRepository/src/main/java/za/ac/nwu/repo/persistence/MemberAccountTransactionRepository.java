package za.ac.nwu.repo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import za.ac.nwu.domain.persistence.MemberAccount;
import za.ac.nwu.domain.persistence.MemberAccountTransaction;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface MemberAccountTransactionRepository extends JpaRepository<MemberAccountTransaction, Long> {
    MemberAccountTransaction findByTransactionId(long transactionId);

    @Query(value = "SELECT * FROM hr.MEMBER_ACCOUNT_TRANSACTION WHERE ACCOUNT_ID = :id", nativeQuery = true)
    List<MemberAccountTransaction> getAllOfAccount(long id);

}