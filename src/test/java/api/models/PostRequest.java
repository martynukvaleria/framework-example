package api.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PostRequest {

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

    public PostRequest() {
        this.access = null;
        this.access_type = "public";
        this.code = "TEST";
        this.description = "";
        this.group = null;
        this.title = "Test";
    }

    public PostRequest(String access, String access_type, String code, String description, Integer group, String title) {
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

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAccess() {
        return access;
    }

    public void setAccess(String access) {
        this.access = access;
    }

    public String getAccess_type() {
        return access_type;
    }

    public void setAccess_type(String access_type) {
        this.access_type = access_type;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getGroup() {
        return group;
    }

    public void setGroup(Integer group) {
        this.group = group;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "PostRequest{" +
                "access='" + access + '\'' +
                ", access_type='" + access_type + '\'' +
                ", code='" + code + '\'' +
                ", description='" + description + '\'' +
                ", group='" + group + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
