package za.ac.nwu.web.sb.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.nwu.domain.dto.CurrencyDto;
import za.ac.nwu.domain.service.GeneralResponse;
import za.ac.nwu.logic.flow.CreateCurrencyService;
import za.ac.nwu.logic.flow.FetchCurrencyService;

import java.util.List;

@RestController
@RequestMapping("account-type")
public class DemoController {

    private FetchCurrencyService fetchCurrencyService;
    private CreateCurrencyService createCurrencyService;

    @Autowired
    public DemoController(FetchCurrencyService fetchCurrencyService, CreateCurrencyService createCurrencyService){
        this.fetchCurrencyService = fetchCurrencyService;
        this.createCurrencyService = createCurrencyService;
    }

    @GetMapping("/getAllCurrency")
    @ApiOperation(value = "Echo the Ping.", notes = "This echo the ping back to the client")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The Currency", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})

    public ResponseEntity<GeneralResponse<List<CurrencyDto>>> getAllCurrency() {
        List<CurrencyDto>currencyType = fetchCurrencyService.getAllCurrencies();
        GeneralResponse<List<CurrencyDto>> response = new GeneralResponse<>(true, currencyType);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("")
    @ApiOperation(value = "Echo the Ping.", notes = "This echo the ping back to the client")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "The Currency was added successfully", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})

    public ResponseEntity<GeneralResponse<CurrencyDto>> create(
            @ApiParam(value = "Request body to create a new Currency", required = true)
            @RequestBody CurrencyDto currency) {

            CurrencyDto currencyResponse = createCurrencyService.create(currency);
            GeneralResponse<CurrencyDto> response = new GeneralResponse<>(true, currencyResponse);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}


