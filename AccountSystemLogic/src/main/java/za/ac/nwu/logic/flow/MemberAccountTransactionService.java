package za.ac.nwu.logic.flow;

import za.ac.nwu.domain.dto.MemberAccountTransactionCreateDto;
import za.ac.nwu.domain.dto.MemberAccountTransactionDto;

import java.util.List;

public interface MemberAccountTransactionService {
    List<MemberAccountTransactionDto> getAllTransactions();

    MemberAccountTransactionDto createTransactions(MemberAccountTransactionCreateDto memberAccountTransaction);

//    MemberAccountTransactionDto createTransactions(MemberAccountTransactionDto memberAccountTransaction);
}
