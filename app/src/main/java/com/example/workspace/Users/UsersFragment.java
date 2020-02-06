package com.example.workspace.Users;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.workspace.R;
import com.example.workspace.models.User;

import java.util.List;

import javax.inject.Inject;

import dagger.android.support.DaggerFragment;

public class UsersFragment extends DaggerFragment implements UsersContract.View {
    private static final String TAG = "UsersFragment";

    @Inject
    UsersContract.Presenter presenter;

    LinearLayout linearLayout;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.users_layout, container, false);

        linearLayout = view.findViewById(R.id.users_container);

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        presenter.fetchUsers();
    }

    @Override
    public void renderUsers(List<User> users) {
        for(User user : users) {
            TextView name = new TextView(getContext());
            name.setText(user.getName());
            linearLayout.addView(name);
        }
    }

    public static UsersFragment newInstance() {
        return new UsersFragment();
    }
}
