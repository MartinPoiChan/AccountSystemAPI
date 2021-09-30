package za.ac.nwu.web.sb.controller;


import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import oracle.jdbc.proxy.annotation.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.nwu.domain.dto.CurrencyDto;
import za.ac.nwu.domain.dto.MemberAccountDto;
import za.ac.nwu.domain.dto.MemberAccountFiatDto;
import za.ac.nwu.domain.service.GeneralResponse;
import za.ac.nwu.logic.flow.CurrencyService;
import za.ac.nwu.logic.flow.MemberAccountService;

import java.util.List;

@RestController
@RequestMapping("memberAccount")
public class MemberAccountController {
    private MemberAccountService memberAccountService;

    @Autowired
    public MemberAccountController(MemberAccountService memberAccountService){
        this.memberAccountService = memberAccountService;
    }

    @GetMapping("getAllMemberInfo/{id}")
    @ApiOperation(value = "Echo the Ping.", notes = "This echo the ping back to the client")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The Currency", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
    public ResponseEntity<GeneralResponse<MemberAccountDto>> getAll(
        @ApiParam(value = "Request body to request member ID",example = "1", name = "id", required = true)
        @PathVariable("id") long id) {
        MemberAccountDto memberAccountDtos = memberAccountService.getOne(id);
        GeneralResponse<MemberAccountDto> response = new GeneralResponse<>(true, memberAccountDtos);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("getFiat/{id}")
    @ApiOperation(value = "Echo the Ping.", notes = "This echo the ping back to the client")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The Currency", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
    public ResponseEntity<GeneralResponse<List<MemberAccountFiatDto>>> getFiat(
            @ApiParam(value = "Request body to request member ID",example = "1", name = "id", required = true)
            @PathVariable("id") long id) {
            List<MemberAccountFiatDto> memberAccountFiatDto = memberAccountService.getFiat(id);
            GeneralResponse<List<MemberAccountFiatDto>> response = new GeneralResponse<>(true, memberAccountFiatDto);
            return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("updateCurrency/{id}/{cid}")
    @ApiOperation(value = "Echo the Ping.", notes = "This echo the ping back to the client")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The Currency", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
    public ResponseEntity<GeneralResponse<MemberAccountDto>>updateCurrency(
            @ApiParam(value = "Request body to update member ID",example = "1", name = "id", required = true)
            @PathVariable("id") long id,
            @ApiParam(value = "Request body to update currency ID",example = "1", name = "cid", required = true)
            @PathVariable("cid") long cid){
            MemberAccountDto memberAccountDto = memberAccountService.updateCurrency(id,cid);
            GeneralResponse<MemberAccountDto> response = new GeneralResponse<>(true, memberAccountDto);
            return new ResponseEntity<>(response, HttpStatus.OK);
    }


}
