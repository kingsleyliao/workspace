package com.example.workspace.Posts;

import com.example.workspace.models.Post;

import java.util.List;

public interface PostsContract {
    interface View {
        void renderPosts(List<Post> posts);
    }

    interface Presenter {
        void onViewAttached(View view);
        void fetchPosts();
        void onPostsReceived(List<Post> posts);
    }

    interface Repository {
        void fetchPosts();
        void setPresenter(Presenter presenter);
    }
}
