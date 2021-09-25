package za.ac.nwu.translator.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.domain.dto.CurrencyDto;
import za.ac.nwu.domain.dto.MemberAccountTransactionDto;
import za.ac.nwu.domain.persistence.Currency;
import za.ac.nwu.domain.persistence.MemberAccountTransaction;
import za.ac.nwu.repo.persistence.CurrencyRepository;
import za.ac.nwu.repo.persistence.MemberAccountTransactionRepository;
import za.ac.nwu.translator.MemberAccountTransactionTranslator;

import java.util.ArrayList;
import java.util.List;

@Component
public class MemberAccountTransactionTranslatorImpl implements MemberAccountTransactionTranslator {
    private MemberAccountTransactionRepository memberAccountTransactionRepository;

    @Autowired
    public MemberAccountTransactionTranslatorImpl(MemberAccountTransactionRepository memberAccountTransactionRepository){
        this.memberAccountTransactionRepository = memberAccountTransactionRepository;
    }
    @Override
    public List<MemberAccountTransactionDto> getAllTransactions() {
    List<MemberAccountTransactionDto> MemberAccountTransactionDtos = new ArrayList<>();
    try{
        for (MemberAccountTransaction transaction : memberAccountTransactionRepository.findAll()) {
            MemberAccountTransactionDtos.add(new MemberAccountTransactionDto(transaction));
        }
    }
    catch (Exception e){
        throw new RuntimeException("Unable to read from DB", e);
    }
    return MemberAccountTransactionDtos;
    }
}
