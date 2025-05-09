package api.models;

import api.dto.PostRequestDto;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class PostProjectRequestBody {

    private String access;
    private String access_type;
    private String code;
    private String description;
    private Integer group;
    private String title;

    public PostProjectRequestBody(String access, String access_type, String code, String description, Integer group, String title) {
        this.access = access;
        this.access_type = access_type;
        this.code = code;
        this.description = description;
        this.group = group;
        this.title = title;
    }

    public PostRequestDto toDto() {
        return  new PostRequestDto(this.access, this.access_type, this.code, this.description, this.group, this.title);
    }
}
