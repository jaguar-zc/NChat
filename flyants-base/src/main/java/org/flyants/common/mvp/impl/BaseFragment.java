package org.flyants.common.mvp.impl;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import org.flyants.common.mvp.PrecenterEvent;
import org.flyants.common.mvp.ViewEvent;

import java.util.Optional;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseFragment<P extends PrecenterEvent> extends Fragment implements ViewEvent {

    private Unbinder unbinder;

    private  P presenter;

    public int getStatusBarColor(){
        return Color.WHITE;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutId(), container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        onViewInit();
        buildPresenter();
        onViewStart();
        if(getPresenter() != null)
            getPresenter().onViewStart();

    }


    @Override
    public void startActivity(Intent intent) {
        super.startActivity(intent);
//        getActivity().overridePendingTransition(R.anim.right_to_left_in,R.anim.fake_anim);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        onViewDestroy();
        if(getPresenter() != null)
            getPresenter().onViewDestroy();
    }

    protected abstract P buildPresenter();

    public P getPresenter(){
        if(presenter == null){
            presenter = buildPresenter();
        }
        return presenter;
    }

    /**
     * onDestroyView中进行解绑操作
     */
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


}
