package com.moengage.SqlRunner.models;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class QueryRequest {
    private String query;

    //constructor
    public QueryRequest() {}
    public QueryRequest(String query) {
        this.query = query;
    }

}
