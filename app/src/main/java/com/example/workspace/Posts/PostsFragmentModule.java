package com.example.workspace.Posts;

import com.example.workspace.di.scopes.FragmentScope;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class PostsFragmentModule {
    @FragmentScope
    @Binds
    abstract PostsContract.View provideView(PostsFragment view);

    @FragmentScope
    @Binds
    abstract PostsContract.Presenter providePresenter(PostsPresenter presenter);

    @FragmentScope
    @Binds
    abstract PostsContract.Repository provideRepository(PostsRepository repository);

}
