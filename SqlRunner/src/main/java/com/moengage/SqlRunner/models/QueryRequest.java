package com.moengage.SqlRunner.models;

public class QueryRequest {
    private String query;

    //constructor
    public QueryRequest() {}
    public QueryRequest(String query) {
        this.query = query;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }
}
