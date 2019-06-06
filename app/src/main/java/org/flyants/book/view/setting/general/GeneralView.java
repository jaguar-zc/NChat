package org.flyants.book.view.setting.general;

import android.content.Intent;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.flyants.book.R;
import org.flyants.book.custom.Header;
import org.flyants.book.store.AppConfigStrore;
import org.flyants.book.view.setting.chatbackground.ChatBackgroundView;
import org.flyants.common.mvp.impl.BaseActivity;
import org.flyants.component.selected.OnSelectedItem;
import org.flyants.component.selected.SelectedViewUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class GeneralView extends BaseActivity<GeneralViewPrecenter> implements UIGeneralView {

    @BindView(R.id.idHeader)  Header idHeader;
    @BindView(R.id.item_setting_background) LinearLayout item_setting_background;
    @BindView(R.id.item_setting_auto_video) LinearLayout item_setting_auto_video;
    @BindView(R.id.item_setting_auto_video_lable) TextView item_setting_auto_video_lable;

    List<Object> list = new ArrayList<Object>();
    {
        list.add("仅WI-FI");
        list.add("移动网络和WI-FI");
        list.add("关闭");
    }


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
        idHeader.setHeaderTitle("通用");
    }

    @Override
    public void onViewStart() {

    }

    @Override
    public void setViewAttrs(Integer dynameicVideoPlayNet) {
        item_setting_auto_video_lable.setText(list.get(dynameicVideoPlayNet)+"");
    }

    @Override
    public void onViewDestroy() {

    }





    @OnClick(R.id.item_setting_auto_video)
    public void onClickitem_setting_auto_video(){
        SelectedViewUtils.show(this, list, new OnSelectedItem() {
            @Override
            public void onSelected(int index) {
                setViewAttrs(index);
                getPresenter().setDynameicVideoPlayNet(index);
            }
        });
    }

    @OnClick(R.id.item_setting_background)
    public void onClickitem_setting_background(){
        startActivity(new Intent(getActivity(), ChatBackgroundView.class));
    }
}
