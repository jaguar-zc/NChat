package org.flyants.book.view.area;

import android.content.Intent;
import android.view.View;

import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.flyants.book.R;
import org.flyants.book.custom.Header;
import org.flyants.book.view.base.BaseRecyclerAdapter;
import org.flyants.common.mvp.impl.BaseActivity;

import java.util.List;

import butterknife.BindView;

public class AreaView extends BaseActivity<AreaPrecenter> implements UIAreaView{

    @BindView(R.id.idHeader)  Header idHeader;
    @BindView(R.id.recycler_view) RecyclerView recycler_view;

    private AreaAdapter areaAdapter;

    @Override
    public AreaPrecenter buildPresenter() {
        return new AreaPrecenter(this,this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.area_view;
    }

    @Override
    public void onViewInit() {
        idHeader.setHeaderTitle("地区");
        areaAdapter = new AreaAdapter(recycler_view);
        areaAdapter.setOnItemClickListener(new BaseRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, Object data, int position) {
                Intent intent = new Intent();
                intent.putExtra("location",((Provinces)data).getName());
                setResult(RESULT_OK);
                finish();
            }
        });
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recycler_view.setLayoutManager(layoutManager);
        recycler_view.setAdapter(areaAdapter);
//        recyclerView.addItemDecoration( new DividerGridItemDecoration(this ));
        recycler_view.setItemAnimator( new DefaultItemAnimator());
    }


    @Override
    public void setPullLoadMoreCompleted(int page, List<Provinces> rows) {
        if(page == 1){
            areaAdapter.refresh(rows);
        }else{
            if(rows.size() > 0){
                areaAdapter.addDataList(rows);
            }
        }
        areaAdapter.notifyDataSetChanged();
    }

    @Override
    public void onViewStart() {

    }

    @Override
    public void onViewDestroy() {

    }
}
