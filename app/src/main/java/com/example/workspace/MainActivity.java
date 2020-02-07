package com.example.workspace;

import android.os.Bundle;

import androidx.fragment.app.FragmentManager;

import com.example.workspace.Posts.PostsFragment;
import com.example.workspace.Users.UsersFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import dagger.android.support.DaggerAppCompatActivity;

public class MainActivity extends DaggerAppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager fragmentManager = getSupportFragmentManager();
        if (savedInstanceState == null) {

            fragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, PostsFragment.newInstance())
                    .commit();
        }
        FloatingActionButton fab = findViewById(R.id.fab);

        fab.setOnClickListener(v ->
                fragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, UsersFragment.newInstance())
                        .addToBackStack(UsersFragment.class.getName())
                        .commit());
    }
}
