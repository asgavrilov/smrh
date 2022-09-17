package com.srh.srh2.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ProjectDTO {
    private String id;
    private String name;
    private List<String> userIds;
    private List<String> adminUserIds;
}
