package com.example.android.gitissue;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class IssueRepositoryIm implements IssueRepository {

        public static final String BASE_URL = "https://api.github.com/";
        private GitHubApiService mApiService;

        public IssueRepositoryIm() {
            Retrofit retrofit = new Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(BASE_URL)
                    .build();
            mApiService = retrofit.create(GitHubApiService.class);
        }
        public LiveData<ApiResponse> getIssues(String owner, String repo) {
            final MutableLiveData<ApiResponse> liveData = new MutableLiveData<>();
            Call<List<Issue>> call = mApiService.getIssues(owner, repo);
            call.enqueue(new Callback<List<Issue>>() {
                @Override
                public void onResponse(Call<List<Issue>> call, Response<List<Issue>> response) {
                    liveData.setValue(new ApiResponse(response.body()));
                }
                @Override
                public void onFailure(Call<List<Issue>> call, Throwable t) {
                    liveData.setValue(new ApiResponse(t));
                }
            });
            return liveData;
        }
}
