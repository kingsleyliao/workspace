package com.example.workspace.Users;

import android.util.Log;

import com.example.workspace.network.ApiService;

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
