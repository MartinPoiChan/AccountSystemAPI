package za.ac.nwu.logic.flow;

import za.ac.nwu.domain.dto.MemberAccountDto;

import java.util.List;

public interface MemberAccountService {
    List<MemberAccountDto> getAllAccounts();
}
