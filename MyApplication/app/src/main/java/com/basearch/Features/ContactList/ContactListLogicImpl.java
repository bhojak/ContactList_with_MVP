package com.basearch.Features.ContactList;

import com.basearch.DataTypes.Users;
import com.basearch.Shared.API.ApiService;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Retrofit;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Bhupen on 06/06/2017.
 */

public class ContactListLogicImpl implements ContactListLogicInterface {

    public Retrofit retrofit;
    private ContactListViewInterface view;

    @Inject
    public ContactListLogicImpl(Retrofit retrofit, ContactListViewInterface view) {
        this.retrofit = retrofit;
        this.view = view;
    }


    @Override
    public void loadPost() {
        retrofit.create(ApiService.class).getUsersList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
                .subscribe(new Observer<List<Users>>() {
                    @Override
                    public void onCompleted() {
                        view.showComplete();
                    }

                    @Override
                    public void onError(Throwable e) {
                        view.showError(e.getMessage());
                    }

                    @Override
                    public void onNext(List<Users> users) {
                        view.showPosts(users);
                    }
                });
    }
//
//    @Override
//    public void loadPost() {
//        retrofit.create(ApiService.class).getPostList()
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .unsubscribeOn(Schedulers.io())
//                .subscribe(new Observer<List<Post>>() {
//                    @Override
//                    public void onCompleted() {
//                        view.showComplete();
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        view.showError(e.getMessage());
//                    }
//
//                    @Override
//                    public void onNext(List<Post> posts) {
//                        view.showPosts(posts);
//                    }
//                });
//    }
}
