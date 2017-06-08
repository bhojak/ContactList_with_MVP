package com.basearch.Features.ContactList;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.basearch.R;

/**
 * Created by Bhupen on 07/06/2017.
 */

public class ContactListViewHolder extends RecyclerView.ViewHolder  {

    private ImageView mPhoto;
    private TextView name, surname;

    public ContactListViewHolder(View itemView) {
        super(itemView);
        mPhoto = (ImageView) itemView.findViewById(R.id.profile_photo);
        name = (TextView) itemView.findViewById(R.id.name);
        surname = (TextView) itemView.findViewById(R.id.surname);
    }

    public TextView getName() {
        return name;
    }

    public TextView getSurname() {
        return surname;
    }

    public ImageView getPhoto() {
        return mPhoto;
    }


}
