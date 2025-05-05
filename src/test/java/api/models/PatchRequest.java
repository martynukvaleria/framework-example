package api.models;

import api.dto.PatchRequestDto;

public class PatchRequest {

    private String title;
    private String code;
    private String description;

    public PatchRequest() {}

    public PatchRequest(String title, String code, String description) {
        this.title = title;
        this.code = code;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public PatchRequestDto toDto() {
        return new PatchRequestDto(this.title, this.code, this.description);
    }
}
