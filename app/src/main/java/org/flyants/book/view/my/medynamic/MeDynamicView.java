package org.flyants.book.view.my.medynamic;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;

import org.flyants.book.R;
import org.flyants.book.view.dynamic.DynamicResp;
import org.flyants.common.mvp.impl.BaseFragment;

import java.util.List;

import butterknife.BindView;

public class MeDynamicView extends BaseFragment<MeDynamicPrecenter> implements UIMeDynamicView {
    MeDynamicAdapter adapter;

    @BindView(R.id.recycler_view)
    RecyclerView recycler_view;

    @Override
    protected MeDynamicPrecenter buildPresenter() {
        return new MeDynamicPrecenter(this,this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.me_dynamic;
    }

    @Override
    public void onViewInit() {

        adapter = new MeDynamicAdapter(recycler_view);


        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity() );
        layoutManager.setOrientation(OrientationHelper.VERTICAL);
        recycler_view.setLayoutManager(layoutManager);

//        ProxyRecyclerViewAdapter proxyAdapter = new ProxyRecyclerViewAdapter(adapter);
//        proxyAdapter.addHeaderView(meInfoHeader.rootView);
        recycler_view.setAdapter(adapter);
//        recyclerView.addItemDecoration( new DividerGridItemDecoration(this ));
//        recycler_view.setItemAnimator( new DefaultItemAnimator());
//        springView.setHeader(new EmptySpringHeader());
////        springView.setHeader(new DefaultHeader(getActivity()));
//        springView.setFooter(new DefaultFooter(getActivity()));
//        springView.setListener(getPresenter());
    }

    @Override
    public void setPullLoadMoreCompleted(int page, List<DynamicResp> list) {
        adapter.addDataList(list);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onViewStart() {
        getPresenter().onRefresh();
    }

    @Override
    public void onViewDestroy() {

    }
}
