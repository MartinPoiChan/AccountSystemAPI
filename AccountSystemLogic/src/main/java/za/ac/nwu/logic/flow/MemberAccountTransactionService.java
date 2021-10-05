package za.ac.nwu.logic.flow;

import za.ac.nwu.domain.dto.MemberAccountTransactionAdditionCreateDto;
import za.ac.nwu.domain.dto.MemberAccountTransactionCreateDto;
import za.ac.nwu.domain.dto.MemberAccountTransactionDto;
import za.ac.nwu.domain.exceptions.CustomExceptionAdd;

import java.time.LocalDate;
import java.util.List;

public interface MemberAccountTransactionService {
    List<MemberAccountTransactionDto> getAllTransactions();

    MemberAccountTransactionDto createSubtractTransactions(MemberAccountTransactionCreateDto memberAccountTransactionCreateDto);

    MemberAccountTransactionDto createAdditionTransactions(MemberAccountTransactionAdditionCreateDto memberAccountTransactionAdditionCreateDto);

//    MemberAccountTransactionDto createTransactions(MemberAccountTransactionDto memberAccountTransaction);
}
