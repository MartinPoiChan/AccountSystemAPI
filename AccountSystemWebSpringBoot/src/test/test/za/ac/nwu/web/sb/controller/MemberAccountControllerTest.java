package za.ac.nwu.web.sb.controller;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import za.ac.nwu.domain.dto.CurrencyDto;
import za.ac.nwu.domain.dto.MemberAccountDto;
import za.ac.nwu.domain.dto.MemberAccountFiatDto;
import za.ac.nwu.domain.persistence.Currency;
import za.ac.nwu.domain.persistence.Member;
import za.ac.nwu.domain.persistence.MemberAccount;
import za.ac.nwu.logic.flow.CurrencyService;
import za.ac.nwu.logic.flow.MemberAccountService;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MemberAccountControllerTest {

    @Test
    public void getOneMemberTest() throws Exception {
    }

    private static final String APP_URL = "/account-system/mvc";
    private static final String ACCOUNT_CURRENCY_URL = APP_URL + "/memberAccount";

    @Mock
    private MemberAccountService memberAccountService;

    @InjectMocks
    private MemberAccountController memberAccountController;
    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(memberAccountController).build();
    }

    @Test
    public void getOneTest() throws Exception{
        String expectedResponse = "{\"successful\":true,\"payload\":{\"memberId\":{\"memberId\":1,\"firstName\":\"Carl\",\"lastName\":\"Peter\",\"email\":\"cp@email.com\",\"phoneNum\":\"073-789-4561\"},\"milesBalance\":1400,\"plays\":5,\"currencyId\":{\"currencyId\":42,\"currencyName\":\"nodejs\",\"milesConv\":420}}}";
        Member member = new Member(1, "Carl", "Peter", "cp@email.com", "073-789-4561");
        Currency currency = new Currency(42, "nodejs", 420);
        MemberAccountDto memberAccount = new MemberAccountDto(member, 1400,5,currency);

        when(memberAccountService.getOne(1)).thenReturn(memberAccount);
        MvcResult mvcResult = mockMvc.perform(get((String.format("%s/%s", ACCOUNT_CURRENCY_URL, "getAllMemberInfo/1")))
                        .servletPath(APP_URL)
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        assertEquals(expectedResponse, mvcResult.getResponse().getContentAsString());
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getFiatTest() throws Exception{
        String expectedResponse = "{\"successful\":true,\"payload\":{\"memberId\":{\"memberId\":1,\"firstName\":\"Carl\",\"lastName\":\"Peter\",\"email\":\"cp@email.com\",\"phoneNum\":\"073-789-4561\"},\"milesBalance\":1400,\"currency\":{\"currencyId\":42,\"currencyName\":\"nodejs\",\"milesConv\":420},\"fiat\":588000}}";
        Member member = new Member(1, "Carl", "Peter", "cp@email.com", "073-789-4561");
        Currency currency = new Currency(42, "nodejs", 420);
        MemberAccountFiatDto memberAccountFiatDto = new MemberAccountFiatDto(member, 1400,currency,588000);

        when(memberAccountService.getFiat(1L)).thenReturn(memberAccountFiatDto);
        MvcResult mvcResult = mockMvc.perform(get((String.format("%s/%s", ACCOUNT_CURRENCY_URL, "getFiat/1")))
                        .servletPath(APP_URL)
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        assertEquals(expectedResponse, mvcResult.getResponse().getContentAsString());
    }
}
