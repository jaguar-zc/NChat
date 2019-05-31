package org.flyants.book.view.setting.privacy;

import android.widget.LinearLayout;
import android.widget.Switch;

import org.flyants.book.R;
import org.flyants.common.mvp.impl.BaseActivity;

import butterknife.BindView;

public class PrivacyView extends BaseActivity<PrivacyPresenter> implements UIPrivacyView {

    @BindView(R.id.item_add_friends_type) LinearLayout item_add_friends_type;
    @BindView(R.id.add_my_friends_verify)  Switch add_my_friends_verify;
    @BindView(R.id.item_contact_black) LinearLayout item_contact_black;
    @BindView(R.id.item_layout_line_4)  LinearLayout item_layout_line_4;
    @BindView(R.id.item_layout_line_5)  LinearLayout item_layout_line_5;

    @BindView(R.id.allow_tome_recommended_group)  Switch allow_tome_recommended_group;

    @Override
    public PrivacyPresenter buildPresenter() {
        return new PrivacyPresenter(this,this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.privacy;
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
}
