package za.ac.nwu.repo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.nwu.domain.persistence.MemberAccountTransaction;
@Repository
public interface MemberAccountTransactionRepository extends JpaRepository<MemberAccountTransaction, Long> {
    MemberAccountTransaction findByTransactionId(long transactionId);
}