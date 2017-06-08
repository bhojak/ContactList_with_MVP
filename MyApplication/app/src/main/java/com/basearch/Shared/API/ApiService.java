package com.basearch.Shared.API;

import com.basearch.DataTypes.Users;

import java.util.List;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by Bhupen on 06/06/2017.
 */

public interface ApiService {

        @GET("users")
        Observable<List<Users>> getUsersList();

}
