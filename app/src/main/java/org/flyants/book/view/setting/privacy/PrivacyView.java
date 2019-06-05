package org.flyants.book.view.setting.privacy;

import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.Switch;

import org.flyants.book.R;
import org.flyants.book.custom.Header;
import org.flyants.common.mvp.impl.BaseActivity;

import butterknife.BindView;
import butterknife.OnCheckedChanged;

public class PrivacyView extends BaseActivity<PrivacyPresenter> implements UIPrivacyView {

    @BindView(R.id.idHeader) Header idHeader;
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
        idHeader.setHeaderTitle("隐私保护中心");
    }

    @Override
    public void onViewStart() {

    }

    @Override
    public void setViewAttrs(Integer addMyFriendsVerify, Integer allowTomeRecommendedGroup) {
        add_my_friends_verify.setChecked(addMyFriendsVerify == 1);
        allow_tome_recommended_group.setChecked(allowTomeRecommendedGroup == 1);
    }

    @OnCheckedChanged(R.id.add_my_friends_verify)
    public void onAddMyFriendsVerify(CompoundButton buttonView, boolean isChecked){
        getPresenter().setAddMyFriendsVerify(isChecked);
    }

    @OnCheckedChanged(R.id.allow_tome_recommended_group)
    public void onAllowTomeRecommendedGroup(CompoundButton buttonView, boolean isChecked){
        getPresenter().setAllowTomeRecommendedGroup(isChecked);
    }

    @Override
    public void onViewDestroy() {

    }
}
