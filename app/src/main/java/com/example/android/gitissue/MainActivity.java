package com.example.android.gitissue;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListIssuesViewModel mViewModel = ViewModelProviders.of(this).get(ListIssuesViewModel.class);
        setupView();

        // Handle changes emitted by LiveData

        mViewModel.getRes().observe(this, apiResponse -> {
            if (apiResponse.getError() != null) {
                handleError(apiResponse.getError());
            } else {
                handleResponse(apiResponse.getIssues());
            }
        });
    }

    // Rest of the code
}