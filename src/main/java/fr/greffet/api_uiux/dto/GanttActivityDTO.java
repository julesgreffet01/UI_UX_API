package fr.greffet.api_uiux.dto;

import jakarta.validation.constraints.NotBlank;

import java.util.Date;

public class GanttActivityDTO {

    @NotBlank
    private String label;

    @NotBlank
    private Date startDate;

    @NotBlank
    private Date endDate;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
