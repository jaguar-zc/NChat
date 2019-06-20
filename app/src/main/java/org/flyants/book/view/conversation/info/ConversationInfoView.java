package org.flyants.book.view.conversation.info;

import org.flyants.book.R;
import org.flyants.book.custom.Header;
import org.flyants.common.mvp.impl.BaseActivity;

import butterknife.BindView;

public class ConversationInfoView extends BaseActivity<ConversationInfoPrecenter> implements UIConversationInfoView {

    @BindView(R.id.idHeader)
    Header header;
    @Override
    public ConversationInfoPrecenter buildPresenter() {
        return new ConversationInfoPrecenter(this,this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.comversation_info;
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
