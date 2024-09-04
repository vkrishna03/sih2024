package com.gujarat.startup.web.response;

import java.util.ArrayList;
import java.util.List;

import com.gujarat.startup.entity.Funds;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor 
@NoArgsConstructor
@Data
@Builder
public class FundsResponse {

    private List<Funds> fundsList;

    public void addFunds(Funds funds){
        if(fundsList == null){
            fundsList = new ArrayList<>();
        }
        fundsList.add(funds);
    }
}
