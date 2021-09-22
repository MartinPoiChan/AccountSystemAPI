package za.ac.nwu.translator;
import za.ac.nwu.domain.dto.CurrencyDto;
import java.util.List;

public interface CurrencyTranslator {
    List<CurrencyDto> getAllCurrencies();
}
