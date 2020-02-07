package com.example.workspace.Users;

import com.example.workspace.di.scopes.FragmentScope;

import dagger.Binds;
import dagger.Module;

@Module
public interface UsersFragmentModule {
    @FragmentScope
    @Binds
    UsersContract.View provideFragment(UsersFragment view);

    @FragmentScope
    @Binds
    UsersContract.Presenter providePresenter(UsersPresenter presenter);

    @FragmentScope
    @Binds
    UsersContract.Repository provideRepository(UsersRepository repository);
}
