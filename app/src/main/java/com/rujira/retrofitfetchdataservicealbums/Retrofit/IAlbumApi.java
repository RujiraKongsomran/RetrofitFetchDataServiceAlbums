package com.rujira.retrofitfetchdataservicealbums.Retrofit;

import com.rujira.retrofitfetchdataservicealbums.Model.Album;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface IAlbumApi {
    @GET("albums")
    Observable<List<Album>> getData();


}
