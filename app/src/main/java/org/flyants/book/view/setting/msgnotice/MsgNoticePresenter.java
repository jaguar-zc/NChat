package org.flyants.book.view.setting.msgnotice;

import org.flyants.book.store.AppConfigStrore;
import org.flyants.common.mvp.impl.BasePresenter;

class MsgNoticePresenter extends BasePresenter<MsgNoticeView,UIMsgNotice> implements AppConfigStrore.OnAppConfigStrore {


    public MsgNoticePresenter(MsgNoticeView t, UIMsgNotice uiMsgNotice) {
        super(t, uiMsgNotice);
    }

    @Override
    public void onViewInit() {
        AppConfigStrore.me.loaderAppConfig(context,this);
    }

    @Override
    public void OnAppConfigStrore(AppConfigStrore appConfigStrore) {
        uiView.setViewAttrs(appConfigStrore.getMessageNotifyShake(),appConfigStrore.getMessageNotifyVoice());
    }

    @Override
    public void onViewStart() {

    }

    @Override
    public void onViewDestroy() {

    }

    public void setMessageNotifyVoice(Boolean checked) {
        AppConfigStrore.me.setMessageNotifyVoice(checked?1:0);
    }

    public void setMessageNotifyShake(Boolean checked) {
        AppConfigStrore.me.setMessageNotifyShake(checked?1:0);
    }
}
