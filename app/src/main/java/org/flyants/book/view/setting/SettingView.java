package org.flyants.book.view.setting;

import android.content.Intent;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

import org.flyants.book.R;
import org.flyants.book.custom.Header;
import org.flyants.book.view.setting.accountsecurity.AccountSecurityView;
import org.flyants.book.view.setting.general.GeneralView;
import org.flyants.book.view.setting.msgnotice.MsgNoticeView;
import org.flyants.book.view.setting.chatrecord.ChatRecordView;
import org.flyants.book.view.setting.privacy.PrivacyView;
import org.flyants.common.mvp.impl.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class SettingView extends BaseActivity<SettingPresenter> implements UISettingView {

    @BindView(R.id.idHeader) Header idHeader;
    @BindView(R.id.setting_item_account) LinearLayout setting_item_account;
    @BindView(R.id.setting_item_chat_record)  LinearLayout setting_item_chat_record;
    @BindView(R.id.setting_item_message_notify)  LinearLayout setting_item_message_notify;
    @BindView(R.id.setting_item_privacy)  LinearLayout setting_item_privacy;
    @BindView(R.id.setting_item_general)  LinearLayout setting_item_general;
    @BindView(R.id.setting_item_share)  LinearLayout setting_item_share;
    @BindView(R.id.version_layout)  LinearLayout version_layout;
    @BindView(R.id.version)  TextView version;
    @BindView(R.id.logout)  TextView logout;

    @Override
    public SettingPresenter buildPresenter() {
        return new SettingPresenter(this,this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.setting;
    }

    @Override
    public void onViewInit() {
        idHeader.setHeaderTitle("设置");
    }

    @Override
    public void onViewStart() {

    }

    @Override
    public void onViewDestroy() {

    }

    @Override
    public void setVersionView(VersionResp resp) {
        version.setText(resp.getVersionName());
    }


    @OnClick(R.id.setting_item_account)
    public void onClickAccountSecurityView(){
        startActivity(new Intent(getActivity(), AccountSecurityView.class));
    }

    @OnClick(R.id.setting_item_chat_record)
    public void onClickMsgRecordView(){
        startActivity(new Intent(getActivity(), ChatRecordView.class));
    }

    @OnClick(R.id.setting_item_privacy)
    public void onClickPrivacyView(){
        startActivity(new Intent(getActivity(), PrivacyView.class));
    }

    @OnClick(R.id.setting_item_general)
    public void onClickGeneralView(){
        startActivity(new Intent(getActivity(), GeneralView.class));
    }



    @OnClick(R.id.setting_item_message_notify)
    public void onClickMsgNoticeView(){
        startActivity(new Intent(getActivity(), MsgNoticeView.class));
    }


    @OnClick(R.id.logout)
    public void onLogout(){
        getPresenter().logout();
    }



}
