package com.srh.srh2.service.impl;

import com.github.javafaker.Faker;
import com.srh.srh2.dto.ProjectDTO;
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

    /**
     * *
     * acts as stub
     * @return returns new arraylist with predefined objects for show purposes
     */
    private List<ProjectDTO> getProjectsWithRetry() {
        Faker faker = new Faker();
        List<ProjectDTO> res = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            ProjectDTO dto = ProjectDTO.builder()
                    .id(String.valueOf(i))
                    .name(faker.name().name())
                    .userIds(List.of("asd","qwe", "rty", "zxc"))
                    .adminUserIds(List.of("vcx", "dfg","eye", "yrt"))
                    .build();
            res.add(dto);
        }
        return res;
    }
}
