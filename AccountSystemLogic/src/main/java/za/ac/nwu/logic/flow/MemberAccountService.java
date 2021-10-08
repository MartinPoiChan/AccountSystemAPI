package za.ac.nwu.logic.flow;

import za.ac.nwu.domain.dto.MemberAccountDto;
import za.ac.nwu.domain.dto.MemberAccountFiatDto;

import java.util.List;

public interface MemberAccountService {
  //  List<MemberAccountDto> getAllAccounts();

    MemberAccountDto getOne(long id);

    MemberAccountFiatDto getFiat(Long id);

    MemberAccountDto updateCurrency(long id, long cid);

}
