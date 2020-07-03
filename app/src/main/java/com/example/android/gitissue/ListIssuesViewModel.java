package com.example.android.gitissue;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.ViewModel;

public class ListIssuesViewModel extends ViewModel {
    private MediatorLiveData<ApiResponse> mApiResponse;
    private IssueRepository mIssueRepository;
    // No argument constructor
    public ListIssuesViewModel() {
        mApiResponse = new MediatorLiveData<>();
        mIssueRepository = new IssueRepositoryIm();
    }
    @NonNull
    public LiveData<ApiResponse> getApiResponse() {
        return mApiResponse;
    }
    public LiveData<ApiResponse> loadIssues(@NonNull String user, String repo) {
        mApiResponse.addSource(
                mIssueRepository.getIssues(user, repo),
                apiResponse -> mApiResponse.setValue(apiResponse)
        );
        return mApiResponse;
    }
}
