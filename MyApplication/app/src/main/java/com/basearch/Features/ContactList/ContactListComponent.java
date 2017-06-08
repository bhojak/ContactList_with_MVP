package com.basearch.Features.ContactList;

import com.basearch.Shared.DI.CustomScope;
import com.basearch.Shared.DI.component.NetComponent;

import dagger.Component;

/**
 * Created by Bhupen on 06/06/2017.
 */
@CustomScope
@Component(dependencies = NetComponent.class, modules = ContactListModule.class)
public interface ContactListComponent {

    void inject(ContactListActivity activity);
}
