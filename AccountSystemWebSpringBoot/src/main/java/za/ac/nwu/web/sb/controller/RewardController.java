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
import za.ac.nwu.domain.dto.CurrencyDto;
import za.ac.nwu.domain.dto.RewardDto;
import za.ac.nwu.domain.service.GeneralResponse;
import za.ac.nwu.logic.flow.RewardService;

import java.util.List;

@RestController
@RequestMapping("reward")
public class RewardController {
    private RewardService rewardService;

    @Autowired
    public RewardController(RewardService rewardService){
        this.rewardService = rewardService;
    }

    @GetMapping("/getAllCurrency")
    @ApiOperation(value = "Echo the Ping.", notes = "This echo the ping back to the client")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The Currency", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
    public ResponseEntity<GeneralResponse<List<RewardDto>>> getAllRewards() {
        List<RewardDto>currencyType = rewardService.getAllRewards();
        GeneralResponse<List<RewardDto>> response = new GeneralResponse<>(true, currencyType);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
