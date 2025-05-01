package api.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GetRequest {

    @JsonProperty("limit")
    private int limit;

    @JsonProperty("offset")
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

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    @Override
    public String toString() {
        return "GetProjectsRequest{" +
                "limit=" + limit +
                ", offset=" + offset +
                '}';
    }
}
