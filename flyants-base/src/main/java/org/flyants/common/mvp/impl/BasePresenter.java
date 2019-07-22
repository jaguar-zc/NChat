package org.flyants.common.mvp.impl;

import android.app.Activity;
import android.content.Context;

import androidx.fragment.app.Fragment;

import org.flyants.common.mvp.PrecenterEvent;


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
    }

}
