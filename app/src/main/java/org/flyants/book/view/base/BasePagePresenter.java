package org.flyants.book.view.base;


import com.liaoinstan.springview.widget.SpringView;

import org.flyants.book.network.okhttp.RespCall;
import org.flyants.book.utils.Page;
import org.flyants.common.mvp.impl.BasePresenter;

import java.util.List;

import retrofit2.Call;

public  abstract class BasePagePresenter<V,UI,DATA> extends BasePresenter<V,UI> implements  SpringView.OnFreshListener {


    public int page = 1;

    public BasePagePresenter(V t, UI ui) {
        super(t, ui);
    }

    public abstract Call<Page<DATA>> getPageProvider();

    public void onLoadDataList(){
        getPageProvider().enqueue(new RespCall<Page<DATA>>() {
            @Override
            public void onResp(Page<DATA> resp) {
                onNextPage(page,resp.getRows());
                if (resp.getRows().size() > 0) {
                    page ++;
                }
            }
        });
    }


    @Override
    public void onViewStart() {

    }

    @Override
    public void onRefresh() {
                page = 1;
        onLoadDataList();
    }

    @Override
    public void onLoadmore() {
        onLoadDataList();
    }

    @Override
    public void onViewInit() {

    }

    @Override
    public void onViewDestroy() {

    }

    public abstract void onNextPage(int page , List<DATA> list);
}
