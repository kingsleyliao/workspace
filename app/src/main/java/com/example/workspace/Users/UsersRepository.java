package com.example.workspace.Users;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.workspace.di.qualifiers.AppContext;
import com.example.workspace.network.ApiService;
import com.example.workspace.tracking.Tracker;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class UsersRepository implements UsersContract.Repository {
    private static final String TAG = "UsersRepository";
    UsersContract.Presenter presenter;
    ApiService apiService;
    CompositeDisposable compositeDisposable = new CompositeDisposable();

    @Inject
    public UsersRepository(ApiService apiService) {
        this.apiService = apiService;
    }

    @Override
    public void setPresenter(UsersContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void fetchUsers() {
        Log.d("DAGGER", apiService.toString());
        compositeDisposable.add(
                apiService.fetchUsers()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(
                                users -> presenter.onUsersReceived(users),
                                error -> Log.d(TAG, "fetchUsers: failed " + error.toString())
                        )
        );
    }
}
