package za.ac.nwu.logic.flow.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.domain.dto.CurrencyDto;
import za.ac.nwu.logic.flow.FetchCurrencyFlow;
import za.ac.nwu.translator.CurrencyTranslator;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Component
public class FetchCurrencyFlowImpl implements FetchCurrencyFlow {

    private CurrencyTranslator currencyTranslator;

    @Autowired
    public FetchCurrencyFlowImpl(CurrencyTranslator currencyTranslator) {
        this.currencyTranslator = currencyTranslator;
    }

    @Override
    public List<CurrencyDto> getAllCurrencies() {
        return currencyTranslator.getAllCurrencies();
    }
}
