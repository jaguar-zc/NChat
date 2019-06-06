package org.flyants.book.view.setting.msgnotice;

import org.flyants.book.dto.PeopleAppConfig;
import org.flyants.book.store.AppConfigStrore;
import org.flyants.common.mvp.impl.BasePresenter;
import org.flyants.common.store.OnCallback;

class MsgNoticePresenter extends BasePresenter<MsgNoticeView,UIMsgNotice> implements OnCallback<PeopleAppConfig> {


    public MsgNoticePresenter(MsgNoticeView t, UIMsgNotice uiMsgNotice) {
        super(t, uiMsgNotice);
    }

    @Override
    public void onViewInit() {
        AppConfigStrore.getInstance().loadObject(context,this);
    }

    @Override
    public void call(PeopleAppConfig config) {
        uiView.setViewAttrs(config.getMessageNotifyShake(),config.getMessageNotifyVoice());
    }

    @Override
    public void onViewStart() {

    }

    @Override
    public void onViewDestroy() {

    }

    public void setMessageNotifyVoice(Boolean checked) {
        AppConfigStrore.getInstance().loadObject(context, new OnCallback<PeopleAppConfig>() {
            @Override
            public void call(PeopleAppConfig appConfig) {
                appConfig.setMessageNotifyVoice(checked?1:0);
                AppConfigStrore.getInstance().update(appConfig);
            }
        });
    }

    public void setMessageNotifyShake(Boolean checked) {
        AppConfigStrore.getInstance().loadObject(context, new OnCallback<PeopleAppConfig>() {
            @Override
            public void call(PeopleAppConfig appConfig) {
                appConfig.setMessageNotifyShake(checked?1:0);
                AppConfigStrore.getInstance().update(appConfig);
            }
        });
    }
}
