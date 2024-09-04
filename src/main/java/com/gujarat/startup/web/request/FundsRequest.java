package com.gujarat.startup.web.request;

import java.util.List;

import com.gujarat.startup.entity.Funds;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FundsRequest {
    
    private List<Funds> funds;
}