package com.example.workspace.Posts;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.workspace.R;
import com.example.workspace.models.Post;

import java.util.List;

import javax.inject.Inject;

import dagger.android.support.DaggerFragment;

public class PostsFragment extends DaggerFragment implements PostsContract.View {
    private static final String TAG = "PostsFragment";
    @Inject PostsContract.Presenter presenter;

    LinearLayout linearLayout;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.posts_fragment, container, false);
        linearLayout = layout.findViewById(R.id.post_container);
        return layout;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter.fetchPosts();
    }

    @Override
    public void onStart() {
        super.onStart();
        presenter.onViewAttached(this);
    }

    @Override
    public void renderPosts(List<Post> posts) {
        for (Post post : posts) {
            Log.d(TAG, post.toString());
            TextView title = new TextView(getContext());
            title.setText(post.getTitle());
            linearLayout.addView(title);
        }
    }

    public static PostsFragment newInstance() {
        return new PostsFragment();
    }
}
