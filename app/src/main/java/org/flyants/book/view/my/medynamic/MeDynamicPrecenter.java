package org.flyants.book.view.my.medynamic;

import org.flyants.book.network.RequestUtils;
import org.flyants.book.resources.DynamicApis;
import org.flyants.book.utils.Page;
import org.flyants.book.view.base.BasePagePresenter;
import org.flyants.book.view.dynamic.DynamicResp;

import java.util.List;

import retrofit2.Call;

class MeDynamicPrecenter extends BasePagePresenter<MeDynamicView, UIMeDynamicView, DynamicResp> {

    DynamicApis dynamicApis ;

    public MeDynamicPrecenter(MeDynamicView t, UIMeDynamicView uiMeDynamicView) {
        super(t, uiMeDynamicView);
    }

    @Override
    public void onViewInit() {
        super.onViewInit();
        dynamicApis = RequestUtils.build(DynamicApis.class);
    }

    @Override
    public Call<Page<DynamicResp>> getPageProvider() {
        return dynamicApis.getDynamicListBySelf(page);
    }

    @Override
    public void onNextPage(int page, List<DynamicResp> list) {
        uiView.setPullLoadMoreCompleted(page,list);
    }

}
