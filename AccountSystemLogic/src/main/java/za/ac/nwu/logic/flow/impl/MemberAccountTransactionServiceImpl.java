package za.ac.nwu.logic.flow.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.domain.dto.MemberAccountTransactionAdditionCreateDto;
import za.ac.nwu.domain.dto.MemberAccountTransactionCreateDto;
import za.ac.nwu.domain.dto.MemberAccountTransactionDto;
import za.ac.nwu.domain.exceptions.CustomExceptionAdd;
import za.ac.nwu.domain.persistence.MemberAccount;
import za.ac.nwu.domain.persistence.MemberAccountTransaction;
import za.ac.nwu.domain.persistence.Partner;
import za.ac.nwu.logic.flow.MemberAccountTransactionService;
import za.ac.nwu.repo.persistence.MemberAccountRepository;
import za.ac.nwu.repo.persistence.MemberAccountTransactionRepository;
import za.ac.nwu.repo.persistence.PartnerRepository;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Component
public class MemberAccountTransactionServiceImpl implements MemberAccountTransactionService {

    private MemberAccountTransactionRepository memberAccountTransactionRepository;
    private PartnerServiceImpl partnerServiceImpl;
    private MemberAccountServiceImpl memberAccountServiceImpl;
    private MemberAccountRepository memberAccountRepository;
    private PartnerRepository partnerRepository;
    @Autowired
    public MemberAccountTransactionServiceImpl(MemberAccountTransactionRepository memberAccountTransactionRepository,
                                               PartnerServiceImpl partnerServiceImpl,
                                               MemberAccountServiceImpl memberAccountServiceImpl,
                                               MemberAccountRepository memberAccountRepository,
                                               PartnerRepository partnerRepository){
        this.memberAccountTransactionRepository = memberAccountTransactionRepository;
        this.partnerServiceImpl = partnerServiceImpl;
        this.memberAccountServiceImpl = memberAccountServiceImpl;
        this.memberAccountRepository = memberAccountRepository;
        this.partnerRepository = partnerRepository;
    }

    @Override
    public MemberAccountTransactionDto createSubtractTransactions(MemberAccountTransactionCreateDto memberAccountTransactionCreateDto){
            MemberAccountTransaction transaction;
        try{
            //Create a constructor that accepts a DTO param to convert a dto to entity
            long pid = memberAccountTransactionCreateDto.getPartnerId();
            Partner partner = new Partner(partnerServiceImpl.getOnePartner(pid));
            partner.setPartnerId(memberAccountTransactionCreateDto.getPartnerId());

            MemberAccount memberAccount = new MemberAccount(memberAccountServiceImpl.getOne(memberAccountTransactionCreateDto.getAccountId()));
            memberAccount.setAccountId(memberAccountTransactionCreateDto.getAccountId());

            long balance = memberAccount.getMilesBalance();
            transaction = new MemberAccountTransaction(memberAccountTransactionCreateDto);
            transaction.setPartnerId(partner);
            transaction.setAccountId(memberAccount);
            transaction.setOldBalance(balance);
            memberAccount.setMilesBalance(balance-memberAccountTransactionCreateDto.getAmount());
            memberAccount = memberAccountRepository.save(memberAccount);
            transaction = memberAccountTransactionRepository.save(transaction);

            return new MemberAccountTransactionDto(transaction);
        }
        catch (Exception e){
            throw new RuntimeException("Unable to read to DB", e);
        }
    }

    @Override
    public MemberAccountTransactionDto createAdditionTransactions(MemberAccountTransactionAdditionCreateDto memberAccountTransactionAdditionCreateDto) {
        MemberAccountTransaction transaction;
        boolean flag = memberAccountTransactionAdditionCreateDto.isFlag();
        try{
            if (flag)
                throw new CustomExceptionAdd();                   
            if(null == memberAccountTransactionAdditionCreateDto.getTransactionDate())
                memberAccountTransactionAdditionCreateDto.setTransactionDate(LocalDate.now());

            Partner partner = new Partner(partnerRepository.getDiscovery());
            MemberAccount memberAccount = new MemberAccount(memberAccountServiceImpl.getOne(memberAccountTransactionAdditionCreateDto.getAccountId()));
            memberAccount.setAccountId(memberAccountTransactionAdditionCreateDto.getAccountId());
            long balance = memberAccount.getMilesBalance();

            transaction = new MemberAccountTransaction(memberAccountTransactionAdditionCreateDto);
            transaction.setPartnerId(partner);
            transaction.setAccountId(memberAccount);
            transaction.setOldBalance(balance);
            memberAccount.setMilesBalance(balance+memberAccountTransactionAdditionCreateDto.getAmount());
            memberAccount = memberAccountRepository.save(memberAccount);
            transaction = memberAccountTransactionRepository.save(transaction);

            return new MemberAccountTransactionDto(transaction);
        }
        catch (CustomExceptionAdd e){
            if(flag)
                throw new RuntimeException("This was flagged by the user", e);
            throw new RuntimeException("Unable to read to DB", e);
        }
    }
}
