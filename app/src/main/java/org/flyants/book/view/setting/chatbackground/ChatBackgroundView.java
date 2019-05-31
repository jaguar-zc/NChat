package org.flyants.book.view.setting.chatbackground;

import org.flyants.book.R;
import org.flyants.book.custom.Header;
import org.flyants.common.mvp.impl.BaseActivity;

import butterknife.BindView;

public class ChatBackgroundView extends BaseActivity<ChatBackgroundViewPrecenter> implements UIChatBackgroundView {

    @BindView(R.id.idHeader)
    Header idHeader;
    @Override
    public int getStatusBarColor() {
        return R.color.chat_background_color;
    }

    @Override
    public ChatBackgroundViewPrecenter buildPresenter() {
        return new ChatBackgroundViewPrecenter(this,this);
    }

    @Override
    public Boolean isTextDark() {
        return false;
    }

    @Override
    public int getLayoutId() {
        return R.layout.chat_background;
    }

    @Override
    public void onViewInit() {
        idHeader.setHeaderTitle("聊天背景图");
        idHeader.setTitleColor(R.color.white);
        idHeader.setBackgrundColor(R.color.chat_background_color);
        idHeader.setBackColorWhite();
    }

    @Override
    public void onViewStart() {

    }

    @Override
    public void onViewDestroy() {

    }
}
