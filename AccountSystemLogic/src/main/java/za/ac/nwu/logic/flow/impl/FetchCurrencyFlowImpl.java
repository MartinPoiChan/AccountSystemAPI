package za.ac.nwu.logic.flow.impl;

import org.springframework.stereotype.Component;
import za.ac.nwu.domain.dto.CurrencyDto;
import za.ac.nwu.logic.flow.FetchCurrencyFlow;

import java.util.ArrayList;
import java.util.List;
@Component
public class FetchCurrencyFlowImpl implements FetchCurrencyFlow {
    @Override
    public List<CurrencyDto> getAllCurrencies() {
        List<CurrencyDto> test  = new ArrayList<>();
        test.add(new CurrencyDto("ZAR", 15));
        return test;
    }
}
