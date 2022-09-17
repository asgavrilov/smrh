package com.srh.srh2.controller;

import com.srh.srh2.dto.ProjectDTO;
import com.srh.srh2.service.ProjectsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequestMapping(value = "api/v1/")
public class UserController {

    private final int responseLimit;

    private final ProjectsService projectsService;

    public UserController(@Value("${response.limit:15}") int responseLimit,
                          ProjectsService projectsService) {
        this.responseLimit = responseLimit;
        this.projectsService = projectsService;
    }

    @GetMapping("projects/{userId}/admin")
    public ResponseEntity<Object> getProjectsWhereUserIsAdmin(@PathVariable("userId") String userId) {
        log.info("Attempt to get list of projects for userId {}", userId);
        List<ProjectDTO> res = projectsService.getProjects(userId, responseLimit);
        return ResponseEntity.ok(res);
    }
}
