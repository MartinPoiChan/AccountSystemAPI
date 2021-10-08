package za.ac.nwu.web.sb.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.ac.nwu.domain.dto.PartnerDto;
import za.ac.nwu.domain.service.GeneralResponse;
import za.ac.nwu.logic.flow.PartnerService;

import java.util.List;

@RestController
@RequestMapping("reward")
public class PartnerController {
    private PartnerService partnerService;

    @Autowired
    public PartnerController(PartnerService partnerService){
        this.partnerService = partnerService;
    }

    @GetMapping("/getPartner/{id}")
    @ApiOperation(value = "Echo the Ping.", notes = "This echo the ping back to the client")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The Currency", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
    public ResponseEntity<GeneralResponse<PartnerDto>> getAllRewards(
            @ApiParam(value = "Request body to request partner ID",example = "1", name = "id", required = true)
            @PathVariable("id") long id){
        PartnerDto partner = partnerService.getOnePartner(id);
        GeneralResponse<PartnerDto> response = new GeneralResponse<>(true, partner);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
