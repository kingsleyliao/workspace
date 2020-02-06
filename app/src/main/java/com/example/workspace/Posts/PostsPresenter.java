package com.example.workspace.Posts;

import com.example.workspace.models.Post;

import java.util.List;

import javax.inject.Inject;

public class PostsPresenter implements PostsContract.Presenter {
    PostsContract.View view;
    PostsContract.Repository repository;

    @Inject
    public PostsPresenter(PostsContract.View view, PostsContract.Repository repository) {
        this.view = view;
        this.repository = repository;
        repository.setPresenter(this);
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
