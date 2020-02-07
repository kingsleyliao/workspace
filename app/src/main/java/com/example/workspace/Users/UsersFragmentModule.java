package com.example.workspace.Users;

import dagger.Binds;
import dagger.Module;

@Module
public interface UsersFragmentModule {
    @Binds
    UsersContract.View provideFragment(UsersFragment view);

    @Binds
    UsersContract.Presenter providePresenter(UsersPresenter presenter);

    @Binds
    UsersContract.Repository provideRepository(UsersRepository repository);
}
