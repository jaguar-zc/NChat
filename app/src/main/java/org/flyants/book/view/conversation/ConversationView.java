package org.flyants.book.view.conversation;

import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;

import com.liaoinstan.springview.container.DefaultFooter;
import com.liaoinstan.springview.container.DefaultHeader;
import com.liaoinstan.springview.widget.SpringView;

import org.flyants.book.R;
import org.flyants.common.mvp.impl.BaseFragment;

import java.util.List;

import butterknife.BindView;

public class ConversationView extends BaseFragment<ConversationPrecenter> implements UIConversationView {

    @BindView(R.id.springView) SpringView springView;
    @BindView(R.id.recycler_view) RecyclerView recycler_view;
    private ConversationAdapter adapter;


    @Override
    public ConversationPrecenter buildPresenter() {
        return new ConversationPrecenter(this,this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.experience;
    }

    @Override
    public void onViewInit() {
        adapter = new ConversationAdapter(recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext() );
        layoutManager.setOrientation(OrientationHelper. VERTICAL);
        recycler_view.setLayoutManager(layoutManager);
        recycler_view.setAdapter(adapter);
//        recyclerView.addItemDecoration( new DividerGridItemDecoration(this ));
        recycler_view.setItemAnimator( new DefaultItemAnimator());
        springView.setHeader(new DefaultHeader(getContext()));
        springView.setFooter(new DefaultFooter(getContext()));
        springView.setListener(getPresenter());
        springView.setEnableFooter(false);

    }

    @Override
    public void setPullLoadMoreCompleted(int page, List<ConversationResp> list) {
        springView.onFinishFreshAndLoad();
        adapter.refresh(list);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void setVeiwAttrs(ConversationResp resp) {

    }

    @Override
    public void onViewStart() {

    }

    @Override
    public void onViewDestroy() {

    }
}
