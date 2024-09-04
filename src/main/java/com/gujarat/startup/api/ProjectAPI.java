package com.gujarat.startup.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gujarat.startup.service.ProjectService;
import com.gujarat.startup.web.request.ProjectRequest;
import com.gujarat.startup.web.response.ProjectResponse;

@RestController
@RequestMapping("/project")
public class ProjectAPI {
    
    final Logger logger=LoggerFactory.getLogger(ProjectAPI.class);

    @Autowired
    ProjectService projectService;

    @PostMapping
    public ResponseEntity<ProjectResponse> createProject(@RequestBody ProjectRequest projectRequest) {
        ProjectResponse projectResponse = projectService.createProject(projectRequest);
        if(projectResponse == null) {
            logger.info("ProjectResponse is null");
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(projectResponse);
    }

    @PutMapping
    public ResponseEntity<ProjectResponse> updateProject(@RequestBody ProjectRequest projectRequest) {
        ProjectResponse projectResponse = projectService.updateProject(projectRequest);
        if(projectResponse == null) {
            logger.info("ProjectResponse is null");
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(projectResponse);
    }

    @GetMapping("/userId/{userId}")
    public ResponseEntity<ProjectResponse> getProjectByUserId(Long userId) {
        ProjectResponse projectResponse = projectService.getProjectByUserId(userId);
        if(projectResponse == null) {
            logger.info("ProjectResponse is null");
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(projectResponse);
    }

    @GetMapping("/accountId/{accountId}")
    public ResponseEntity<ProjectResponse> getProjectByAccountId(Long accountId) {
        ProjectResponse projectResponse = projectService.getProjectByAccountId(accountId);
        if(projectResponse == null) {
            logger.info("ProjectResponse is null");
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(projectResponse);
    }

    @GetMapping("/projectId/{projectId}")
    public ResponseEntity<ProjectResponse> getByProjectId(Long projectId) {
        ProjectResponse projectResponse = projectService.getProjectById(projectId);
        if(projectResponse == null) {
            logger.info("ProjectResponse is null");
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(projectResponse);
    }

    @DeleteMapping("/projectId/{projectId}")
    public ResponseEntity<ProjectResponse> deleteProjectByProjectId(Long projectId) {
        ProjectResponse projectResponse = projectService.deleteByProjectId(projectId);
        if(projectResponse == null) {
            logger.info("ProjectResponse is null");
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(projectResponse);
    }
}
