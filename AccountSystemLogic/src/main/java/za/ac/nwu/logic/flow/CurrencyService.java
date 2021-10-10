package za.ac.nwu.logic.flow;

import za.ac.nwu.domain.dto.CurrencyDto;

import java.util.List;

public interface CurrencyService {
    List<CurrencyDto> getAllCurrencies();

    CurrencyDto getOneCurrency(long id);

    CurrencyDto createCurrency(CurrencyDto currencyDto);
}
