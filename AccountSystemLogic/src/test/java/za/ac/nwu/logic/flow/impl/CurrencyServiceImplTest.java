package za.ac.nwu.logic.flow.impl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import za.ac.nwu.domain.dto.CurrencyDto;
import za.ac.nwu.domain.dto.MemberAccountTransactionDto;
import za.ac.nwu.domain.service.GeneralResponse;
import za.ac.nwu.repo.persistence.CurrencyRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CurrencyServiceImplTest {

    private CurrencyServiceImpl testClass;
    private CurrencyServiceImpl currencyimpl;

    @Before
    public void setUp() throws Exception {
        testClass = new CurrencyServiceImpl(null);
    }

    @After
    public void tearDown() throws Exception {
        testClass = null;
    }

//    @Test
//    public void getAllCurrencies() {
//        CurrencyDto currencyDtos;
//        CurrencyDto expected = null;
//        expected.setCurrencyId(1);
//        expected.setCurrencyName("Swap");
//        expected.setMilesConv(9999);
//        currencyDtos = testClass.getOne(1);
//
//        GeneralResponse<CurrencyDto> exp = new GeneralResponse<>(true, expected);
//        GeneralResponse<CurrencyDto> act = new GeneralResponse<>(true, currencyDtos);
//
//        assertNotNull("Should not be null", currencyDtos);
//        assertEquals(exp, act);
//    }
}