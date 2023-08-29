package com.hyundaimotors.hmb.cdppapp.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBINNOCEANCDPP0034Dto;
import com.hyundaimotors.hmb.cdppapp.mapper.IFHMBINNOCEANCDPP0034Mapper;
import com.hyundaimotors.hmb.cdppapp.service.IFHMBINNOCEANCDPP0034Service;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class IFHMBINNOCEANCDPP0034ServiceImpl implements IFHMBINNOCEANCDPP0034Service{
    private final IFHMBINNOCEANCDPP0034Mapper mapper;
    
    public IFHMBINNOCEANCDPP0034Dto insertObject(IFHMBINNOCEANCDPP0034Dto dto)throws Exception{
        IFHMBINNOCEANCDPP0034Dto resulDto = new IFHMBINNOCEANCDPP0034Dto();

        mapper.insertServiceRequest(dto);

        mapper.insertAccessory(dto);

        mapper.insertPart(dto);

        /*HashMap<String, String> map = new HashMap<>();

        map.put("PARAM_ID", String.valueOf(dto.getRowId()));

        mapper.transferProcess(map);
        
        mapper.transferReplica(map);*/

        resulDto.setErrorSpcCode("0");
        resulDto.setErrorSpcMessage("OK");

        return resulDto;
    }
}
