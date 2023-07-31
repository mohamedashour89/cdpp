package com.hyundaimotors.hmb.cdppapp.mapper;

import java.util.List;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBINNOCEANCDPP0037Dto;
import com.hyundaimotors.hmb.cdppapp.payload.IFHMBINNOCEANCDPP0037.ListOfContactHobby;
import com.hyundaimotors.hmb.cdppapp.payload.IFHMBINNOCEANCDPP0037.ListOfContactSoccerTeam;
import com.hyundaimotors.hmb.cdppapp.payload.IFHMBINNOCEANCDPP0037.ListOfContactSocialMedia;
import com.hyundaimotors.hmb.cdppapp.payload.IFHMBINNOCEANCDPP0037.UpdateContactOutput;

public interface IFHMBINNOCEANCDPP0037Mapper {
    
    public int updateContact(IFHMBINNOCEANCDPP0037Dto dto)throws Exception;
    
    public int updateContactx(IFHMBINNOCEANCDPP0037Dto dto)throws Exception;

    public int updateContactHobby(IFHMBINNOCEANCDPP0037Dto dto)throws Exception;

    public int updateSoccerTeam(IFHMBINNOCEANCDPP0037Dto dto)throws Exception;

    public int updateContactSocialMedia(IFHMBINNOCEANCDPP0037Dto dto)throws Exception;

    public UpdateContactOutput getUpdateContactOutput(IFHMBINNOCEANCDPP0037Dto dto)throws Exception;

    public List<ListOfContactHobby> getListHobby(IFHMBINNOCEANCDPP0037Dto dto)throws Exception;

    public List<ListOfContactSoccerTeam> getListSoccerTeam(IFHMBINNOCEANCDPP0037Dto dto)throws Exception;

    public List<ListOfContactSocialMedia> getListSocialMedia(IFHMBINNOCEANCDPP0037Dto dto)throws Exception;
}
