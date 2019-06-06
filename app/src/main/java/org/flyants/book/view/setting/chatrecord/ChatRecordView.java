package org.flyants.book.view.setting.chatrecord;

import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.Switch;

import org.flyants.book.R;
import org.flyants.book.custom.Header;
import org.flyants.common.mvp.impl.BaseActivity;

import butterknife.BindView;
import butterknife.OnCheckedChanged;

public class ChatRecordView extends BaseActivity<ChatRecordPresenter> implements UIChatRecord {

    @BindView(R.id.idHeader) Header idHeader;

    @BindView(R.id.message_cloud_store)  Switch message_cloud_store;
    @BindView(R.id.download_layout)  LinearLayout download_layout;


    @Override
    public ChatRecordPresenter buildPresenter() {
        return new ChatRecordPresenter(this,this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.msg_record;
    }

    @Override
    public void onViewInit() {
        idHeader.setHeaderTitle("聊天记录管理");
    }


    @Override
    public void setViewAttrs(Integer chatRecordCloudStore) {
        message_cloud_store.setChecked(chatRecordCloudStore == 1);
    }

    @OnCheckedChanged(R.id.message_notify_shake)
    public void onMessageCloudStore(CompoundButton buttonView, boolean isChecked){
        getPresenter().setMessageCloudStore(isChecked);
    }

    @Override
    public void onViewStart() {

    }

    @Override
    public void onViewDestroy() {

    }
}
