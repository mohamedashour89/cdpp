package com.hyundaimotors.hmb.cdppapp.mapper;

import java.util.List;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBINNOCEANCDPP0032Dto;

public interface IFHMBINNOCEANCDPP0032Mapper {
    
    public IFHMBINNOCEANCDPP0032Dto getSearchContact(IFHMBINNOCEANCDPP0032Dto dto)throws Exception;

    public List<IFHMBINNOCEANCDPP0032Dto> getlistOfServiceRequest(IFHMBINNOCEANCDPP0032Dto dto)throws Exception;

}
