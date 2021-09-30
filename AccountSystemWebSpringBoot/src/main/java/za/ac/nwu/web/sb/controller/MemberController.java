package za.ac.nwu.web.sb.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.ac.nwu.domain.dto.MemberDto;
import za.ac.nwu.domain.service.GeneralResponse;
import za.ac.nwu.logic.flow.MemberService;

import java.util.List;

@RestController
@RequestMapping("member")
public class MemberController {
    private MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }
    @GetMapping("/getAllCurrency")
    @ApiOperation(value = "Echo the Ping.", notes = "This echo the ping back to the client")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The Currency", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
    public ResponseEntity<GeneralResponse<List<MemberDto>>> getAllRewards() {
        List<MemberDto>member = memberService.getAllMember();
        GeneralResponse<List<MemberDto>> response = new GeneralResponse<>(true, member);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
