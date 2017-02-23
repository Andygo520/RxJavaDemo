package com.example.administrator.rxjavademo;


import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Administrator on 2017/2/16.
 */
public interface DouBanApi {
     @GET("v2/movie/subject/{id}")
     public Observable<Movie> getMovie(@Path("id") int id);
}
