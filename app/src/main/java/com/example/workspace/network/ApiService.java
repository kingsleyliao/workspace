package com.example.workspace.network;

import com.example.workspace.models.Post;
import com.example.workspace.models.User;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiService {
    @GET("posts")
    Observable<List<Post>> fetchPosts();

    @GET("users")
    Observable<List<User>>fetchUsers();
}
