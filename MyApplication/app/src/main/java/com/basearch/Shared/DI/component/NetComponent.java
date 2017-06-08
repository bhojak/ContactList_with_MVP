package com.basearch.Shared.DI.component;

import com.basearch.Shared.DI.modules.AppModule;
import com.basearch.Shared.DI.modules.NetModule;

import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;

/**
 * Created by Bhupen on 06/06/2017.
 */
@Singleton
@Component(modules = {AppModule.class, NetModule.class})
public interface NetComponent {

    // downstream components need these exposed with the return type
    // method name does not really matter
    Retrofit retrofit();
}
