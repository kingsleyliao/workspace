package com.example.workspace.network;

import com.example.workspace.models.Post;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiService {
    @GET("posts")
    Observable<List<Post>> fetchPosts();
}
