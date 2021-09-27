package za.ac.nwu.logic.flow.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.domain.dto.MemberAccountTransactionDto;
import za.ac.nwu.domain.persistence.MemberAccountTransaction;
import za.ac.nwu.logic.flow.MemberAccountTransactionService;
import za.ac.nwu.repo.persistence.MemberAccountTransactionRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Component
public class MemberAccountTransactionServiceImpl implements MemberAccountTransactionService {
    private MemberAccountTransactionRepository memberAccountTransactionRepository;

    @Autowired
    public MemberAccountTransactionServiceImpl(MemberAccountTransactionRepository memberAccountTransactionRepository){
        this.memberAccountTransactionRepository = memberAccountTransactionRepository;
    }

    @Override
    public List<MemberAccountTransactionDto> getAllTransactions(){
        List<MemberAccountTransactionDto> memberAccountTransactionDtos = new ArrayList<>();
        try{
            for (MemberAccountTransaction memberAccountTransaction : memberAccountTransactionRepository.findAll()) {
                memberAccountTransactionDtos.add(new MemberAccountTransactionDto(memberAccountTransaction));
            }
        }
        catch (Exception e){
            throw new RuntimeException("Unable to read to DB", e);
        }
        return memberAccountTransactionDtos;
    }
}
