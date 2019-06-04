package org.flyants.book.view.conversation;

import com.liaoinstan.springview.widget.SpringView;

import org.flyants.book.network.RequestUtils;
import org.flyants.book.network.okhttp.RespCall;
import org.flyants.book.resources.ConversationApis;
import org.flyants.book.utils.RespList;
import org.flyants.common.mvp.impl.BasePresenter;

class ConversationPrecenter extends BasePresenter<ConversationView, UIConversationView> implements SpringView.OnFreshListener{

    ConversationApis conversationApis;

    public ConversationPrecenter(ConversationView t, UIConversationView uiExperienceView) {
        super(t, uiExperienceView);
    }

    @Override
    public void onRefresh() {
        conversationApis.getConversationList().enqueue(new RespCall<RespList<ConversationResp>>() {
            @Override
            public void onResp(RespList<ConversationResp> resp) {
                uiView.setPullLoadMoreCompleted(0,resp);
            }
        });
    }

    @Override
    public void onLoadmore() {

    }

    @Override
    public void onViewStart() {

    }

    @Override
    public void onViewDestroy() {

    }

    @Override
    public void onViewInit() {
        conversationApis = RequestUtils.build(ConversationApis.class);
    }


}
