package org.flyants.book.view.setting.blacklist;

import org.flyants.book.R;
import org.flyants.book.custom.Header;
import org.flyants.common.mvp.impl.BaseActivity;

import butterknife.BindView;

public class BlackListView extends BaseActivity<BlackListPrecenter>  implements UIBlackListView{

    @BindView(R.id.idHeader)
    Header idHeader;

    @Override
    public BlackListPrecenter buildPresenter() {
        return new BlackListPrecenter(this,this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.blacklist;
    }

    @Override
    public void onViewInit() {
        idHeader.setHeaderTitle("通讯录黑名单");
    }

    @Override
    public void onViewStart() {

    }

    @Override
    public void onViewDestroy() {

    }

    @Override
    public void setVeiwAttrs(Object resp) {

    }
}
