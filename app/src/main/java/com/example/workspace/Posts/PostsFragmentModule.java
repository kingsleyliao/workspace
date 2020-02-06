package com.example.workspace.Posts;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class PostsFragmentModule {
    @Binds
    abstract PostsContract.View provideView(PostsFragment view);

    @Binds
    abstract PostsContract.Presenter providePresenter(PostsPresenter presenter);

    @Binds
    abstract PostsContract.Repository provideRepository(PostsRepository repository);

}
