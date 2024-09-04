package com.gujarat.startup.web.response;

import java.util.ArrayList;
import java.util.List;

import com.gujarat.startup.entity.Milestone;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor 
@NoArgsConstructor
@Data
@Builder
public class MilestoneResponse {

    private List<Milestone> milestones;

    public void addMilestone(Milestone milestone){
        if(milestones == null){
            milestones = new ArrayList<>();
        }
        milestones.add(milestone);
    }
}
