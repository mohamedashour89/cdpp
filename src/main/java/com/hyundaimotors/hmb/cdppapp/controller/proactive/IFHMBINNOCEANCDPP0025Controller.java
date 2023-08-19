package com.hyundaimotors.hmb.cdppapp.controller.proactive;

import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBINNOCEANCDPP0025Dto;
import com.hyundaimotors.hmb.cdppapp.dto.IFHMBINNOCEANCDPP0046Dto;
import com.hyundaimotors.hmb.cdppapp.dto.IFHMBMAPFRECDPP0009Dto;
import com.hyundaimotors.hmb.cdppapp.payload.IFHMBINNOCEANCDPP0022Payload;
import com.hyundaimotors.hmb.cdppapp.payload.IFHMBINNOCEANCDPP0025Payload;
import com.hyundaimotors.hmb.cdppapp.payload.IFHMBINNOCEANCDPP0027Payload;
import com.hyundaimotors.hmb.cdppapp.service.IFHMBINNOCEANCDPP0022Service;
import com.hyundaimotors.hmb.cdppapp.service.IFHMBINNOCEANCDPP0025Service;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "HMB MNTSRVC Schedule Maintenance", description = "This web service can be used to insert or update maintenance services.")
@RestController
@RequiredArgsConstructor
public class IFHMBINNOCEANCDPP0025Controller {
    
    private final IFHMBINNOCEANCDPP0025Service service;

    private final ModelMapper defaultMapper;

    @Operation(summary = "HMB MNTSRVC Schedule Maintenance", description = "HMB MNTSRVC Schedule Maintenance")
    @ApiResponse(content = @Content(schema = @Schema(implementation = IFHMBINNOCEANCDPP0025Payload.Response.class)))
    @PostMapping(value = "/api/v1/HMBMNTSRVCScheduleMaintenance/upsert")
    public Object upsertObject(@RequestBody IFHMBINNOCEANCDPP0025Payload.Request request)throws Exception{
        ModelMapper modelMapper = new ModelMapper();
        IFHMBINNOCEANCDPP0025Dto resultDto = new IFHMBINNOCEANCDPP0025Dto();
        IFHMBINNOCEANCDPP0025Dto dto = defaultMapper.map(request, IFHMBINNOCEANCDPP0025Dto.class);

        resultDto = service.upsertObject(dto);

        return defaultMapper.map(resultDto, IFHMBINNOCEANCDPP0022Payload.Response.class);
    }
}