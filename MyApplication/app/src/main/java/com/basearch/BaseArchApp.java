package com.basearch;

import android.app.Application;
import android.content.Context;

import com.basearch.Shared.DI.component.DaggerNetComponent;
import com.basearch.Shared.DI.component.NetComponent;
import com.basearch.Shared.DI.modules.AppModule;
import com.basearch.Shared.DI.modules.NetModule;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;

/**
 * Created by Bhupen on 20/05/2017.
 */

public class BaseArchApp extends Application {

    private NetComponent mNetComponent;

   // final String URL = "http://api.randomuser.me/?results=10&nat=en";

    @Override
    public void onCreate() {
        super.onCreate();
        mNetComponent = DaggerNetComponent.builder()
                .appModule(new AppModule(this))
                .netModule(new NetModule("http://jsonplaceholder.typicode.com/"))
                .build();

        // UNIVERSAL IMAGE LOADER SETUP
        initImageLoader(getApplicationContext());
    }

    public NetComponent getNetComponent() {
        return mNetComponent;
    }

    public static void initImageLoader(Context context) {
        // This configuration tuning is custom. You can tune every option, you may tune some of them,
        // or you can create default configuration by
        //  ImageLoaderConfiguration.createDefault(this);
        // method.
        ImageLoaderConfiguration.Builder config = new ImageLoaderConfiguration.Builder(context);
        config.threadPriority(Thread.NORM_PRIORITY - 2);
        config.denyCacheImageMultipleSizesInMemory();
        config.diskCacheFileNameGenerator(new Md5FileNameGenerator());
        config.diskCacheSize(50 * 1024 * 1024); // 50 MiB
        config.tasksProcessingOrder(QueueProcessingType.LIFO);
        config.writeDebugLogs(); // Remove for release app

        // Initialize ImageLoader with configuration.
        ImageLoader.getInstance().init(config.build());
    }
}
