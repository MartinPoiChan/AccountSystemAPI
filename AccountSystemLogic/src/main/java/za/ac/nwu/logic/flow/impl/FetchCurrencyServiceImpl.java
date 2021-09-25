package za.ac.nwu.logic.flow.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.domain.dto.CurrencyDto;
import za.ac.nwu.domain.persistence.Currency;
import za.ac.nwu.logic.flow.FetchCurrencyService;
import za.ac.nwu.repo.persistence.CurrencyRepository;
import za.ac.nwu.translator.CurrencyTranslator;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Component
public class FetchCurrencyServiceImpl implements FetchCurrencyService {

    private CurrencyRepository currencyRepository;

    @Autowired
    public FetchCurrencyServiceImpl(CurrencyRepository currencyRepository){
        this.currencyRepository = currencyRepository;
    }

    @Override
    public List<CurrencyDto> getAllCurrencies() {
        List<CurrencyDto> currencyDtos = new ArrayList<>();
        try {
            for (Currency currency : currencyRepository.findAll()) {
                currencyDtos.add(new CurrencyDto(currency));
            }
        }
        catch (Exception e){
            throw new RuntimeException("Unable to read from DB", e);
        }
        return currencyDtos;
    }
}
