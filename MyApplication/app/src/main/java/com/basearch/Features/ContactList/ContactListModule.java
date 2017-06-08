package com.basearch.Features.ContactList;

import com.basearch.Shared.DI.CustomScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Bhupen on 06/06/2017.
 */
@Module
public class ContactListModule {

    private ContactListViewInterface view;

    public ContactListModule(ContactListViewInterface view) {
        this.view = view;
    }

    @Provides
    @CustomScope
    ContactListViewInterface providesContactListViewInterface() {
        return view;
    }
}
