package com.example.workspace.Posts;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.workspace.di.qualifiers.AppContext;
import com.example.workspace.network.ApiService;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class PostsRepository implements PostsContract.Repository {
    private static final String TAG = "PostsRepository";
    private PostsContract.Presenter presenter;

    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    @Inject
    ApiService apiService;

    @Inject
    public PostsRepository() { }

    @Override
    public void fetchPosts() {
        Log.d("DAGGER", apiService.toString());
        compositeDisposable.add(
                apiService.fetchPosts()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(
                                posts -> presenter.onPostsReceived(posts),
                                error -> Log.d(TAG, "fetchPosts: failed" + error.toString())
                        )
        );
    }

    @Override
    public void setPresenter(PostsContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
