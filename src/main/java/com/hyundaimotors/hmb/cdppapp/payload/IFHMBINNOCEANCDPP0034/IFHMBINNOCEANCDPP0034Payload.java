package com.hyundaimotors.hmb.cdppapp.payload.IFHMBINNOCEANCDPP0034;

import java.util.List;

import com.hyundaimotors.hmb.cdppapp.payload.IFHMBSAPEAICDPP0006.ActionNote;
import com.hyundaimotors.hmb.cdppapp.payload.IFHMBSAPEAICDPP0006.ActionProducts;
import com.hyundaimotors.hmb.cdppapp.payload.IFHMBSAPEAICDPP0006.SynergyActionAudit;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

public class IFHMBINNOCEANCDPP0034Payload {
    
    @Schema(name = "IFHMBINNOCEANCDPP0034Payload.Request")
    @Getter
    @Setter
    public static class Request{
        ServiceRequest serviceRequest;
        List<Accessory> listOfAccessories;
        List<Part> listOfParts;
    }

    @Schema(name = "IFHMBINNOCEANCDPP0034Payload.Response")
    @Getter
    @Setter
    public static class Response{
        @Schema(description = "Connex error code. Code 0 means success.", example = "0")
        private String errorSpcCode;
        @Schema(description = "Connex error message.", example = "OK")
        private String errorSpcMessage;
        
    }
}