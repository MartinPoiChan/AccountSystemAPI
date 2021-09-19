package za.ac.nwu.repo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.nwu.domain.persistence.MemberAccountTransaction;

public interface MemberAccountTransactionRepository extends JpaRepository<MemberAccountTransaction, Long> {
    MemberAccountTransaction findByTransactionId(long transactionId);
}