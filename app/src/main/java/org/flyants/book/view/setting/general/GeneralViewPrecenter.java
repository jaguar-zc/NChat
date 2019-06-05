package org.flyants.book.view.setting.general;

import org.flyants.book.store.AppConfigStrore;
import org.flyants.common.mvp.impl.BasePresenter;

class GeneralViewPrecenter extends BasePresenter<GeneralView, UIGeneralView> implements AppConfigStrore.OnAppConfigStrore {


    public GeneralViewPrecenter(GeneralView t, UIGeneralView uiGeneralView) {
        super(t, uiGeneralView);
    }

    @Override
    public void onViewInit() {
        AppConfigStrore.me.loaderAppConfig(context,this);
    }

    @Override
    public void OnAppConfigStrore(AppConfigStrore appConfigStrore) {
        uiView.setViewAttrs(appConfigStrore.getDynameicVideoPlayNet());
    }

    @Override
    public void onViewStart() {

    }

    @Override
    public void onViewDestroy() {

    }
}
