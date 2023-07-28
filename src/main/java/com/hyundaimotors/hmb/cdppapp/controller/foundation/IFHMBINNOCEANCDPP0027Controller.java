package com.hyundaimotors.hmb.cdppapp.controller.foundation;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBINNOCEANCDPP0027Dto;
import com.hyundaimotors.hmb.cdppapp.dto.IFHMBSAPCDPP0005Dto;
import com.hyundaimotors.hmb.cdppapp.dto.IFHMBSAPEAICDPP0003Dto;
import com.hyundaimotors.hmb.cdppapp.payload.IFHMBINNOCEANCDPP0027Payload;
import com.hyundaimotors.hmb.cdppapp.payload.IFHMBSAPCDPP0005Payload;
import com.hyundaimotors.hmb.cdppapp.service.IFHMBINNOCEANCDPP0012Service;
import com.hyundaimotors.hmb.cdppapp.service.IFHMBINNOCEANCDPP0027Service;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "HMB Register In Application WS", description = "Innocean insert or update Interface")
@RestController
@RequiredArgsConstructor
public class IFHMBINNOCEANCDPP0027Controller {
    
    @Autowired
    private final IFHMBINNOCEANCDPP0027Service service;

    private final ModelMapper defaultMapper;

    @Operation(summary = "registers insert", description = "registers insert")
    @ApiResponse(content = @Content(schema = @Schema(implementation = IFHMBINNOCEANCDPP0027Payload.Response.class)))
    @PostMapping(value = "/api/v1/HMBRegisterInApplicationWS/upsert")
    public Object upsertObject(@RequestBody IFHMBINNOCEANCDPP0027Payload.Request request)throws Exception{
        
        IFHMBINNOCEANCDPP0027Dto dto = defaultMapper.map(request, IFHMBINNOCEANCDPP0027Dto.class);

        int resultNum = service.upsertObject(dto);

        if(0 < resultNum){
            dto.setErrorSpcCode("0");
            dto.setErrorSpcMessage("OK");
        }else{
            dto.setErrorSpcCode("1");
            dto.setErrorSpcMessage("fail");
        }
        return defaultMapper.map(dto, IFHMBINNOCEANCDPP0027Payload.Response.class);
    }

}