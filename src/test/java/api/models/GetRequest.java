package api.models;

import api.dto.GetRequestDto;

public class GetRequest {
    private int limit;
    private int offset;

    public GetRequest() {
        this.limit = 10;
        this.offset = 0;
    }

    public GetRequest(int limit, int offset) {
        this.limit = limit;
        this.offset = offset;
    }

    public int getLimit() {
        return limit;
    }

    public int getOffset() {
        return offset;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public GetRequestDto toDto() {
        return new GetRequestDto(this.limit, this.offset);
    }
}
