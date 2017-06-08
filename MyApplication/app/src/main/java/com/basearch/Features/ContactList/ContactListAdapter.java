package com.basearch.Features.ContactList;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.basearch.DataTypes.Users;
import com.basearch.R;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.display.CircleBitmapDisplayer;

import java.util.Collections;
import java.util.List;

/**
 * Created by Bhupen on 07/06/2017.
 */

public class ContactListAdapter extends RecyclerView.Adapter<ContactListViewHolder> {

    private List<Users> contactUsersList;
    private DisplayImageOptions options;

    public ContactListAdapter() {
        this.contactUsersList = Collections.emptyList();

        options = new DisplayImageOptions.Builder()
                .cacheInMemory(true)
                .cacheOnDisk(true)
                .considerExifParams(true)
                .displayer(new CircleBitmapDisplayer(Color.WHITE, 5))
                .build();
    }

    @Override
    public ContactListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View row = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_user, null, false);
        return new ContactListViewHolder(row);
    }

    @Override
    public void onBindViewHolder(ContactListViewHolder holder, int position) {

        // this is for Users list
        Users userCL = contactUsersList.get(position);


        holder.getName().setText(userCL.name);
        holder.getSurname().setText(userCL.username);

        String url = "http://api.adorable.io/avatars/32/" + userCL.email+ ".png";
        ImageLoader.getInstance().displayImage(url, holder.getPhoto(), options);
    }

    @Override
    public int getItemCount() {
        return contactUsersList.size();
    }


    public void setUsersList(List<Users> mList) {
        contactUsersList = mList;
        notifyDataSetChanged();
    }


}
