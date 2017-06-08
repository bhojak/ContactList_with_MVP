package com.basearch.Features.ContactList;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.basearch.BaseArchApp;
import com.basearch.DataTypes.Users;
import com.basearch.R;
import com.basearch.Shared.interfaces.ClickListener;
import com.basearch.Shared.interfaces.RecyclerTouchListener;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by Bhupen on 06/06/2017.
 */

public class ContactListActivity extends AppCompatActivity implements ContactListViewInterface {

    private RecyclerView contactRecyclerView;

    private LinearLayoutManager mLinearLayoutManager;

    @Inject
   ContactListLogicImpl mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contactRecyclerView = (RecyclerView) findViewById(R.id.activity_contact_recyclerView);
        mLinearLayoutManager = new LinearLayoutManager(this);
        contactRecyclerView.setLayoutManager(mLinearLayoutManager);

        DaggerContactListComponent.builder()
                .netComponent(((BaseArchApp) getApplicationContext()).getNetComponent())
                .contactListModule(new ContactListModule(this))
                .build().inject(this);

        contactRecyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), contactRecyclerView, new ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Toast.makeText(getApplicationContext(), "Row no "+ position +" is selected!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
        mainPresenter.loadPost();
    }

    @Override
    public void showPosts(List<Users> users) {

        ContactListAdapter adapter = new ContactListAdapter();
        contactRecyclerView.setAdapter(adapter);
        adapter.setUsersList(users);
    }

    @Override
    public void showError(String message) {
        //Show error message Toast
        Toast.makeText(getApplicationContext(), "Error" + message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showComplete() {
        //Show completed message Toast
        Toast.makeText(getApplicationContext(), "Complete", Toast.LENGTH_SHORT).show();
    }

}
