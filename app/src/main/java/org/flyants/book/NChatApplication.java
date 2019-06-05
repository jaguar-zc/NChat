package org.flyants.book;

import android.app.Application;

public class NChatApplication extends Application {


    static NChatApplication flyantsApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        flyantsApplication = this;
    }

    public static NChatApplication getFlyantsApplication() {
        return flyantsApplication;
    }
}
