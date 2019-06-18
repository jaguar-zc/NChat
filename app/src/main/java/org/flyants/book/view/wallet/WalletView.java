package org.flyants.book.view.wallet;

import org.flyants.book.R;
import org.flyants.book.custom.Header;
import org.flyants.common.mvp.impl.BaseActivity;

import butterknife.BindView;

public class WalletView extends BaseActivity<WalletPrecenter> implements UIWalletView{

    @BindView(R.id.idHeader)
    Header idHeader;
    @Override
    public WalletPrecenter buildPresenter() {
        return new WalletPrecenter(this,this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.wallet;
    }

    @Override
    public void onViewInit() {
        idHeader.setHeaderTitle("钱包");
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
