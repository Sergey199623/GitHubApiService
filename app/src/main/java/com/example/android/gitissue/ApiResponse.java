package com.example.android.gitissue;

import java.util.List;

public class ApiResponse {
    private List<Issue> issues;
    private Throwable error;
    public ApiResponse(List<Issue> issues) {
        this.issues = issues;
        this.error = null;
    }
    public ApiResponse(Throwable error) {
        this.error = error;
        this.issues = null;
    }
    // Getters...
}
