package com.hyundaimotors.hmb.cdppapp.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBCSUCDPP0086Dto;
import com.hyundaimotors.hmb.cdppapp.mapper.IFHMBCSUCDPP0086Mapper;
import com.hyundaimotors.hmb.cdppapp.service.IFHMBCSUCDPP0086Service;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class IFHMBCSUCDPP0086ServiceImpl implements IFHMBCSUCDPP0086Service{
    private final IFHMBCSUCDPP0086Mapper mapper;

    public IFHMBCSUCDPP0086Dto insertObject(IFHMBCSUCDPP0086Dto dto)throws Exception{
        IFHMBCSUCDPP0086Dto resulDto = new IFHMBCSUCDPP0086Dto();
        IFHMBCSUCDPP0086Dto emptyResulDto = new IFHMBCSUCDPP0086Dto();
        resulDto = mapper.getAccountObject(dto);

        if(resulDto != null){
            if("1".equals(resulDto.getQtdProtocol())){
                resulDto.setErrorSpcCode("0");
                resulDto.setErrorSpcMessage("OK");
                
                return resulDto;

            }else{
                emptyResulDto = mapper.getOnlyAccount(dto);
                return emptyResulDto;
            }
            
        }else{
            emptyResulDto = mapper.getOnlyAccount(dto);
            if (emptyResulDto == null) {
                emptyResulDto = new IFHMBCSUCDPP0086Dto();
                emptyResulDto.setErrorSpcCode("1");
                emptyResulDto.setErrorSpcMessage("No Data");
            }
            return emptyResulDto;
        }

        
    }
}
