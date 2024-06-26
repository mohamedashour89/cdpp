package com.hyundaimotors.hmb.cdppapp.mapper;

import java.util.List;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBSELFBICDPP0063.AccountGetVinDto;
import com.hyundaimotors.hmb.cdppapp.dto.IFHMBSELFBICDPP0063.ContactGetVinDto;
import com.hyundaimotors.hmb.cdppapp.dto.IFHMBSELFBICDPP0063.IFHMBSELFBICDPP0063Dto;
import com.hyundaimotors.hmb.cdppapp.dto.IFHMBSELFBICDPP0063.VehicleDto;

public interface IFHMBSELFBICDPP0063Mapper {
    
    public List<VehicleDto> getAsset(IFHMBSELFBICDPP0063Dto dto)throws Exception;

    public List<ContactGetVinDto> getContact(String cAccountId)throws Exception;

    public List<AccountGetVinDto> getAccount(String bAccountId)throws Exception;
}
