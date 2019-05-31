package org.flyants.book.view.setting.general;

import android.content.Intent;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.flyants.book.R;
import org.flyants.book.view.setting.chatbackground.ChatBackgroundView;
import org.flyants.book.view.setting.privacy.PrivacyView;
import org.flyants.common.mvp.impl.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class GeneralView extends BaseActivity<GeneralViewPrecenter> implements UIGeneralView {


    @BindView(R.id.item_setting_background) LinearLayout item_setting_background;
    @BindView(R.id.item_setting_auto_video) LinearLayout item_setting_auto_video;

    @Override
    public GeneralViewPrecenter buildPresenter() {
        return new GeneralViewPrecenter(this,this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.general;
    }

    @Override
    public void onViewInit() {

    }

    @Override
    public void onViewStart() {

    }

    @Override
    public void onViewDestroy() {

    }


    @OnClick(R.id.item_setting_background)
    public void onClickitem_setting_background(){
        startActivity(new Intent(getActivity(), ChatBackgroundView.class));
    }
}
