package org.flyants.book.view.conversation;

import com.liaoinstan.springview.widget.SpringView;

import org.flyants.book.network.RequestUtils;
import org.flyants.book.resources.Apis;
import org.flyants.book.utils.Page;
import org.flyants.book.view.base.BasePagePresenter;
import org.flyants.book.view.experience.FoundDto;
import org.flyants.common.mvp.PrecenterEvent;

import java.util.List;

import retrofit2.Call;

class ConversationPrecenter extends BasePagePresenter<ConversationView, UIConversationView, FoundDto> implements PrecenterEvent , SpringView.OnFreshListener{


    Apis apis;


    public ConversationPrecenter(ConversationView t, UIConversationView uiExperienceView) {
        super(t, uiExperienceView);
    }

    @Override
    public Call<Page<FoundDto>> getPageProvider() {
        return apis.getFoundPageList(page);
    }

    @Override
    public void onNextPage(int page, List list) {
        uiView.setPullLoadMoreCompleted(page,list);
    }

    @Override
    public void onViewInit() {
        apis = RequestUtils.build(Apis.class);
    }

    @Override
    public void onViewDestroy() {

    }

    @Override
    public void onLoadmore() {

    }
}
