package com.gujarat.startup.web.response;

import java.util.ArrayList;
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
public class ProjectResponse {

    private List<Project> projects;

    public void addProject(Project project){
        if(projects == null){
            projects = new ArrayList<>();
        }
        projects.add(project);
    }
}
