package org.flyants.book.view.firends.list;

import android.content.Intent;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.liaoinstan.springview.container.DefaultFooter;
import com.liaoinstan.springview.container.DefaultHeader;
import com.liaoinstan.springview.widget.SpringView;

import org.flyants.book.R;
import org.flyants.book.custom.Header;
import org.flyants.book.custom.ProxyRecyclerViewAdapter;
import org.flyants.book.utils.ToastUtils;
import org.flyants.book.view.conversation.ConversationResp;
import org.flyants.book.view.conversation.user.MessageUserSimpleInfo;
import org.flyants.book.view.conversation.window.ConversationWindowView;
import org.flyants.common.mvp.impl.BaseActivity;

import java.util.List;

import butterknife.BindView;

public class FirendsListView extends BaseActivity<FirendsListPrecenter> implements UIFirendsListView {

    @BindView(R.id.idHeader) Header idHeader;
    @BindView(R.id.springView)  SpringView springView;
    @BindView(R.id.recycler_view)  RecyclerView recycler_view;
    private FirendsListAdapter firendsListAdapter;



    @Override
    public FirendsListPrecenter buildPresenter() {
        return new FirendsListPrecenter(this,this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.firends_list;
    }

    @Override
    public void onViewInit() {
        idHeader.setHeaderTitle("好友");
        ImageView right = new ImageView(this);
        right.setImageResource(R.mipmap.ace);
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams( ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        int pxDimension = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_PX, 30,this.getResources().getDisplayMetrics());
        right.setLayoutParams(params);
        right.setPadding(pxDimension,pxDimension,pxDimension,pxDimension);
        idHeader.setHeaderRight(right);



        View searchView = LayoutInflater.from(getActivity()).inflate(R.layout.search_lable, null ,false);

        firendsListAdapter = new FirendsListAdapter(recycler_view,this);
//        firendsListAdapter.setOnItemClickListener(this);
        ProxyRecyclerViewAdapter proxyRecyclerViewAdapter =  new ProxyRecyclerViewAdapter(firendsListAdapter);
        proxyRecyclerViewAdapter.addHeaderView(searchView);

        searchView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtils.show("search");
            }
        });

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
    public void toConversationWindow(MessageUserSimpleInfo item) {
        getPresenter().toConversationWindow(item.getId());
    }

    @Override
    public void setPullLoadMoreCompleted(int page, List<MessageUserSimpleInfo> rows) {
        springView.onFinishFreshAndLoad();
        if(page == 1){
            firendsListAdapter.refresh(rows);
        }else{
            if(rows.size() > 0){
                firendsListAdapter.addDataList(rows);
            }
        }
        firendsListAdapter.notifyDataSetChanged();
    }

    @Override
    public void onViewStart() {
        getPresenter().onRefresh();
    }

    @Override
    public void onViewDestroy() {

    }

    public void openConversationWindow(ConversationResp resp) {
        Intent intent = new Intent(this,ConversationWindowView.class);
        intent.putExtra( ConversationWindowView.PARAM_NAME,resp);
        startActivity(intent);
    }
}
