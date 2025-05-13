package api.models;

import api.dto.PatchRequestDto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class PatchProjectRequestBody {

    private String title;
    private String code;
    private String description;

    public PatchProjectRequestBody() {}

    public PatchProjectRequestBody(String title, String code, String description) {
        this.title = title;
        this.code = code;
        this.description = description;
    }

    public PatchRequestDto toDto() {
        return new PatchRequestDto(this.title, this.code, this.description);
    }
}
