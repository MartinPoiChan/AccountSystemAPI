package za.ac.nwu.logic.flow.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private static final Logger LOGGER = LoggerFactory.getLogger(CurrencyServiceImpl.class);
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
            if(LOGGER.isInfoEnabled()) {
                LOGGER.info("Transaction was successful, all currencies have been fetched.");
            }
        }
        catch (Exception e){
            if(LOGGER.isWarnEnabled()){
                LOGGER.warn("Transaction has failed, all changes have been rolled back.");
            }
            throw new RuntimeException("Unable to read from DB", e);
        }
        return currencyDtos;
    }

    @Override
    public CurrencyDto getOneCurrency(long id) {
        CurrencyDto currencyDto;
        try {
            currencyDto = new CurrencyDto(currencyRepository.getOne(id));
            if(LOGGER.isInfoEnabled()) {
                LOGGER.info("Transaction was successful,id: {} currency has been fetched. {}",currencyDto.getCurrencyName());
            }
        }
        catch (Exception e){
            if(LOGGER.isWarnEnabled()){
                LOGGER.warn("Transaction has failed, all changes have been rolled back.");
            }
            throw new RuntimeException("Unable to read from DB", e);
        }
        return currencyDto;
    }

    @Override
    public CurrencyDto createCurrency(CurrencyDto currencyDto){
        try{
            Currency currency = currencyRepository.save(currencyDto.getCurrency());
            if(LOGGER.isInfoEnabled()) {
                LOGGER.info("Transaction was successful,id:{} currency have been created.",currencyDto.getCurrencyName());
            }
            return new CurrencyDto(currency);
        }
        catch (Exception e){
            if(LOGGER.isWarnEnabled()){
                LOGGER.warn("Transaction has failed, all changes have been rolled back.");
            }
            throw new RuntimeException("Unable to save to DB", e);
        }
    }
}
