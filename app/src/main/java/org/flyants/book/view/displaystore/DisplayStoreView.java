package org.flyants.book.view.displaystore;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.flyants.book.R;
import org.flyants.book.view.base.BaseRecyclerAdapter;
import org.flyants.book.view.base.RecyclerHolder;
import org.flyants.book.view.dynamic.DynamicVisibility;
import org.flyants.common.mvp.impl.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class DisplayStoreView extends BaseActivity<DisplayStorePrecenter> implements UIDisplayStoreView {


    @BindView(R.id.recycler_view)  RecyclerView recycler_view;
    @BindView(R.id.idHeaderCompile) TextView idHeaderCompile;

    List<Display> displayList = new ArrayList<>();
    {
        displayList.add(new Display(R.mipmap.abj, DynamicVisibility.ALL.getValue(),DynamicVisibility.ALL.getDesc(),0));
        displayList.add(new Display(R.mipmap.abp,DynamicVisibility.FIRENDS.getValue(),DynamicVisibility.FIRENDS.getDesc(),0));
        displayList.add(new Display(R.mipmap.aby,DynamicVisibility.PRIVATE.getValue(),DynamicVisibility.PRIVATE.getDesc(),0));
    }

    public Display display;

    public  BaseRecyclerAdapter baseRecyclerAdapter;


    @Override
    public DisplayStorePrecenter buildPresenter() {
        return new DisplayStorePrecenter(this,this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.display_store;
    }

    @OnClick(R.id.idHeaderBack)
    public void onBack(){
        onBackPressed();
    }

    @OnClick(R.id.idHeaderCompile)
    public void onClickHeaderCompile(){
        Intent intent = new Intent();
        intent.putExtra("display",display);
        setResult(RESULT_OK,intent);
        finish();
    }

    @Override
    public void onViewInit() {
        String name = getIntent().getStringExtra("name");
        for (Display display1 : displayList) {
            if(display1.getName().equals(name)){
                display1.setSelected(1);
            }
        }

        baseRecyclerAdapter =  new  BaseRecyclerAdapter(recycler_view,displayList,R.layout.display_item) {
            @Override
            public void convert(RecyclerHolder holder, Object item, int position, boolean isScrolling) {
                Display display = (Display)item;
                holder.setText(R.id.item_name,display.getName());
                holder.setText(R.id.item_desc,display.getDesc());
                holder.setImageResource(R.id.item_logo,display.getImg());
                View view = holder.getView(R.id.item_selected);
                if(display.getSelected() == 1){
                    view.setVisibility(View.VISIBLE);
                }else{
                    view.setVisibility(View.INVISIBLE);
                }
            }

        };


        LinearLayoutManager layoutManager = new LinearLayoutManager(this );
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recycler_view.setLayoutManager(layoutManager);
        recycler_view.setAdapter(baseRecyclerAdapter);
        baseRecyclerAdapter.setOnItemClickListener(new BaseRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, Object data, int position) {
                display = (Display)data;
                for (Display display1 : displayList) {
                    if(display1.getName().equals(display.getName())){
                        display1.setSelected(1);
                    }else{
                        display1.setSelected(0);
                    }
                }
                baseRecyclerAdapter.refresh(displayList);
                baseRecyclerAdapter.notifyDataSetChanged();
            }
        });
    }


    @Override
    public void onViewStart() {

    }

    @Override
    public void onViewDestroy() {

    }

    @Override
    public void setVeiwAttrs(Object resp) {

    }

}
