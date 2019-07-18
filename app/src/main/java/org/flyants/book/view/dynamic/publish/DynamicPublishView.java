package org.flyants.book.view.dynamic.publish;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.flyants.book.R;
import org.flyants.book.custom.GridItemDecoration;
import org.flyants.book.network.image.ImageLoader;
import org.flyants.book.network.image.glide.IconImageLoaderImpl;
import org.flyants.book.utils.DevicePhotoUtils;
import org.flyants.book.utils.JsonUtils;
import org.flyants.book.utils.MediaBean;
import org.flyants.book.utils.ToastUtils;
import org.flyants.book.view.base.BaseRecyclerAdapter;
import org.flyants.book.view.displaystore.Display;
import org.flyants.book.view.displaystore.DisplayStoreView;
import org.flyants.book.view.my.UserInfo;
import org.flyants.common.mvp.impl.BaseActivity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class DynamicPublishView extends BaseActivity<DynamicPublishPrecenter> implements UIDynamicPublishView {

    @BindView(R.id.close_icon) ImageView close_icon;
    @BindView(R.id.small_icon) ImageView small_icon;
    @BindView(R.id.publish) TextView publish;
    @BindView(R.id.display_logo) ImageView display_logo;
    @BindView(R.id.display_text) TextView display_text;

    @BindView(R.id.recycler_view) RecyclerView recycler_view;

    private PhotoListAdapter adapter;

    ImageLoader imageLoader = new IconImageLoaderImpl();

    int selectIndex = 0;
    int MAX_IMAGE_COUNT = 9;

    List<MediaBean> selectedImages = new ArrayList<>();

    @Override
    public DynamicPublishPrecenter buildPresenter() {
        return new DynamicPublishPrecenter(this,this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.dynamic_publish;
    }

    @Override
    public void onViewInit() {
        DevicePhotoUtils.getAllPhotoInfo(this, new DevicePhotoUtils.OnPhotoListenner() {
            @Override
            public void callback(List<MediaBean> mediaBeen, HashMap<String, List<MediaBean>> allPhotosTemp) {
                adapter.refresh(mediaBeen);
                adapter.notifyDataSetChanged();
            }
        });
        adapter = new PhotoListAdapter(recycler_view);
        adapter.setOnItemClickListener(new BaseRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, Object data, int position) {
                MediaBean mediaBean = (MediaBean)data;
                if(mediaBean.getSelectIndex() == 0){
                    if(selectIndex >= MAX_IMAGE_COUNT){
                        return;
                    }
                    selectIndex++;
                    mediaBean.setSelectIndex(selectIndex);
                    selectedImages.add(mediaBean);
                }else{
                    selectIndex--;
                    selectedImages.remove(mediaBean.getSelectIndex());
                    mediaBean.setSelectIndex(0);
                }
                adapter.notifyItemChanged(position);
            }
        });
        // 竖直方向的网格样式，每行四个Item
        GridLayoutManager mLayoutManager = new GridLayoutManager(this, 4, RecyclerView.VERTICAL, false);
        recycler_view.addItemDecoration(new GridItemDecoration(this));
        recycler_view.setLayoutManager(mLayoutManager);
        recycler_view.setAdapter(adapter);
    }

    @Override
    public void setViewAttrs(UserInfo userInfo) {
        imageLoader.loader(userInfo.getEncodedPrincipal(),small_icon);
    }

    @OnClick(R.id.close_icon)
    public void onClickClose(){
        onBackPressed();
    }

    @OnClick(R.id.publish)
    public void onClickPublish(){
        ToastUtils.show("发布");
    }


    @OnClick(R.id.display_text)
    public void onClickDisplay(){
        Intent intent = new Intent(this, DisplayStoreView.class);
        intent.putExtra("name",display_text.getText());
        startActivityForResult(intent,1000);
    }

    @Override
    public void onViewStart() {

    }

    @Override
    public void onViewDestroy() {

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1000 && resultCode == RESULT_OK){
            Display display = (Display)data.getSerializableExtra("display");
            if(display != null){
                display_logo.setImageResource(display.img);
                display_text.setText(display.getName());
            }
        }
    }
}
