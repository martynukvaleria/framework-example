package api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PatchRequestDto {

    @JsonProperty("title")
    private String title;

    @JsonProperty("code")
    private String code;

    @JsonProperty("description")
    private String description;

    public PatchRequestDto() {}

    public PatchRequestDto(String title, String code, String description) {
        this.title = title;
        this.code = code;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}
