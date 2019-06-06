package org.flyants.book.view.setting.privacy;

import android.content.Intent;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.Switch;

import org.flyants.book.R;
import org.flyants.book.custom.Header;
import org.flyants.book.store.AppConfigStrore;
import org.flyants.book.view.setting.addmetype.AddMeMethodView;
import org.flyants.common.mvp.impl.BaseActivity;
import org.flyants.component.selected.OnSelectedItem;
import org.flyants.component.selected.SelectedViewUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;

public class PrivacyView extends BaseActivity<PrivacyPresenter> implements UIPrivacyView {

    @BindView(R.id.idHeader) Header idHeader;
    @BindView(R.id.item_add_friends_type) LinearLayout item_add_friends_type;
    @BindView(R.id.add_my_friends_verify)  Switch add_my_friends_verify;
    @BindView(R.id.item_contact_black) LinearLayout item_contact_black;
    @BindView(R.id.item_layout_line_4)  LinearLayout item_layout_line_4;
    @BindView(R.id.item_layout_line_5)  LinearLayout item_layout_line_5;

    List<Object> list = new ArrayList<Object>();
    {
        list.add("移动网络和WI-FI");
        list.add("仅Wi-Fi");
        list.add("关闭");
    }

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


    @OnClick(R.id.item_add_friends_type)
    public void onClickitem_add_friends_type(){
        startActivity(new Intent(this, AddMeMethodView.class));
    }

    @Override
    public void onViewDestroy() {

    }
}
