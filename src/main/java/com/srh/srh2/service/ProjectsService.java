package com.srh.srh2.service;

import com.srh.srh2.dto.ProjectDTO;

import java.util.List;

public interface ProjectsService {
    List<ProjectDTO> getProjects(String userId, int responseLimit);
}
