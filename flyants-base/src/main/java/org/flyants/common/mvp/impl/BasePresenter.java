package org.flyants.common.mvp.impl;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;

import org.flyants.common.mvp.PrecenterEvent;
import org.flyants.common.mvp.ViewEvent;


public abstract class BasePresenter<View,UiView> implements PrecenterEvent {


    protected View view;
    protected UiView uiView;
    protected Context context;

    public BasePresenter(View t,UiView uiView) {
        this.view = t;
        if(view instanceof Fragment){
            this.context = ((Fragment) view).getContext();
        }else if(t instanceof Activity){
            this.context = (Activity) view;
        }
        this.uiView = uiView;
        onViewInit();
    }

}
