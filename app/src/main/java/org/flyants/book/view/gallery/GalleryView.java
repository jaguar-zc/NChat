package org.flyants.book.view.gallery;

import android.app.Activity;
import android.content.Intent;
import android.widget.FrameLayout;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import org.flyants.book.R;
import org.flyants.book.view.my.medynamic.MeDynamicView;
import org.flyants.common.mvp.impl.BaseActivity;
import org.flyants.common.mvp.impl.BaseFragment;
import org.flyants.component.gallery.GalleryFragment;
import org.flyants.component.gallery.MediaBean;
import org.flyants.component.gallery.OnGallerylistener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class GalleryView extends BaseActivity<GalleryPrecenter> implements UIGalleryView {

    @BindView(R.id.frameLayout) FrameLayout frameLayout;
    List<Fragment> fragmentList = new ArrayList<>();

    int selectCount = 1;

    /**
     * 用于对Fragment进行管理
     */
    private FragmentManager fragmentManager;

    @Override
    public GalleryPrecenter buildPresenter() {
        return new GalleryPrecenter(this,this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.gallery_view;
    }

    @Override
    public void onViewInit() {
        selectCount = getIntent().getIntExtra("selectCount", 1);
        fragmentManager = getSupportFragmentManager();
        GalleryFragment galleryFragment = new GalleryFragment();
        galleryFragment.setSelectCount(selectCount);
        galleryFragment.setOnGallerylistener(new OnGallerylistener() {
            @Override
            public void close() {
                onBackPressed();
            }

            @Override
            public void selected(List<MediaBean> mediaBean) {
                Intent intent = new Intent();
                ArrayList<String> stringList = new ArrayList<>();
                for (MediaBean bean : mediaBean) {
                    stringList.add(bean.getPath());
                }
                intent.putStringArrayListExtra("imageList",stringList);
                setResult(Activity.RESULT_OK,intent);
                finish();
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
    public void onViewStart() {

    }

    @Override
    public void onViewDestroy() {

    }
}
