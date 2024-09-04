package com.gujarat.startup.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gujarat.startup.entity.Project;
import com.gujarat.startup.repository.ProjectRepo;
import com.gujarat.startup.repository.UserRepository;
import com.gujarat.startup.web.request.ProjectRequest;
import com.gujarat.startup.web.response.ProjectResponse;

@Service
public class ProjectService {

    final Logger logger = LoggerFactory.getLogger(ProjectService.class);

    @Autowired
    ProjectRepo projectRepo;

    @Autowired
    UserRepository userRepository;

    public ProjectResponse createProject(ProjectRequest projectRequest) {
        if(projectRequest == null || projectRequest.getProjects() == null || projectRequest.getProjects().isEmpty()) {
            logger.info("ProjectRequest is null or empty");
            return null;
        }

        ProjectResponse projectResponse = ProjectResponse.builder().build();
        for(Project project : projectRequest.getProjects()) {
            if(!userRepository.existsById(project.getUserId())) {
                logger.info("User not found for userId: " + project.getUserId());
                continue;
            }
            projectResponse.addProject(projectRepo.save(project));
        }
        return projectResponse;
    }

    public ProjectResponse updateProject(ProjectRequest projectRequest) {
        if(projectRequest == null || projectRequest.getProjects() == null || projectRequest.getProjects().isEmpty()) {
            logger.info("ProjectRequest is null or empty");
            return null;
        }
        ProjectResponse projectResponse = ProjectResponse.builder().build();
        for(Project project : projectRequest.getProjects()) {
            if(!userRepository.existsById(project.getUserId())) {
                logger.info("User not found for userId: " + project.getUserId());
                continue;
            }
            if(!projectRepo.existsById(project.getId())) {
                logger.info("Project not found for id: " + project.getId());
                continue;
            }
            projectResponse.addProject(projectRepo.save(project));
        }
        return projectResponse;
    }

    public ProjectResponse getProjectByUserId(Long userId) {
        if(userId == null) {
            logger.info("UserId is null");
            return null;
        }
        List<Project> projects = projectRepo.findByUserId(userId);
        if(projects == null || projects.isEmpty()) {
            logger.info("Projects not found for userId: " + userId);
            return null;
        }
        ProjectResponse projectResponse = ProjectResponse.builder().build();
        for(Project project : projects) {
            projectResponse.addProject(project);
        }
        return projectResponse;
    }

    public ProjectResponse getProjectById(Long id) {
        if(id == null) {
            logger.info("Id is null");
            return null;
        }
        Project project = projectRepo.findById(id).orElse(null);
        if(project == null) {
            logger.info("Project not found for id: " + id);
            return null;
        }
        ProjectResponse projectResponse = ProjectResponse.builder().build();
        projectResponse.addProject(project);
        return projectResponse;
    }

    public ProjectResponse getProjectByAccountId(Long accountId) {
        if(accountId == null) {
            logger.info("AccountId is null");
            return null;
        }
        List<Project> projects = projectRepo.findByAccountId(accountId);
        if(projects == null || projects.isEmpty()) {
            logger.info("Projects not found for accountId: " + accountId);
            return null;
        }
        ProjectResponse projectResponse = ProjectResponse.builder().build();
        for(Project project : projects) {
            projectResponse.addProject(project);
        }
        return projectResponse;
    }

    public ProjectResponse deleteByProjectId(Long id) {
        if(id == null) {
            logger.info("Id is null");
            return null;
        }
        Project project = projectRepo.findById(id).orElse(null);
        if(project == null) {
            logger.info("Project not found for id: " + id);
            return null;
        }
        projectRepo.delete(project);
        return ProjectResponse.builder().build();
    }

}