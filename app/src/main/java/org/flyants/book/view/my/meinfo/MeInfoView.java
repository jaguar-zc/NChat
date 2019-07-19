package org.flyants.book.view.my.meinfo;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.net.Uri;
import android.provider.MediaStore;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import org.flyants.book.R;
import org.flyants.book.custom.Header;
import org.flyants.book.network.image.glide.IconImageLoaderImpl;
import org.flyants.book.view.dynamic.publish.DynamicPublishView;
import org.flyants.book.view.my.UserInfo;
import org.flyants.book.view.my.editinfo.EditUserInfoView;
import org.flyants.book.view.my.extinfo.ExtInfoView;
import org.flyants.book.view.my.medynamic.MeDynamicView;
import org.flyants.book.view.photoalbum.SimplePhotoAlbumView;
import org.flyants.common.mvp.impl.BaseActivity;
import org.flyants.common.mvp.impl.BaseFragment;
import org.flyants.component.imageloader.ImageLoader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

import static android.Manifest.permission.READ_EXTERNAL_STORAGE;

public class MeInfoView extends BaseActivity<MeInfoPrecenter> implements UIMeInfoView {

    @BindView(R.id.idHeader) Header idHeader;
    @BindView(R.id.icon) ImageView icon;
    @BindView(R.id.nickName)  TextView nickName;
    @BindView(R.id.chat_no)  TextView chat_no;
    @BindView(R.id.people_introduction)  TextView people_introduction;
    @BindView(R.id.peopleAssistCount)  TextView peopleAssistCount;
    @BindView(R.id.peopleAssist)  ImageView peopleAssist;
    @BindView(R.id.send_message) ImageView send_message;
    @BindView(R.id.send_dynamic) ImageView send_dynamic;
    @BindView(R.id.edit_people_info) ImageView edit_people_info;



    @BindView(R.id.frameLayout) FrameLayout frameLayout;
    @BindView(R.id.tap_dynamic) TextView tap_dynamic;
    @BindView(R.id.tap_extinfo) TextView tap_extinfo;
    @BindView(R.id.relativeLayout) RelativeLayout relativeLayout;

    List<BaseFragment> fragmentList = new ArrayList<>();

    /**
     * 用于对Fragment进行管理
     */
    private FragmentManager fragmentManager;


    private static int RESULT_LOAD_IMAGE = 1;
    ImageLoader imageLoader = new IconImageLoaderImpl();

    @Override
    public int getStatusBarColor() {
        return R.color.white;
    }


    @Override
    public List<String> applyPermission() {
        return Arrays.asList(READ_EXTERNAL_STORAGE);
    }

    @Override
    public MeInfoPrecenter buildPresenter() {
        return new MeInfoPrecenter(this, this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.me_info;
    }


    View.OnClickListener iconClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            startActivity(new Intent(getActivity(), SimplePhotoAlbumView.class));
        }
    };

    @Override
    public void onViewInit() {
        idHeader.setHeaderTitle("");
        fragmentManager = getSupportFragmentManager();
        fragmentList.add(new MeDynamicView());
        fragmentList.add(new ExtInfoView());
        setTabSelection(1);
    }

    @Override
    public void onViewStart() {
//        getPresenter().onRefresh();
    }


    @Override
    public void setViewAttrs(UserInfo resp) {
        imageLoader.loader(this,resp.getEncodedPrincipal(),icon);
       nickName.setText(resp.getNickName() + "");
       chat_no.setText(getString(R.string.AntsChatId) + ":" + resp.getPeopleNo() + "");
       people_introduction.setText(resp.getIntroduction() + "");
        if (resp.getPeopleAssistCount() > 0) {
           peopleAssist.setImageResource(R.mipmap.ab0);
        }
       peopleAssistCount.setText(resp.getPeopleAssistCount() + "");
    }

    @Override
    public void onViewDestroy() {

    }

    @OnClick(R.id.tap_dynamic)
    public void onClickTapMeDynamic(){
        tap_dynamic.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));//加粗
        tap_extinfo.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));//加粗
        setTabSelection(0);
    }

    @OnClick(R.id.tap_extinfo)
    public void onClickTapExtinfo(){
        tap_dynamic.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));//加粗
        tap_extinfo.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));//加粗
        setTabSelection(1);
        relativeLayout.setFocusable(true);
    }


    private void setTabSelection(int index) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.frameLayout,fragmentList.get(index));
        transaction.commit();
    }


    @OnClick(R.id.send_message)
    public void send_message() {

    }

    @OnClick(R.id.send_dynamic)
    public void send_dynamic() {
        startActivity(new Intent(this, DynamicPublishView.class));
    }

    @OnClick(R.id.edit_people_info)
    public void edit_people_info() {
        startActivity(new Intent(this, EditUserInfoView.class));
    }

    @OnClick(R.id.peopleAssist)
    public void onClickPeopleAssist() {
        this.getPresenter().peopleAssist();
    }

    public int getStatusBarHeight() {
        int result = 0;
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data) {
            Uri selectedImage = data.getData();
            String[] filePathColumn = { MediaStore.Images.Media.DATA };

            Cursor cursor = getContentResolver().query(selectedImage,
                    filePathColumn, null, null, null);
            cursor.moveToFirst();

            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String picturePath = cursor.getString(columnIndex);
            cursor.close();

            icon.setImageBitmap(BitmapFactory.decodeFile(picturePath));
        }
    }
}
