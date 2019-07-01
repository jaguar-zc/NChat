package org.flyants.book.view.search.global;

import org.flyants.common.mvp.impl.BaseActivity;

public class GlobalSearchView extends BaseActivity<GlobalSearchPrecenter> implements UIGlobalSearchView {


    @Override
    public GlobalSearchPrecenter buildPresenter() {
        return new GlobalSearchPrecenter(this,this);
    }

    @Override
    public int getLayoutId() {
        return 0;
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
