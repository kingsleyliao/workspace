package com.example.workspace.Posts;

import com.example.workspace.models.Post;

import java.util.List;

import javax.inject.Inject;

public class PostsPresenter implements PostsContract.Presenter {
    private PostsContract.View view;
    private PostsContract.Repository repository;

    @Inject
    public PostsPresenter(PostsContract.Repository repository) {
        this.repository = repository;
        repository.setPresenter(this);
    }

    @Override
    public void onViewAttached(PostsContract.View view) {
        this.view = view;
    }

    @Override
    public void fetchPosts() {
        repository.fetchPosts();
    }

    @Override
    public void onPostsReceived(List<Post> posts) {
        view.renderPosts(posts);
    }
}
