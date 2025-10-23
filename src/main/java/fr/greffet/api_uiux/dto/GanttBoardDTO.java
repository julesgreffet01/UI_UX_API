package fr.greffet.api_uiux.dto;

import jakarta.validation.constraints.NotBlank;

public class GanttBoardDTO {

    @NotBlank
    private String name;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
