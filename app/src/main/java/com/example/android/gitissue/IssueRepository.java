package com.example.android.gitissue;

import androidx.lifecycle.LiveData;

public interface IssueRepository {
    LiveData<ApiResponse> getIssues(String owner, String repo);
}