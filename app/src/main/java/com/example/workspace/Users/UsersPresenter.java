package com.example.workspace.Users;

import com.example.workspace.models.User;

import java.util.List;

import javax.inject.Inject;

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
