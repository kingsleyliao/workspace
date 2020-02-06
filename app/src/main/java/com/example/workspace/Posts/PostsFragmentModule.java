package com.example.workspace.Posts;

import dagger.Binds;
import dagger.Module;

@Module
public interface PostsFragmentModule {
    @Binds
    PostsContract.View provideView(PostsFragment view);

    @Binds
    PostsContract.Presenter providePresenter(PostsPresenter presenter);

    @Binds
    PostsContract.Repository provideRepository(PostsRepository repository);
}
