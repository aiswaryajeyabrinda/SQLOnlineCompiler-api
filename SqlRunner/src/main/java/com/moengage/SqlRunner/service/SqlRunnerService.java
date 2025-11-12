package com.moengage.SqlRunner.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class SqlRunnerService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Map<String, Object>> executeQuery(String query) {

        if (query == null || query.trim().isEmpty()) {
            throw new IllegalArgumentException("Query cannot be empty!");
        }
        String normalizedQuery = query.trim().toLowerCase();
        if (normalizedQuery.startsWith("drop") ||
                normalizedQuery.startsWith("delete") ||
                normalizedQuery.startsWith("update") ||
                normalizedQuery.startsWith("insert") ||
                normalizedQuery.startsWith("alter") ||
                normalizedQuery.startsWith("truncate")) {
            throw new IllegalArgumentException("Only SELECT queries are allowed here!");
        }
        return jdbcTemplate.queryForList(query);
    }

    public List<String> getTables() {
        String sql = "SELECT name FROM sqlite_master WHERE type='table' AND name NOT LIKE 'sqlite_%'";
        return jdbcTemplate.queryForList(sql, String.class);
    }
}
