package za.ac.nwu.logic.flow.impl;

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
        }
        catch (Exception e){
            throw new RuntimeException("Unable to read from DB", e);
        }
        return memberDtos;
    }
}
