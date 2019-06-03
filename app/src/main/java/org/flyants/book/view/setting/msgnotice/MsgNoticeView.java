package org.flyants.book.view.setting.msgnotice;

import android.widget.Switch;

import org.flyants.book.R;
import org.flyants.book.custom.Header;
import org.flyants.common.mvp.impl.BaseActivity;

import butterknife.BindView;

public class MsgNoticeView  extends BaseActivity<MsgNoticePresenter> implements UIMsgNotice {
    @BindView(R.id.idHeader) Header idHeader;

    @BindView(R.id.message_notify_voice)  Switch  message_notify_voice;
    @BindView(R.id.message_notify_shake)  Switch  message_notify_shake;


    @Override
    public MsgNoticePresenter buildPresenter() {
        return new MsgNoticePresenter(this,this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.msg_notice;
    }

    @Override
    public void onViewInit() {
        idHeader.setHeaderTitle("新消息通知");
    }

    @Override
    public void onViewStart() {

    }

    @Override
    public void onViewDestroy() {

    }
}
