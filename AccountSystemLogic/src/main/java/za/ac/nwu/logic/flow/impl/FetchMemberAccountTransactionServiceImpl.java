package za.ac.nwu.logic.flow.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.domain.dto.MemberAccountTransactionDto;
import za.ac.nwu.logic.flow.FetchMemberAccountTransactionService;
import za.ac.nwu.translator.MemberAccountTransactionTranslator;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Component
public class FetchMemberAccountTransactionServiceImpl implements FetchMemberAccountTransactionService {

    private MemberAccountTransactionTranslator memberAccountTransactionTranslator;

    @Autowired
    public FetchMemberAccountTransactionServiceImpl(MemberAccountTransactionTranslator memberAccountTransactionTranslator){
        this.memberAccountTransactionTranslator = memberAccountTransactionTranslator;
    }

    @Override
    public List<MemberAccountTransactionDto> getAllTransactions(){
        return memberAccountTransactionTranslator.getAllTransactions();
    }
}
