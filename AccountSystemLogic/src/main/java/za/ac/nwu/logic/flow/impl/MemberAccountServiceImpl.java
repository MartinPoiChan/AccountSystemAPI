package za.ac.nwu.logic.flow.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.domain.dto.CurrencyDto;
import za.ac.nwu.domain.dto.MemberAccountDto;
import za.ac.nwu.domain.dto.MemberAccountFiatDto;
import za.ac.nwu.domain.persistence.Currency;
import za.ac.nwu.domain.persistence.MemberAccount;
import za.ac.nwu.logic.flow.MemberAccountService;
import za.ac.nwu.repo.persistence.CurrencyRepository;
import za.ac.nwu.repo.persistence.MemberAccountRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Component
public class MemberAccountServiceImpl implements MemberAccountService {
    private static final Logger LOGGER = LoggerFactory.getLogger(MemberAccountServiceImpl.class);
    private MemberAccountRepository memberAccountRepository;
    private CurrencyRepository currencyRepository;

    @Autowired
    public MemberAccountServiceImpl(MemberAccountRepository memberAccountRepository, CurrencyRepository currencyRepository){
        this.memberAccountRepository = memberAccountRepository;
        this.currencyRepository = currencyRepository;
    }

    @Override
    public MemberAccountDto getOne(long id) {
        MemberAccountDto memberAccountDtos;
        try {
            memberAccountDtos = new MemberAccountDto(memberAccountRepository.getOne(id));
            if(LOGGER.isInfoEnabled()) {
                LOGGER.info("Transaction was successful,id: {} Member Account has been fetched.",memberAccountDtos.getMemberId());
            }
        }
        catch (Exception e){
            if(LOGGER.isWarnEnabled()){
                LOGGER.warn("Transaction has failed, all changes have been rolled back.");
            }
            throw new RuntimeException("Unable to read from DB", e);
        }
        return memberAccountDtos;
    }

    @Override
    public MemberAccountFiatDto getFiat(Long id) {
        MemberAccountFiatDto memberAccountFiatDtos = null;
        try {
            memberAccountFiatDtos = new MemberAccountFiatDto(memberAccountRepository.getFiat(id));
            if(LOGGER.isInfoEnabled()) {
                LOGGER.info("Transaction was successful,id: {} Member Account with fiat value has been fetched.",memberAccountFiatDtos.getMemberId());
            }
        } catch (Exception e) {
            if(LOGGER.isWarnEnabled()){
                LOGGER.warn("Transaction has failed, all changes have been rolled back.");
            }
            throw new RuntimeException("Unable to read from DB", e);
        }
        return memberAccountFiatDtos;
    }

    @Override
    public MemberAccountDto updateCurrency(long id, long cid) {
        MemberAccountDto memberAccountDto;
        MemberAccount memberAccount;
        try {
            memberAccountDto = new MemberAccountDto(memberAccountRepository.getOne(id));
            memberAccountDto.setCurrencyId(currencyRepository.getOne(cid));
            memberAccount = new MemberAccount(memberAccountDto);
            memberAccount.setAccountId(id);
            memberAccountRepository.save(memberAccount);
            if(LOGGER.isInfoEnabled()) {
                LOGGER.info("Transaction was successful,id: {} Member Account was saved.",memberAccount.getMemberId());
            }
        } catch (Exception e) {
            if(LOGGER.isWarnEnabled()){
                LOGGER.warn("Transaction has failed, all changes have been rolled back.");
            }
            throw new RuntimeException("Unable to read from DB", e);
        }
        return memberAccountDto;
    }
}
