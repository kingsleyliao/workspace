package com.example.workspace.di;

import com.example.workspace.Posts.PostsFragment;
import com.example.workspace.Posts.PostsFragmentModule;
import com.example.workspace.di.scopes.FragmentScope;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class FragmentModule {
    @FragmentScope
    @ContributesAndroidInjector(modules = {PostsFragmentModule.class})
    abstract PostsFragment providesPostFragment();
}
