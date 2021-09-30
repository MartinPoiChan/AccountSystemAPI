package za.ac.nwu.logic.flow.impl;

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
        }
        catch (Exception e){
            throw new RuntimeException("Unable to read from DB", e);
        }
        return memberAccountDtos;
    }

    @Override
    public List<MemberAccountFiatDto> getFiat(Long id) {
        List<MemberAccountFiatDto> memberAccountFiatDtos = new ArrayList<>();
        try {
            memberAccountFiatDtos.add(new MemberAccountFiatDto(memberAccountRepository.getFiat(id)));
        } catch (Exception e) {
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
        } catch (Exception e) {
            throw new RuntimeException("Unable to read from DB", e);
        }
        return memberAccountDto;
    }
}
