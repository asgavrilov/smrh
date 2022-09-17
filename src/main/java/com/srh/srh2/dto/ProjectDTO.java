package com.srh.srh2.dto;

import lombok.Data;

import java.util.List;

@Data
public class ProjectDTO {
    private String id;
    private String name;
    private List<String> userIds;
    private List<String> adminUserIds;
}
