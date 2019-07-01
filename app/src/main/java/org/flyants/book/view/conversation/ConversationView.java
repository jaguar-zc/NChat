package org.flyants.book.view.conversation;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;

import org.flyants.book.R;
import org.flyants.book.custom.ProxyRecyclerViewAdapter;
import org.flyants.book.utils.ToastUtils;
import org.flyants.book.view.base.BaseRecyclerAdapter;
import org.flyants.book.view.conversation.window.ConversationWindowView;
import org.flyants.book.view.firends.list.FirendsListView;
import org.flyants.book.view.search.global.GlobalSearchView;
import org.flyants.common.mvp.impl.BaseFragment;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class ConversationView extends BaseFragment<ConversationPrecenter> implements UIConversationView , BaseRecyclerAdapter.OnItemClickListener {

//    @BindView(R.id.springView) SpringView springView;
    @BindView(R.id.recycler_view) RecyclerView recycler_view;
    @BindView(R.id.friends_view) ImageView friends_view;
    @BindView(R.id.friends_add) ImageView friends_add;
    private ConversationAdapter adapter;

    @Override
    public ConversationPrecenter buildPresenter() {
        return new ConversationPrecenter(this,this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.conversation;
    }

    @Override
    public void onViewInit() {
        View searchView = LayoutInflater.from(getActivity()).inflate(R.layout.search_lable, null ,false);

        adapter = new ConversationAdapter(recycler_view);
        adapter.setOnItemClickListener(this);
        ProxyRecyclerViewAdapter proxyRecyclerViewAdapter =  new ProxyRecyclerViewAdapter(adapter);
        proxyRecyclerViewAdapter.addHeaderView(searchView);

        searchView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), GlobalSearchView.class);
                startActivity(intent);
            }
        });

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext() );
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recycler_view.setLayoutManager(layoutManager);
        recycler_view.setAdapter(proxyRecyclerViewAdapter);
//        recyclerView.addItemDecoration( new DividerGridItemDecoration(this ));
        recycler_view.setItemAnimator( new DefaultItemAnimator());
//        springView.setHeader(new EmptySpringHeader());
//        springView.setHeader(new DefaultHeader(getContext()));
//        springView.setFooter(new DefaultFooter(getContext()));
//        springView.setListener(getPresenter());
//        springView.setEnableFooter(false);
    }

    @Override
    public void setPullLoadMoreCompleted(int page, List<ConversationResp> list) {
//        springView.onFinishFreshAndLoad();
        adapter.refresh(list);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onItemClick(View view, Object data, int position) {
        Intent intent = new Intent(getContext(), ConversationWindowView.class);
        intent.putExtra(ConversationWindowView.PARAM_NAME,(ConversationResp)data);
        startActivity(intent);
    }


    @OnClick(R.id.friends_view)
    public void onClickfriends_view(){
        Intent intent = new Intent(getContext(), FirendsListView.class);
        startActivity(intent);
    }

    @OnClick(R.id.friends_add)
    public void onClickfriends_add(){

    }


    @Override
    public void setVeiwAttrs(ConversationResp resp) {

    }

    @Override
    public void onViewStart() {
        getPresenter().onRefresh();
    }

    @Override
    public void onViewDestroy() {

    }
}
