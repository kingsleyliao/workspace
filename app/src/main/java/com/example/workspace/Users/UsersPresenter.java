package com.example.workspace.Users;

import android.util.Log;

import com.example.workspace.models.User;
import com.example.workspace.tracking.Tracker;

import java.util.List;

import javax.inject.Inject;

import static android.content.ContentValues.TAG;

public class UsersPresenter implements UsersContract.Presenter {
    UsersContract.View view;
    UsersContract.Repository repository;

    @Inject
    public UsersPresenter(UsersContract.Repository repository) {
        this.repository = repository;
        repository.setPresenter(this);
    }

    @Override
    public void onViewAttached(UsersContract.View view) {
        this.view = view;
    }

    @Override
    public void fetchUsers() {
        repository.fetchUsers();
    }

    @Override
    public void onUsersReceived(List<User> users) {
        view.renderUsers(users);
    }
}
