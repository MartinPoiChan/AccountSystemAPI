package za.ac.nwu.translator;

import za.ac.nwu.domain.dto.MemberAccountTransactionDto;

import java.util.List;

public interface MemberAccountTransactionTranslator {
    List<MemberAccountTransactionDto> getAllTransactions();
}
