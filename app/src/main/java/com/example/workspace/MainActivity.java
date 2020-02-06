package com.example.workspace;

import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import com.example.workspace.Posts.PostsFragment;

import dagger.android.support.DaggerAppCompatActivity;

public class MainActivity extends DaggerAppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .add(R.id.fragment_container, PostsFragment.newInstance())
                .commit();
    }
}
