package com.moengage.SqlRunner.controller;

import com.moengage.SqlRunner.models.QueryRequest;
import com.moengage.SqlRunner.service.SqlRunnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class SqlRunnerController {
    @Autowired
    private SqlRunnerService sqlRunnerService;

    @PostMapping("/execute")
    public ResponseEntity<?> executeQuery(@RequestBody QueryRequest queryRequest) {
        try {
            List<Map<String, Object>> result = sqlRunnerService.executeQuery(queryRequest.getQuery());
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
        }
    }

    @GetMapping("/tables")
    public ResponseEntity<List<String>> getTables() {
        try {
            List<String> tables = sqlRunnerService.getTables();
            return ResponseEntity.ok(tables);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
