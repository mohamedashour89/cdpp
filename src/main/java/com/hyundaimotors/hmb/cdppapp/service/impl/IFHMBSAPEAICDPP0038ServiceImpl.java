package com.hyundaimotors.hmb.cdppapp.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBSAPEAICDPP0038Dto;
import com.hyundaimotors.hmb.cdppapp.mapper.IFHMBSAPEAICDPP0038Mapper;
import com.hyundaimotors.hmb.cdppapp.service.IFHMBSAPEAICDPP0038Service;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class IFHMBSAPEAICDPP0038ServiceImpl implements IFHMBSAPEAICDPP0038Service{
    
    private final IFHMBSAPEAICDPP0038Mapper mapper;

    public IFHMBSAPEAICDPP0038Dto insertObject(IFHMBSAPEAICDPP0038Dto dto)throws Exception{
        IFHMBSAPEAICDPP0038Dto resultDto = new IFHMBSAPEAICDPP0038Dto();

        mapper.insertLead(dto);

        if (dto.getListOfTemperature() != null && !dto.getListOfTemperature().isEmpty()) {
            mapper.insertTemperature(dto);
        }

        if (dto.getListOfInteraction() != null && !dto.getListOfInteraction().isEmpty()) {
            mapper.insertInteraction(dto);
        }

        HashMap<String, String> map = new HashMap<>();

        map.put("PARAM_ID", String.valueOf(dto.getRowId()));

        mapper.transferProcess(map);

        mapper.transferReplica(map);

        List<String> actionId = new ArrayList<>();
        actionId = mapper.getActionId(dto);

        resultDto.setActionIdArray(actionId);

        if(0 < actionId.size()){
            String actionRowId = String.join("," , actionId);
            resultDto.setActionId(actionRowId);
        }
        
        
        
        //resultDto.set(dto.getRowId());
        
        resultDto.setErrorSpcCode("0");
        resultDto.setErrorSpcMessage("OK");

        return resultDto;
    }

    public void insertDPObject(IFHMBSAPEAICDPP0038Dto dto)throws Exception{
        List<String> actionIdArray = new ArrayList<>();
        actionIdArray = dto.getActionIdArray();
        HashMap<String, String[]>  map = new HashMap<>();

        String[] param = actionIdArray.toArray(new String[actionIdArray.size()]);
        
        map.put("param_id", param);
        
        mapper.transferDPProcess(map);
    }

}
