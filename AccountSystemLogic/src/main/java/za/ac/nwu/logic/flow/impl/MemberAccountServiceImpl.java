package za.ac.nwu.logic.flow.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.domain.dto.MemberAccountDto;
import za.ac.nwu.domain.persistence.MemberAccount;
import za.ac.nwu.logic.flow.MemberAccountService;
import za.ac.nwu.repo.persistence.MemberAccountRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Component
public class MemberAccountServiceImpl implements MemberAccountService {
    private MemberAccountRepository memberAccountRepository;

    @Autowired
    public MemberAccountServiceImpl(MemberAccountRepository memberAccountRepository){
        this.memberAccountRepository = memberAccountRepository;
    }

    @Override
    public List<MemberAccountDto> getAllAccounts() {
        List<MemberAccountDto> memberAccountDtos = new ArrayList<>();
        try {
//            for (MemberAccount memberAccount : memberAccountRepository.findAll()) {
//                memberAccountDtos.add(new MemberAccountDto(memberAccount));
//            }
            //            for (MemberAccount memberAccount : memberAccountRepository.findAll()) {
//                memberAccountDtos.add(new MemberAccountDto(memberAccount));
//            }
            memberAccountDtos.add(new MemberAccountDto(memberAccountRepository.getTest()));
        }
        catch (Exception e){
            throw new RuntimeException("Unable to read from DB", e);
        }
        return memberAccountDtos;
    }
}
