package org.flyants.book.view.setting.msgnotice;

import android.widget.CompoundButton;
import android.widget.Switch;

import org.flyants.book.R;
import org.flyants.book.custom.Header;
import org.flyants.common.mvp.impl.BaseActivity;

import butterknife.BindView;
import butterknife.OnCheckedChanged;

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
    public void setViewAttrs(Integer messageNotifyShake, Integer messageNotifyVoice) {
        message_notify_voice.setChecked(messageNotifyVoice == 1);
        message_notify_shake.setChecked(messageNotifyShake == 1);
    }

    @Override
    public void onViewStart() {

    }

    @OnCheckedChanged(R.id.message_notify_voice)
    public void onMessageNotifyVoice(CompoundButton buttonView, boolean isChecked){
        getPresenter().setMessageNotifyVoice(isChecked);
    }

    @OnCheckedChanged(R.id.message_notify_shake)
    public void onMessageNotifyShake(CompoundButton buttonView, boolean isChecked){
        getPresenter().setMessageNotifyShake(isChecked);
    }

    @Override
    public void onViewDestroy() {

    }
}
