package org.flyants.book.view.setting.general;

import org.flyants.book.dto.PeopleAppConfig;
import org.flyants.book.store.AppConfigStrore;
import org.flyants.common.mvp.impl.BasePresenter;
import org.flyants.common.store.OnCallback;

class GeneralViewPrecenter extends BasePresenter<GeneralView, UIGeneralView>  {


    public GeneralViewPrecenter(GeneralView t, UIGeneralView uiGeneralView) {
        super(t, uiGeneralView);
    }

    @Override
    public void onViewInit() {
        AppConfigStrore.getInstance().loadObject(context, new OnCallback<PeopleAppConfig>() {
            @Override
            public void call(PeopleAppConfig appConfig) {
                uiView.setViewAttrs(appConfig.getDynameicVideoPlayNet());
            }
        });
    }

    @Override
    public void onViewStart() {

    }

    @Override
    public void onViewDestroy() {

    }

    public void setDynameicVideoPlayNet(int index) {
        AppConfigStrore.getInstance().loadObject(context, new OnCallback<PeopleAppConfig>() {
            @Override
            public void call(PeopleAppConfig appConfig) {
                appConfig.setDynameicVideoPlayNet(index);
                AppConfigStrore.getInstance().update(appConfig);
            }
        });
    }
}
