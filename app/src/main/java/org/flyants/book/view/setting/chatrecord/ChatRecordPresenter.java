package org.flyants.book.view.setting.chatrecord;

import org.flyants.book.dto.PeopleAppConfig;
import org.flyants.book.store.AppConfigStrore;
import org.flyants.common.mvp.impl.BasePresenter;
import org.flyants.common.store.OnCallback;

class ChatRecordPresenter extends BasePresenter<ChatRecordView, UIChatRecord> {


    public ChatRecordPresenter(ChatRecordView t, UIChatRecord uiMsgRecord) {
        super(t, uiMsgRecord);
    }

    @Override
    public void onViewInit() {
        AppConfigStrore.getInstance().loadObject(context, new OnCallback<PeopleAppConfig>() {
            @Override
            public void call(PeopleAppConfig appConfig) {
                uiView.setViewAttrs(appConfig.getChatRecordCloudStore());
            }
        });
    }

    @Override
    public void onViewStart() {

    }

    @Override
    public void onViewDestroy() {

    }

    public void setMessageCloudStore(boolean isChecked) {
        AppConfigStrore.getInstance().loadObject(context, new OnCallback<PeopleAppConfig>() {
            @Override
            public void call(PeopleAppConfig appConfig) {
                appConfig.setChatRecordCloudStore(isChecked ? 1 : 0);
                AppConfigStrore.getInstance().update(appConfig);
            }
        });
    }
}
