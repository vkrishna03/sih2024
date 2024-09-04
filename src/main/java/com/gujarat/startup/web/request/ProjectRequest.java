package com.gujarat.startup.web.request;

import java.util.List;

import com.gujarat.startup.entity.Project;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ProjectRequest {
    
    private List<Project> projects;
}
