package za.ac.nwu.logic.flow.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.domain.dto.MemberAccountTransactionCreateDto;
import za.ac.nwu.domain.dto.MemberAccountTransactionDto;
import za.ac.nwu.domain.persistence.MemberAccount;
import za.ac.nwu.domain.persistence.MemberAccountTransaction;
import za.ac.nwu.domain.persistence.Partner;
import za.ac.nwu.logic.flow.MemberAccountTransactionService;
import za.ac.nwu.logic.flow.PartnerService;
import za.ac.nwu.repo.persistence.MemberAccountTransactionRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Component
public class MemberAccountTransactionServiceImpl implements MemberAccountTransactionService {

    private MemberAccountTransactionRepository memberAccountTransactionRepository;
    private PartnerServiceImpl partnerServiceImpl;
    private MemberAccountServiceImpl memberAccountServiceImpl;

    @Autowired
    public MemberAccountTransactionServiceImpl(MemberAccountTransactionRepository memberAccountTransactionRepository, PartnerServiceImpl partnerServiceImpl, MemberAccountServiceImpl memberAccountServiceImpl){
        this.memberAccountTransactionRepository = memberAccountTransactionRepository;
        this.partnerServiceImpl = partnerServiceImpl;
        this.memberAccountServiceImpl = memberAccountServiceImpl;

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

    @Override
    public MemberAccountTransactionDto createTransactions(MemberAccountTransactionCreateDto memberAccountTransactionCreateDto){
            MemberAccountTransaction transaction;
        try{
            //Create a constructor that accepts a DTO param to convert a dto to entity
            long pid = memberAccountTransactionCreateDto.getPartnerId();
            Partner partner = new Partner(partnerServiceImpl.getOnePartner(pid));
            partner.setPartnerId(memberAccountTransactionCreateDto.getPartnerId());

            MemberAccount memberAccount = new MemberAccount(memberAccountServiceImpl.getOne(memberAccountTransactionCreateDto.getAccountId()));
            memberAccount.setAccountId(memberAccountTransactionCreateDto.getAccountId());

            transaction = new MemberAccountTransaction(memberAccountTransactionCreateDto);
            transaction.setPartnerId(partner);
            transaction.setAccountId(memberAccount);
            transaction = memberAccountTransactionRepository.save(transaction);
            return new MemberAccountTransactionDto(transaction);
        }
        catch (Exception e){
            throw new RuntimeException("Unable to read to DB", e);
        }
    }
}
