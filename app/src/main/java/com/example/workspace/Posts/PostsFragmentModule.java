package com.example.workspace.Posts;

import com.example.workspace.di.scopes.FragmentScope;

import dagger.Binds;
import dagger.Module;

@Module
public interface PostsFragmentModule {
    @FragmentScope
    @Binds
    PostsContract.View provideView(PostsFragment view);

    @FragmentScope
    @Binds
    PostsContract.Presenter providePresenter(PostsPresenter presenter);

    @FragmentScope
    @Binds
    PostsContract.Repository provideRepository(PostsRepository repository);
}
