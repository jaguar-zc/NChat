package org.flyants.book.view.my;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;

import org.flyants.book.R;
import org.flyants.book.network.image.ImageLoader;
import org.flyants.book.network.image.glide.CenterCropImageLoaderImpl;
import org.flyants.book.view.setting.SettingView;
import org.flyants.common.mvp.impl.BaseFragment;

import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class MyView extends BaseFragment<MyPresenterImpl> implements UiMyView  {

    @BindView(R.id.icon) ImageView icon;
    @BindView(R.id.shouchang_item) LinearLayout shouchang_item;
    @BindView(R.id.dianzhan_item) LinearLayout dianzhan_item;
    @BindView(R.id.guanzhu) TextView guanzhu;
    @BindView(R.id.fans) TextView fans;
    @BindView(R.id.shouchang) TextView shouchang;
    @BindView(R.id.zhan) TextView zhan;
    @BindView(R.id.individualitySignature) TextView individualitySignature;
    @BindView(R.id.npnetbsp) TextView npnetbsp;
    @BindView(R.id.username) TextView username;
    @BindView(R.id.edit_info) TextView edit_info;
    @BindView(R.id.settting) ImageView settting;
    @BindView(R.id.rv)  RecyclerView rv;

    MyViewAdapter myViewAdapter;

    ImageLoader imageLoader = new CenterCropImageLoaderImpl();


    @Override
    public MyPresenterImpl buildPresenter() {
        return new MyPresenterImpl(this,this);
    }

    @Override
    public int getLayoutId() {
        return  R.layout.my;
    }

    @Override
    public void onViewInit() {
        myViewAdapter = new MyViewAdapter(rv, Collections.emptyList(), this);
        rv.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL,false));//设置布局管理器
        rv.setAdapter(myViewAdapter);
    }

    @Override
    public void onViewStart() {

    }

    @Override
    public void onViewDestroy() {

    }

    @Override
    public void setVeiwAttrs(UserInfo resp) {
        // 使用 Glide 设置圆形画像
//        Glide.with(getContext())
//                .load(resp.getIcon())
//                .asBitmap()
//                .centerCrop()
//                .into(new BitmapImageViewTarget(icon) {
//                    @Override
//                    protected void setResource(Bitmap resource) {
//                        super.setResource(resource);
//                        RoundedBitmapDrawable roundedBitmapDrawable = RoundedBitmapDrawableFactory.create(getResources(), resource);
//                        roundedBitmapDrawable.setCircular(true);
//                        icon.setImageDrawable(roundedBitmapDrawable);
//                    }
//                });
        imageLoader.loader(resp.getIcon(),icon);
        username.setText(resp.getName()+"");
        npnetbsp.setText(resp.getNpnetbsp()+"");
        individualitySignature.setText(resp.getIndividualitySignature()+"");
        zhan.setText(resp.getAssist()+"");
        shouchang.setText(resp.getCollection()+"");
        fans.setText(resp.getFans()+"");
        guanzhu.setText(resp.getAttention()+"");
    }


    @OnClick(R.id.settting)
    public void onClickSetting(){
        startActivity(new Intent(getActivity(),SettingView.class));
    }

    @Override
    public void setWordsList(List<WorksModel> resp) {
        myViewAdapter.refresh(resp).notifyDataSetChanged();
    }

}
