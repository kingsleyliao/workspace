package com.example.workspace.di;

import com.example.workspace.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class MainActivityModule {
    @ContributesAndroidInjector(modules = {FragmentModule.class})
    abstract MainActivity contributesActivity();
}
