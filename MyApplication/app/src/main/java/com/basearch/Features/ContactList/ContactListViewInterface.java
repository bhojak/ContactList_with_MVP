package com.basearch.Features.ContactList;

import com.basearch.DataTypes.Users;

import java.util.List;

/**
 * Created by Bhupen on 06/06/2017.
 */

public interface ContactListViewInterface {

    //void showPosts(List<Post> posts);

    void showPosts(List<Users> users);

    void showError(String message);

    void showComplete();
}
