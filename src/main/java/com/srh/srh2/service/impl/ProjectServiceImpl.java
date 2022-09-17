package com.srh.srh2.service.impl;

import com.srh.srh2.dto.ProjectDTO;
import com.srh.srh2.exceptions.ResourceNotFoundException;
import com.srh.srh2.service.ProjectsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class ProjectServiceImpl implements ProjectsService {

    @Override
    public List<ProjectDTO> getProjects(String userId, int responseLimit) {
        List<ProjectDTO> userProjects = getProjectsWithRetry();
            var res = userProjects.stream()
                    .filter(project -> project.getAdminUserIds().contains(userId))
                    .limit(responseLimit).toList();
            log.info("getting data size {} with userId {} and responseLimit {}",
                    res.size(), userId, responseLimit);
            return res;

    }

    private List<ProjectDTO> getProjectsWithRetry() {
        //acts as stub, just returns new arraylist
        return new ArrayList<>();
    }
}
