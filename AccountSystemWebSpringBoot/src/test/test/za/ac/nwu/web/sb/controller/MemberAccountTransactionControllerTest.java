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
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import za.ac.nwu.logic.flow.MemberAccountService;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MemberAccountTransactionControllerTest {

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
}