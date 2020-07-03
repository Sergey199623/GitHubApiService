package com.example.android.gitissue;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

// Интерфейс для retrofit

public interface GitHubApiService {
    @GET("/repos/{owner}/{repo}/issues")
    Call<List<Issue>> getIssues(@Path("owner")
                                        String owner, @Path("repo") String repo);
}