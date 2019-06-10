package org.flyants.book.view.conversation.window;

import android.support.v7.widget.RecyclerView;

import com.liaoinstan.springview.widget.SpringView;

import org.flyants.book.R;
import org.flyants.book.custom.Header;
import org.flyants.book.view.conversation.ConversationResp;
import org.flyants.common.mvp.impl.BaseActivity;

import butterknife.BindView;

public class ConversationWindowView extends BaseActivity<ConversationWindowPrecenter> implements UIConversationWindowView {

    public static final String PARAM_NAME = "ConversationId";



    @BindView(R.id.idHeader) Header idHeader;


    public int getStatusBarColor(){
        return com.monke.basemvplib.R.color.white;
    }


    @Override
    public ConversationWindowPrecenter buildPresenter() {
        return new ConversationWindowPrecenter(this,this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.conversation_window;
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

    @Override
    public void setVeiwAttrs(ConversationResp resp) {
        idHeader.setHeaderTitle(resp.getName());
    }
}
