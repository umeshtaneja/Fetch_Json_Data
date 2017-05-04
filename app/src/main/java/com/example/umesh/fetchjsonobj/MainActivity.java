package com.example.umesh.fetchjsonobj;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.example.umesh.fetchjsonobj.Interface.MainView;
import com.example.umesh.fetchjsonobj.Model.Post;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MainView {
    final Adapter adapter = new Adapter(this);
    private RecyclerView recyclerView;
    private ProgressBar mProgressBar,mProgressBarLoadMore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUIElements();

    }

    public void setUIElements(){
        recyclerView = (RecyclerView) findViewById(R.id.recycler_post);
        mProgressBar = (ProgressBar) findViewById(R.id.progressBar);
        adapter.requestData();
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }



    @Override
    public void showProgress() {
        mProgressBar.post(new Runnable() {
            @Override
            public void run() {
                mProgressBar.setVisibility(View.VISIBLE);
            }
        });

    }

    @Override
    public void hideProgress() {
        mProgressBar.post(new Runnable() {
            @Override
            public void run() {
                mProgressBar.setVisibility(View.INVISIBLE);
            }
        });

    }
}
