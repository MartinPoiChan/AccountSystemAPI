package za.ac.nwu.translator;
import org.springframework.data.jpa.repository.Query;
import za.ac.nwu.domain.dto.CurrencyDto;
import java.util.List;

public interface CurrencyTranslator {
    //List<CurrencyDto> getAllCurrencies();
    CurrencyDto create(CurrencyDto currencyDto);
}
