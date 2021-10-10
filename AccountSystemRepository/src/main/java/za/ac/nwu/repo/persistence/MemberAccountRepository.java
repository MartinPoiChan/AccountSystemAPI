package za.ac.nwu.repo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import za.ac.nwu.domain.dto.MemberAccountFiatDto;
import za.ac.nwu.domain.persistence.Currency;
import za.ac.nwu.domain.persistence.MemberAccount;
@Repository
public interface MemberAccountRepository extends JpaRepository<MemberAccount, Long> {
    @Query(value = "SELECT ACCOUNT_ID,MEMBER_ID,MILES_BALANCE,PLAYS,CURRENCY_ID FROM hr.MEMBER_ACCOUNT WHERE MEMBER_ID = :id", nativeQuery = true)
    MemberAccount getOne(long id);

    @Query(value = "SELECT ACCOUNT_ID,MEMBER_ID,MILES_BALANCE,PLAYS,CURRENCY_ID FROM hr.MEMBER_ACCOUNT WHERE MEMBER_ID = :id", nativeQuery = true)
    MemberAccount getFiat(long id);

}


//    UPDATE table_name
//    SET column1 = value1, column2 = value2, ...
//        WHERE condition;