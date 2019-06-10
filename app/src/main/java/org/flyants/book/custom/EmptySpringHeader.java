package org.flyants.book.custom;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.liaoinstan.springview.container.BaseHeader;

import org.flyants.book.R;

public class EmptySpringHeader extends BaseHeader {


    @Override
    public View getView(LayoutInflater inflater, ViewGroup viewGroup) {
        return LayoutInflater.from(inflater.getContext()).inflate(R.layout.empty_spring_header, null ,false);
    }

    @Override
    public void onPreDrag(View rootView) {

    }

    @Override
    public void onDropAnim(View rootView, int dy) {

    }

    @Override
    public void onLimitDes(View rootView, boolean upORdown) {

    }

    @Override
    public void onStartAnim() {

    }

    @Override
    public void onFinishAnim() {

    }
}
