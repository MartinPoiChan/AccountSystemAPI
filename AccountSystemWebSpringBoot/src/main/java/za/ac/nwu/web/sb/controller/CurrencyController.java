package za.ac.nwu.web.sb.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.nwu.domain.dto.CurrencyDto;
import za.ac.nwu.domain.dto.MemberAccountFiatDto;
import za.ac.nwu.domain.service.GeneralResponse;
import za.ac.nwu.logic.flow.CurrencyService;

import java.util.List;

@RestController
@RequestMapping("currency")
public class CurrencyController {

    private CurrencyService currencyService;

    @Autowired
    public CurrencyController(CurrencyService currencyService){
        this.currencyService = currencyService;
    }

    @GetMapping("/getAllCurrency")
    @ApiOperation(value = "Echo the Ping.", notes = "This echo the ping back to the client")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The Currency", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})

    public ResponseEntity<GeneralResponse<List<CurrencyDto>>> getAllCurrency() {
        List<CurrencyDto>currencyType = currencyService.getAllCurrencies();
        GeneralResponse<List<CurrencyDto>> response = new GeneralResponse<>(true, currencyType);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/createCurrency")
    @ApiOperation(value = "Echo the Ping.", notes = "This echo the ping back to the client")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "The Currency was added successfully", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not found", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})

    public ResponseEntity<GeneralResponse<CurrencyDto>> create(
            @ApiParam(value = "Request body to create a new Currency", required = true)
            @RequestBody CurrencyDto currency) {

            CurrencyDto currencyResponse = currencyService.createCurrency(currency);
            GeneralResponse<CurrencyDto> response = new GeneralResponse<>(true, currencyResponse);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("oneCurrency/{id}")
    @ApiOperation(value = "Echo the Ping.", notes = "This echo the ping back to the client")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The Currency", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})

    public ResponseEntity<GeneralResponse<CurrencyDto>> getFiat(
            @ApiParam(value = "Request body to request member ID",example = "1", name = "id", required = true)
            @PathVariable("id") long id) {
        CurrencyDto currencyDto = currencyService.getOne(id);
        GeneralResponse<CurrencyDto> response = new GeneralResponse<>(true, currencyDto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}


