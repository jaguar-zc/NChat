package org.flyants.book.view.search.global;

import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.liaoinstan.springview.container.DefaultFooter;
import com.liaoinstan.springview.container.DefaultHeader;
import com.liaoinstan.springview.widget.SpringView;

import org.flyants.book.R;
import org.flyants.book.custom.Header;
import org.flyants.book.custom.ProxyRecyclerViewAdapter;
import org.flyants.common.mvp.impl.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class GlobalSearchView extends BaseActivity<GlobalSearchPrecenter> implements UIGlobalSearchView {


    @BindView(R.id.springView)  SpringView springView;
    @BindView(R.id.recycler_view)  RecyclerView recycler_view;
    @BindView(R.id.empty_layout)  LinearLayout empty_layout;
    @BindView(R.id.searchStr)  EditText searchStr;

    private GlobalSearchAdapter adapter;

    @Override
    public GlobalSearchPrecenter buildPresenter() {
        return new GlobalSearchPrecenter(this,this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.global_search;
    }

    @Override
    public void onViewInit() {
        recycler_view.setVisibility(View.GONE);
        empty_layout.setVisibility(View.VISIBLE);

        adapter = new GlobalSearchAdapter(recycler_view);
//        firendsListAdapter.setOnItemClickListener(this);
        ProxyRecyclerViewAdapter proxyRecyclerViewAdapter =  new ProxyRecyclerViewAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recycler_view.setLayoutManager(layoutManager);
        recycler_view.setAdapter(proxyRecyclerViewAdapter);
//        recyclerView.addItemDecoration( new DividerGridItemDecoration(this ));
        recycler_view.setItemAnimator( new DefaultItemAnimator());
        springView.setHeader(new DefaultHeader(this));
        springView.setFooter(new DefaultFooter(this));
        springView.setListener(getPresenter());
    }

    @Override
    public void onViewStart() {

    }

    @OnClick(R.id.cancel_btn)
    public void onClickCancel(){
        onBackPressed();
    }

    @Override
    public void onViewDestroy() {

    }
}
