package org.flyants.book.view.my.meinfo;

import android.app.Activity;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import org.flyants.book.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MeInfoHeaderView {

    View rootView;

    MeInfoPrecenter presenter;
    RecyclerView recycler_view;

    @BindView(R.id.icon) ImageView icon;
    @BindView(R.id.nickName)  TextView nickName;
    @BindView(R.id.chat_no)  TextView chat_no;
    @BindView(R.id.people_introduction)  TextView people_introduction;
    @BindView(R.id.peopleAssistCount)  TextView peopleAssistCount;
    @BindView(R.id.peopleAssist)  ImageView peopleAssist;
    @BindView(R.id.send_message) ImageView send_message;
    @BindView(R.id.send_dynamic) ImageView send_dynamic;
    @BindView(R.id.edit_people_info) ImageView edit_people_info;

    @BindView(R.id.dynamic_lable) TextView dynamic_lable;
    @BindView(R.id.info_lable)  TextView info_lable;

    @BindView(R.id.basic_info_layout) LinearLayout basic_info_layout;
    @BindView(R.id.location)  TextView location;

    public MeInfoHeaderView(Activity activity) {
        rootView = LayoutInflater.from(activity).inflate(R.layout.me_info_header, null ,false);
        ButterKnife.bind(this,rootView);
    }

    public void setPresenter(MeInfoPrecenter presenter) {
        this.presenter = presenter;
    }

    public void setRecycler_view(RecyclerView recycler_view) {
        this.recycler_view = recycler_view;
    }

    @OnClick(R.id.info_lable)
    public void info_lable(){
        dynamic_lable.setTypeface(Typeface.DEFAULT);
        info_lable.setTypeface(Typeface.DEFAULT_BOLD);
        basic_info_layout.setVisibility(View.VISIBLE);
        recycler_view.setVisibility(View.GONE);
    }

    @OnClick(R.id.dynamic_lable)
    public void dynamic_lable(){
        dynamic_lable.setTypeface(Typeface.DEFAULT_BOLD);
        info_lable.setTypeface(Typeface.DEFAULT);
        recycler_view.setVisibility(View.VISIBLE);
        basic_info_layout.setVisibility(View.GONE);
    }


    @OnClick(R.id.send_message)
    public void send_message() {
    }

    @OnClick(R.id.send_dynamic)
    public void send_dynamic() {
    }

    @OnClick(R.id.edit_people_info)
    public void edit_people_info() {
    }

    @OnClick(R.id.peopleAssist)
    public void onClickPeopleAssist() {
        this.presenter.peopleAssist();
    }



}
