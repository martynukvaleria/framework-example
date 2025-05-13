package api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/* DTO - data transfer object (between api/back/front)
if json property changes -- change only this class
 */
public class GetRequestDto {

    @JsonProperty("limit")
    private int limit;

    @JsonProperty("offset")
    private int offset;

    public GetRequestDto() {
    }

    public GetRequestDto(int limit, int offset) {
        this.limit = limit;
        this.offset = offset;
    }

    public int getLimit() {
        return limit;
    }

    public int getOffset() {
        return offset;
    }
}
