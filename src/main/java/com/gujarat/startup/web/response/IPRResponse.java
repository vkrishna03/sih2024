package com.gujarat.startup.web.response;

import java.util.ArrayList;
import java.util.List;

import com.gujarat.startup.entity.IPR;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor 
@NoArgsConstructor
@Data
@Builder
public class IPRResponse {

    private List<IPR> iprs;

    public void addIPR(IPR ipr){
        if(iprs == null){
            iprs = new ArrayList<>();
        }
        iprs.add(ipr);
    }
}
