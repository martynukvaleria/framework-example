package api.models;

import api.dto.PostRequestDto;

public class PostRequest {

    private String access;
    private String access_type;
    private String code;
    private String description;
    private Integer group;
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

    public PostRequestDto toDto() {
        return  new PostRequestDto(this.access, this.access_type, this.code, this.description, this.group, this.title);
    }
}
