package com.hyundaimotors.hmb.cdppapp.controller.lead;

import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBSELFBICDPP0062.IFHMBSELFBICDPP0062Dto;
import com.hyundaimotors.hmb.cdppapp.payload.IFHMBSELFBICDPP0062.IFHMBSELFBICDPP0062Payload;
import com.hyundaimotors.hmb.cdppapp.service.ApiLogService;
import com.hyundaimotors.hmb.cdppapp.service.IFHMBSELFBICDPP0062Service;
import com.hyundaimotors.hmb.cdppapp.util.ApiLog;
import com.hyundaimotors.hmb.cdppapp.util.ApiLogStep;
import com.hyundaimotors.hmb.cdppapp.util.JsonUtils;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "HMB Get Total Leads WF", description = "Interface Requirement for Get Total Leads WF I/F Requirement")
@RestController
@RequiredArgsConstructor
public class IFHMBSELFBICDPP0062Controller {

    private static final String IF_ID = "IF083";
    
    private final ApiLogService logService;
    
    @Autowired
    private final IFHMBSELFBICDPP0062Service service;

    private final ModelMapper defaultMapper;

    @Operation(summary = "HMB Get Total Leads WF", description = "HMB Get Total Leads WF")
    @ApiResponse(content = @Content(schema = @Schema(implementation = IFHMBSELFBICDPP0062Payload.Response.class)))
    @PostMapping(value = "/api/v1/HMBGetTotalLeadsWF")
    public Object getObject(@RequestBody IFHMBSELFBICDPP0062Payload.Request request) throws Exception {
        UUID IF_TR_ID = UUID.randomUUID();
        
        IFHMBSELFBICDPP0062Payload.Response response = new IFHMBSELFBICDPP0062Payload.Response();
        ApiLog.logApi(logService, IF_ID, ApiLogStep.START, IF_TR_ID, JsonUtils.toJson(request));
         
        try {
            ModelMapper modelMapper = new ModelMapper();
            IFHMBSELFBICDPP0062Dto resultDto = new IFHMBSELFBICDPP0062Dto();
    
            IFHMBSELFBICDPP0062Dto dto = defaultMapper.map(request, IFHMBSELFBICDPP0062Dto.class);
            
            ApiLog.logApi(logService, IF_ID,ApiLogStep.STEP1, IF_TR_ID, null);
            resultDto = service.getObject(dto);
            ApiLog.logApi(logService, IF_ID,ApiLogStep.STEP2, IF_TR_ID, null);
    
            response = modelMapper.map(resultDto, IFHMBSELFBICDPP0062Payload.Response.class);
            ApiLog.logApi(logService, IF_ID,ApiLogStep.FINISH, IF_TR_ID, JsonUtils.toJson(response));
        }catch(Exception e) {
            response.setErrorSpcCode("500");
            response.setErrorSpcMessage(e.getLocalizedMessage());
            ApiLog.logApi(logService, IF_ID,ApiLogStep.FINISH, IF_TR_ID, JsonUtils.toJson(response), e);
        }
        return response;
    }
}
