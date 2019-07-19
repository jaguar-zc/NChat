package org.flyants.book.view.dynamic.publish;

import android.content.Intent;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import org.flyants.book.R;
import org.flyants.book.network.image.glide.IconImageLoaderImpl;
import org.flyants.book.utils.JsonUtils;
import org.flyants.book.utils.ToastUtils;
import org.flyants.book.view.displaystore.Display;
import org.flyants.book.view.displaystore.DisplayStoreView;
import org.flyants.book.view.dynamic.DynamicVisibility;
import org.flyants.book.view.my.UserInfo;
import org.flyants.common.mvp.impl.BaseActivity;
import org.flyants.component.gallery.GalleryFragment;
import org.flyants.component.gallery.OnGallerylistener;
import org.flyants.component.imageloader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class DynamicPublishView extends BaseActivity<DynamicPublishPrecenter> implements UIDynamicPublishView {

    @BindView(R.id.close_icon) ImageView close_icon;
    @BindView(R.id.small_icon) ImageView small_icon;
    @BindView(R.id.publish) TextView publish;
    @BindView(R.id.display_logo) ImageView display_logo;
    @BindView(R.id.display_text) TextView display_text;
    @BindView(R.id.dynamic_content)  EditText dynamic_content;
    @BindView(R.id.location)  TextView location;

    @BindView(R.id.frameLayout)  FrameLayout frameLayout;
    List<Fragment> fragmentList = new ArrayList<>();
    /**
     * 用于对Fragment进行管理
     */
    private FragmentManager fragmentManager;
    private GalleryFragment galleryFragment;

    ImageLoader imageLoader = new IconImageLoaderImpl();

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
        fragmentManager = getSupportFragmentManager();
        galleryFragment = new GalleryFragment();
        galleryFragment.setSelectCount(9);
        galleryFragment.setShowHeader(false);
        galleryFragment.setOnGallerylistener(new OnGallerylistener() {
            @Override
            public void close() {
                onBackPressed();
            }

            @Override
            public void selected(List<org.flyants.component.gallery.MediaBean> mediaBean) {
                ArrayList<String> stringList = new ArrayList<>();
                for (org.flyants.component.gallery.MediaBean bean : mediaBean) {
                    stringList.add(bean.getPath());
                }
                ToastUtils.show(JsonUtils.convertObjectToJSON(stringList));
            }
        });
        fragmentList.add(galleryFragment);
        setTabSelection(0);
    }

    private void setTabSelection(int index) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.frameLayout,fragmentList.get(index));
        transaction.commit();
    }

    @Override
    public void setViewAttrs(UserInfo userInfo) {
        imageLoader.loader(userInfo.getEncodedPrincipal(),small_icon);
    }

    @Override
    public String getContent() {
        return dynamic_content.getText().toString();
    }

    @Override
    public List<String> getImageList() {
        return galleryFragment.getSelectedItem();
    }

    @Override
    public DynamicVisibility getDynamicVisibility() {
        return DynamicVisibility.valueOfByValue(display_text.getText().toString());
    }

    @Override
    public String getLocation() {
        return location.getText().toString();
    }

    @OnClick(R.id.close_icon)
    public void onClickClose(){
        onBackPressed();
    }

    @OnClick(R.id.publish)
    public void onClickPublish(){
        getPresenter().publish();
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
