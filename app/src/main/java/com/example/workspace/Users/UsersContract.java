package com.example.workspace.Users;

import com.example.workspace.models.User;

import java.util.List;

public interface UsersContract {
    interface View {
        void renderUsers(List<User> users);
    }

    interface Presenter {
        void fetchUsers();
        void onUsersReceived(List<User> users);
    }

    interface Repository {
        void setPresenter(Presenter presenter);
        void fetchUsers();
    }
}
