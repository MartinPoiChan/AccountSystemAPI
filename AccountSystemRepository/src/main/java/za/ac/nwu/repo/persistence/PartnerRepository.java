package za.ac.nwu.repo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import za.ac.nwu.domain.persistence.MemberAccount;
import za.ac.nwu.domain.persistence.Partner;

@Repository
public interface PartnerRepository extends JpaRepository<Partner, Long> {
    @Query(value = "SELECT * FROM hr.PARTNER WHERE PARTNER_ID = :id", nativeQuery = true)
    Partner getOne(long id);

}