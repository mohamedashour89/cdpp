package com.hyundaimotors.hmb.cdppapp.controller.voc;

import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBINNOCEANCDPP0034Dto;
import com.hyundaimotors.hmb.cdppapp.dto.IFHMBSMARTERSCDPP0036Dto;
import com.hyundaimotors.hmb.cdppapp.payload.IFHMBINNOCEANCDPP0034.IFHMBINNOCEANCDPP0034Payload;
import com.hyundaimotors.hmb.cdppapp.payload.IFHMBSMARTERSCDPP0036.IFHMBSMARTERSCDPP0036Payload;
import com.hyundaimotors.hmb.cdppapp.service.IFHMBINNOCEANCDPP0034Service;
import com.hyundaimotors.hmb.cdppapp.service.IFHMBSMARTERSCDPP0036Service;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "HMB Service Request Chat WS", description = "This web service can be used to insert or update Mesage de Chat into Connex.")
@RestController
@RequiredArgsConstructor
public class IFHMBSMARTERSCDPP0036Controller {
    
    private final IFHMBSMARTERSCDPP0036Service service;

    private final ModelMapper defaultMapper;

    @Operation(summary = "HMB Service Request Chat WS", description = "HMB Service Request Chat WS")
    @ApiResponse(content = @Content(schema = @Schema(implementation = IFHMBSMARTERSCDPP0036Payload.Response.class)))
    @PostMapping(value = "/api/v1/HMBServiceRequestChatWS")
    public Object insertObject(@RequestBody IFHMBSMARTERSCDPP0036Payload.Request request)throws Exception{

        IFHMBSMARTERSCDPP0036Dto dto = defaultMapper.map(request, IFHMBSMARTERSCDPP0036Dto.class);
        
        IFHMBSMARTERSCDPP0036Dto resultDto = new IFHMBSMARTERSCDPP0036Dto();

        resultDto = service.insertObject(dto);

        return defaultMapper.map(resultDto, IFHMBSMARTERSCDPP0036Payload.Response.class);
    }
}