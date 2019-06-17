package org.flyants.book.view.my.extinfo;

import android.widget.LinearLayout;
import android.widget.TextView;

import org.flyants.book.R;
import org.flyants.book.view.my.UserInfo;
import org.flyants.common.mvp.impl.BaseFragment;

import butterknife.BindView;

public class ExtInfoView extends BaseFragment<ExtInfoPrecenter>  implements UIExtInfoView{


        @BindView(R.id.basic_info_layout)
        LinearLayout basic_info_layout;
    @BindView(R.id.location)
    TextView location;


    @Override
    protected ExtInfoPrecenter buildPresenter() {
        return new ExtInfoPrecenter(this,this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.extinfo;
    }

    @Override
    public void onViewInit() {

    }

    @Override
    public void setVeiwAttrs(UserInfo resp) {
        location.setText("所在地：   " + resp.getLocation() + "");
    }

    @Override
    public void onViewStart() {

    }

    @Override
    public void onViewDestroy() {

    }
}
