package org.flyants.book.view.setting.chatrecord;

import org.flyants.book.store.AppConfigStrore;
import org.flyants.common.mvp.impl.BasePresenter;

class ChatRecordPresenter extends BasePresenter<ChatRecordView, UIChatRecord> implements AppConfigStrore.OnAppConfigStrore {

    public ChatRecordPresenter(ChatRecordView t, UIChatRecord uiMsgRecord) {
        super(t, uiMsgRecord);
    }

    @Override
    public void onViewInit() {
        AppConfigStrore.me.loaderAppConfig(context,this);
    }

    @Override
    public void onViewStart() {

    }

    @Override
    public void OnAppConfigStrore(AppConfigStrore appConfigStrore) {
        uiView.setViewAttrs(appConfigStrore.getChatRecordCloudStore());
    }

    @Override
    public void onViewDestroy() {

    }

    public void setMessageCloudStore(boolean isChecked) {
        AppConfigStrore.me.setChatRecordCloudStore(isChecked?1:0);
    }
}
