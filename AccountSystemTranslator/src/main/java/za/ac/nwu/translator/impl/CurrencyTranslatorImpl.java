package za.ac.nwu.translator.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.domain.dto.CurrencyDto;
import za.ac.nwu.domain.persistence.Currency;
import za.ac.nwu.repo.persistence.CurrencyRepository;
import za.ac.nwu.translator.CurrencyTranslator;

import java.util.ArrayList;
import java.util.List;

@Component
public class CurrencyTranslatorImpl implements CurrencyTranslator {

    private CurrencyRepository currencyRepository;

    @Autowired
    public CurrencyTranslatorImpl(CurrencyRepository currencyRepository){
        this.currencyRepository = currencyRepository;
    }
    @Override
    public List<CurrencyDto> getAllCurrencies() {
        List<CurrencyDto> currencyDtos = new ArrayList<>();
        try{
            for(Currency currency: currencyRepository.findAll()){
                currencyDtos.add(new CurrencyDto(currency));
            }
        }
        catch (Exception e){
            throw new RuntimeException("Unable to read from DB", e);
        }
        return currencyDtos;
    }
}
