package org.flyants.book.view.setting;

import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

import org.flyants.book.R;
import org.flyants.common.mvp.impl.BaseActivity;

import butterknife.BindView;

public class SettingView extends BaseActivity<SettingPresenter> implements UISettingView {

    @BindView(R.id.message_notify) Switch message_notify;
    @BindView(R.id.account_info)  LinearLayout account_info;
    @BindView(R.id.account_manager)  LinearLayout account_manager;
    @BindView(R.id.version_layout) LinearLayout version_layout;
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

}
