package com.hyundaimotors.hmb.cdppapp.controller.foundation;

import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBINNOCEANCDPP0046.IFHMBINNOCEANCDPP0046Dto;
import com.hyundaimotors.hmb.cdppapp.payload.IFHMBINNOCEANCDPP0046.IFHMBINNOCEANCDPP0046Payload;
import com.hyundaimotors.hmb.cdppapp.service.ApiLogService;
import com.hyundaimotors.hmb.cdppapp.service.IFHMBINNOCEANCDPP0046Service;
import com.hyundaimotors.hmb.cdppapp.util.ApiLog;
import com.hyundaimotors.hmb.cdppapp.util.ApiLogStep;
import com.hyundaimotors.hmb.cdppapp.util.JsonUtils;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Tag(name = "HMB MNTSRVC Manage Dealer Service", description = "Innocean, SAP EAI list Interface")
@RestController
@RequiredArgsConstructor
public class IFHMBINNOCEANCDPP0046Controller {

    private static final String IF_ID = "IF057";
    
    private final ApiLogService logService;
    
    @Autowired
    private final IFHMBINNOCEANCDPP0046Service service;

    private final ModelMapper defaultMapper;

    @Operation(summary = "dealer Manage list", description = "dealer Manage list.")
    @ApiResponse(content = @Content(schema = @Schema(implementation = IFHMBINNOCEANCDPP0046Payload.Response.class)))
    @PostMapping(value = "/api/v1/HMBMNTSRVCManageDealerService")
    public Object getList(@Valid @RequestBody IFHMBINNOCEANCDPP0046Payload.Request request) throws Exception {
       UUID IF_TR_ID = UUID.randomUUID();
       
       IFHMBINNOCEANCDPP0046Payload.Response response = new IFHMBINNOCEANCDPP0046Payload.Response();
       ApiLog.logApi(logService, IF_ID, ApiLogStep.START, IF_TR_ID, JsonUtils.toJson(request));
       
       try {
           IFHMBINNOCEANCDPP0046Dto dto = defaultMapper.map(request, IFHMBINNOCEANCDPP0046Dto.class);
   
           ApiLog.logApi(logService, IF_ID,ApiLogStep.STEP1, IF_TR_ID, null);
           IFHMBINNOCEANCDPP0046Dto resultDto = service.insertList(dto);
           ApiLog.logApi(logService, IF_ID,ApiLogStep.STEP2, IF_TR_ID, null);
           
           response = defaultMapper.map(resultDto, IFHMBINNOCEANCDPP0046Payload.Response.class);  
           ApiLog.logApi(logService, IF_ID,ApiLogStep.FINISH, IF_TR_ID, JsonUtils.toJson(response));

           service.insertDPObject(resultDto);
           
        }catch(Exception e) {
            response.setErrorSpcCode("500");
            response.setErrorSpcMessage(e.getLocalizedMessage());
            ApiLog.logApi(logService, IF_ID,ApiLogStep.FINISH, IF_TR_ID, JsonUtils.toJson(response), e);
        }
       
       return response;
    }
}
