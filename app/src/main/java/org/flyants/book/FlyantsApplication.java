package org.flyants.book;

import android.app.Application;

public class FlyantsApplication extends Application {
    static FlyantsApplication flyantsApplication;


    @Override
    public void onCreate() {
        super.onCreate();
        flyantsApplication = this;
    }

    public static FlyantsApplication getFlyantsApplication() {
        return flyantsApplication;
    }
}
