package com.example.workspace.di;

import com.example.workspace.Posts.PostsFragment;
import com.example.workspace.Posts.PostsFragmentModule;
import com.example.workspace.di.scopes.FragmentScope;
import com.example.workspace.Users.UsersFragment;
import com.example.workspace.Users.UsersFragmentModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
abstract class FragmentModule {
    @FragmentScope
    @ContributesAndroidInjector(modules = {PostsFragmentModule.class})
    abstract PostsFragment providesPostFragment();

    @ContributesAndroidInjector(modules = {UsersFragmentModule.class})
    abstract UsersFragment providesUsersFragment();
}
