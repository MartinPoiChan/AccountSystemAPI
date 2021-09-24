package za.ac.nwu.logic.flow.impl;

import org.springframework.stereotype.Component;
import za.ac.nwu.domain.dto.CurrencyDto;
import za.ac.nwu.logic.flow.CreateCurrencyService;
import za.ac.nwu.translator.CurrencyTranslator;

import javax.transaction.Transactional;

@Transactional
@Component
public class CreateCurrencyServiceImpl implements CreateCurrencyService {

    private final CurrencyTranslator currencyTranslator;

    public CreateCurrencyServiceImpl(CurrencyTranslator currencyTranslator){
        this.currencyTranslator = currencyTranslator;
    }

    @Override
    public CurrencyDto create(CurrencyDto currency)
    {
        return currencyTranslator.create(currency);
    }

}
