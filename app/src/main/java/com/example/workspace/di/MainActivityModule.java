package com.example.workspace.di;

import com.example.workspace.MainActivity;
import com.example.workspace.di.scopes.ActivityScope;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
abstract class MainActivityModule {
    @ActivityScope
    @ContributesAndroidInjector(modules = {FragmentModule.class})
    abstract MainActivity contributesActivity();
}
