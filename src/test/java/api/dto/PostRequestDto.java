package api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PostRequestDto {

    @JsonProperty("access")
    private String access;

    @JsonProperty("access_type")
    private String access_type;

    @JsonProperty("code")
    private String code;

    @JsonProperty("description")
    private String description;

    @JsonProperty("group")
    private Integer group;

    @JsonProperty("title")
    private String title;

    public PostRequestDto(){}

    public PostRequestDto(String access, String access_type, String code, String description, Integer group, String title) {
        this.access = access;
        this.access_type = access_type;
        this.code = code;
        this.description = description;
        this.group = group;
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public String getAccess() {
        return access;
    }

    public String getAccess_type() {
        return access_type;
    }

    public String getCode() {
        return code;
    }

    public Integer getGroup() {
        return group;
    }

    public String getTitle() {
        return title;
    }
}
