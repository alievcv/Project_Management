package tenzor.soft.test.dto;

import tenzor.soft.test.enums.ProjectStatus;

public record ProjectStatusCountDto (
        ProjectStatus status,
        Long count
){
    public ProjectStatusCountDto (ProjectStatus status, Long count){
        this.status = status;
        this.count = count;

    }
}
