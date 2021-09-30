package za.ac.nwu.logic.flow.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.domain.dto.CurrencyDto;
import za.ac.nwu.domain.persistence.Currency;
import za.ac.nwu.logic.flow.CurrencyService;
import za.ac.nwu.repo.persistence.CurrencyRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Component
public class CurrencyServiceImpl implements CurrencyService {
    private CurrencyRepository currencyRepository;

    @Autowired
    public CurrencyServiceImpl(CurrencyRepository currencyRepository){
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

    @Override
    public CurrencyDto getOne(long id) {
        CurrencyDto currencyDto;
        try {
            currencyDto = new CurrencyDto(currencyRepository.getOne(id));
        }
        catch (Exception e){
            throw new RuntimeException("Unable to read from DB", e);
        }
        return currencyDto;
    }

    @Override
    public CurrencyDto createCurrency(CurrencyDto currencyDto){
        try{
            Currency currency = currencyRepository.save(currencyDto.getCurrency());
            return new CurrencyDto(currency);
        }
        catch (Exception e){
            throw new RuntimeException("Unable to save to DB", e);
        }
    }
}
