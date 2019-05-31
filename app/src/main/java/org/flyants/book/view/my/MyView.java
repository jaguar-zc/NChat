package org.flyants.book.view.my;

import android.content.Intent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.flyants.book.R;
import org.flyants.book.network.image.ImageLoader;
import org.flyants.book.network.image.glide.CenterCropImageLoaderImpl;
import org.flyants.book.utils.JsonUtils;
import org.flyants.book.utils.LogUtils;
import org.flyants.book.view.my.meinfo.MeInfoView;
import org.flyants.book.view.my.meqrcode.MeQrCodeView;
import org.flyants.book.view.setting.SettingView;
import org.flyants.common.mvp.impl.BaseFragment;

import butterknife.BindView;
import butterknife.OnClick;

public class MyView extends BaseFragment<MyPresenterImpl> implements UiMyView  {

    @BindView(R.id.icon) ImageView icon;
    @BindView(R.id.item_qrcode) LinearLayout item_qrcode;
    @BindView(R.id.item_wallet) LinearLayout item_wallet;
    @BindView(R.id.item_face) LinearLayout item_face;
    @BindView(R.id.item_faq) LinearLayout item_faq;
    @BindView(R.id.item_setting) LinearLayout item_setting;
    @BindView(R.id.nickname) TextView nickname;
    @BindView(R.id.nchat_no) TextView nchat_no;
    @BindView(R.id.edit_info) TextView edit_info;

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
//        myViewAdapter = new MyViewAdapter(rv, Collections.emptyList(), this);
//        rv.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL,false));//设置布局管理器
//        rv.setAdapter(myViewAdapter);
    }

    @Override
    public void onViewStart() {

    }

    @Override
    public void onViewDestroy() {

    }

    @Override
    public void setVeiwAttrs(UserInfo resp) {
        imageLoader.loader(resp.getEncodedPrincipal(),icon);
        nickname.setText(resp.getNickName()+"");
        nchat_no.setText(getString(R.string.app_name)+"号:"+resp.getPeopleNo()+"");
    }


    @OnClick(R.id.item_setting)
    public void onClickSetting(){
        startActivity(new Intent(getActivity(),SettingView.class));
    }


    @OnClick(R.id.item_qrcode)
    public void onClickMeQrCodeView(){
        startActivity(new Intent(getActivity(), MeQrCodeView.class));
    }

    @OnClick(R.id.edit_info)
    public void onClickMeInfoView(){
        startActivity(new Intent(getActivity(), MeInfoView.class));
    }


}
