package com.hyundaimotors.hmb.cdppapp.mapper;

import java.util.HashMap;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBSAPEAICDPP0003Dto;

public interface IFHMBSAPEAICDPP0003Mapper {
    
    public int insertObject(IFHMBSAPEAICDPP0003Dto dto)throws Exception;

    public IFHMBSAPEAICDPP0003Dto getProductRowId(IFHMBSAPEAICDPP0003Dto dto)throws Exception;

    public void transferProcess(HashMap<String, String> parMap)throws Exception;

    public void transferReplica(HashMap<String, String> parMap)throws Exception;
}
