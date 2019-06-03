package org.flyants.book.view.experience;

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

public class ExperienceView extends BaseFragment<ExperiencePrecenter> implements UIExperienceView {

    @BindView(R.id.springView) SpringView springView;
    @BindView(R.id.recycler_view) RecyclerView recycler_view;
    private ExperienceAdapter adapter;


    @Override
    public ExperiencePrecenter buildPresenter() {
        return new ExperiencePrecenter(this,this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.experience;
    }

    @Override
    public void onViewInit() {
        adapter = new ExperienceAdapter(recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext() );
        recycler_view.setLayoutManager(layoutManager);
        layoutManager.setOrientation(OrientationHelper. VERTICAL);
        recycler_view.setAdapter(adapter);
//        recyclerView.addItemDecoration( new DividerGridItemDecoration(this ));
        recycler_view.setItemAnimator( new DefaultItemAnimator());
        springView.setHeader(new DefaultHeader(getContext()));
        springView.setFooter(new DefaultFooter(getContext()));
        springView.setListener(getPresenter());
    }

    @Override
    public void setPullLoadMoreCompleted(int page, List<FoundDto> list) {

    }

    @Override
    public void setVeiwAttrs(FoundDto resp) {

    }

    @Override
    public void onViewStart() {
//        springView.callFresh();
    }

    @Override
    public void onViewDestroy() {

    }
}
