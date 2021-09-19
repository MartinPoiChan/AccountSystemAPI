package za.ac.nwu.repo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.nwu.domain.persistence.Currency;

public interface CurrencyRepository extends JpaRepository<Currency, Long> {
    Currency findByCurrencyId(long currencyId);
}