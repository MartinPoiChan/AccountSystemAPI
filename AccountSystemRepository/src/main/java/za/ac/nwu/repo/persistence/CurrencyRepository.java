package za.ac.nwu.repo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.nwu.domain.persistence.Currency;

@Repository
public interface CurrencyRepository extends JpaRepository<Currency, Long> {
    Currency findByCurrencyId(long currencyId);
}