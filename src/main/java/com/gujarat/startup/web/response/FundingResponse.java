package com.gujarat.startup.web.response;

import java.util.ArrayList;
import java.util.List;

import com.gujarat.startup.entity.Funding;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor 
@NoArgsConstructor
@Data
@Builder
public class FundingResponse {

    private List<Funding> fundings;

    public void addFunding(Funding funding){
        if(fundings == null){
            fundings = new ArrayList<>();
        }
        fundings.add(funding);
    }
}
