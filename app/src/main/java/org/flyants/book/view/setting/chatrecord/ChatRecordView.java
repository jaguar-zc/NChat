package org.flyants.book.view.setting.chatrecord;

import android.widget.LinearLayout;
import android.widget.Switch;

import org.flyants.book.R;
import org.flyants.common.mvp.impl.BaseActivity;

import butterknife.BindView;

public class ChatRecordView extends BaseActivity<ChatRecordPresenter> implements UIChatRecord {



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

    }

    @Override
    public void onViewStart() {

    }

    @Override
    public void onViewDestroy() {

    }
}
