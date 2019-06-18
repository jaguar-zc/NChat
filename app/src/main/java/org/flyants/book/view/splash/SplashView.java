package org.flyants.book.view.splash;

import android.content.Intent;
import android.view.WindowManager;

import org.flyants.book.R;
import org.flyants.book.view.index.Home;
import org.flyants.common.mvp.impl.BaseActivity;

public class SplashView extends BaseActivity<SplashPrecenter> implements UISplashView {
    @Override
    public SplashPrecenter buildPresenter() {
        return new SplashPrecenter(this,this);
    }

    @Override
    public int getLayoutId() {
        getActivity().getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        return R.layout.splash;
    }

    @Override
    public void onViewInit() {
    }

    @Override
    public void onViewStart() {
        if (!getActivity().isTaskRoot()) {
            finish();
            return;
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                    Intent intent = new Intent(SplashView.this, Home.class);
                    startActivity(intent);
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    @Override
    public void onViewDestroy() {

    }

    @Override
    public void setVeiwAttrs(String resp) {

    }
}
