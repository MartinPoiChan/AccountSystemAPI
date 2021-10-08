package za.ac.nwu.logic.flow.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.domain.dto.MemberDto;
import za.ac.nwu.domain.persistence.Member;
import za.ac.nwu.logic.flow.MemberService;
import za.ac.nwu.repo.persistence.MemberRepository;


import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Component
public class MemberServiceImpl implements MemberService {
    private static final Logger LOGGER = LoggerFactory.getLogger(MemberServiceImpl.class);
    private MemberRepository memberRepository;

    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository){
        this.memberRepository =memberRepository;
    }

    @Override
    public List<MemberDto> getAllMember() {
        List<MemberDto> memberDtos = new ArrayList<>();
        try {
            for (Member member : memberRepository.findAll()) {
                memberDtos.add(new MemberDto(member));
            }
            if(LOGGER.isInfoEnabled()){
                LOGGER.info("Transaction has failed, all changes have been rolled back.");
            }
        }
        catch (Exception e){
            if(LOGGER.isWarnEnabled()){
                LOGGER.warn("Transaction has failed, all changes have been rolled back.");
            }
            throw new RuntimeException("Unable to read from DB", e);
        }
        return memberDtos;
    }
}
