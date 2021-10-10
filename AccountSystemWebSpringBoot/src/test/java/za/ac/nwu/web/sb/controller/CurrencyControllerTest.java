package za.ac.nwu.web.sb.controller;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import za.ac.nwu.domain.dto.CurrencyDto;
import za.ac.nwu.logic.flow.CurrencyService;
import za.ac.nwu.logic.flow.impl.CurrencyServiceImpl;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CurrencyControllerTest {

    private static final String APP_URL = "/account-system/mvc";
    private static final String ACCOUNT_CURRENCY_URL = APP_URL + "/currency";

    @Mock
    private CurrencyService currencyService;

    @InjectMocks
    private CurrencyController currencyController;

    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(currencyController).build();
    }

    @Test
    public void getOneCurrencyTest() throws Exception{
        String expectedResponse = "{" + "\"successful\":true," + "\"payload\":{" +"\"currencyName\":\"TEST_1\"," + "\"milesConv\":999" + "}" + "}";
        CurrencyDto currencyDtos = new CurrencyDto("TEST_1", 999);
        when(currencyService.getOneCurrency(1)).thenReturn(currencyDtos);

        MvcResult mvcResult = mockMvc.perform(get((String.format("%s/%s",
                        ACCOUNT_CURRENCY_URL, "oneCurrency/1")))
                        .servletPath(APP_URL)
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        assertEquals(expectedResponse, mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void getAllTest() throws Exception{
        String expectedResponse = "{\"successful\":true,\"payload\":[{\"currencyName\":\"TEST_1\",\"milesConv\":111},{\"currencyName\":\"TEST_2\",\"milesConv\":222}]}";
        List<CurrencyDto> currencyDtos = new ArrayList<>();
        currencyDtos.add(new CurrencyDto("TEST_1",111));
        currencyDtos.add(new CurrencyDto("TEST_2",222));
        when(currencyService.getAllCurrencies()).thenReturn(currencyDtos);

        MvcResult mvcResult = mockMvc.perform(get((String.format("%s/%s",
                        ACCOUNT_CURRENCY_URL, "getAllCurrency")))
                        .servletPath(APP_URL)
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        assertEquals(expectedResponse, mvcResult.getResponse().getContentAsString());
    }

//    @Test
//    public void createTest() throws Exception{
//        String expectedResponse = "{\"successful\":true,\"payload\":{\"currencyName\":\"TEST_1\",\"milesConv\":111}}";
//        CurrencyDto currencyDtos = new CurrencyDto("TEST_1",111);
//        when(currencyService.createCurrency(currencyDtos)).thenReturn(currencyDtos);
//
//        MvcResult mvcResult = mockMvc.perform(get((String.format("%s/%s",
//                        ACCOUNT_CURRENCY_URL, "createCurrency")))
//                        .servletPath(APP_URL)
//                        .accept(MediaType.APPLICATION_JSON)
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andReturn();
//
//        assertEquals(expectedResponse, mvcResult.getResponse().getContentAsString());
//    }
//    //Create Still Needs To Be Done.
}