package org.flyants.book.view.setting.about;

import org.flyants.book.R;
import org.flyants.book.custom.Header;
import org.flyants.common.mvp.impl.BaseActivity;

import butterknife.BindView;

public class AboutView extends BaseActivity<AboutPrecenter> implements UIAboutView {

    @BindView(R.id.idHeader)
    Header idHeader;

    @Override
    public AboutPrecenter buildPresenter() {
        return new AboutPrecenter(this,this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.about;
    }

    @Override
    public void onViewInit() {
        idHeader.setHeaderTitle(getString(R.string.about));
    }

    @Override
    public void onViewStart() {

    }

    @Override
    public void onViewDestroy() {

    }
}
