package org.flyants.book.view.my.meinfo;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.flyants.book.R;
import org.flyants.book.custom.Header;
import org.flyants.book.network.image.ImageLoader;
import org.flyants.book.network.image.glide.CenterCropImageLoaderImpl;
import org.flyants.book.view.dynamic.DynamicResp;
import org.flyants.book.view.my.UserInfo;
import org.flyants.book.view.my.extinfo.ExtInfoView;
import org.flyants.book.view.my.medynamic.MeDynamicView;
import org.flyants.book.view.photoalbum.SimplePhotoAlbumView;
import org.flyants.common.mvp.impl.BaseActivity;
import org.flyants.common.utils.StatusBarUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

import static android.Manifest.permission.READ_EXTERNAL_STORAGE;

public class MeInfoView extends BaseActivity<MeInfoPrecenter> implements UIMeInfoView {

//    @BindView(R.id.springView) SpringView springView;
    @BindView(R.id.idHeader) Header idHeader;
//    @BindView(R.id.id_header_layout) LinearLayout id_header_layout;
//    @BindView(R.id.idHeader) ImageView idHeader;
//    @BindView(R.id.header_right) ImageView header_right;


    @BindView(R.id.icon) ImageView icon;
    @BindView(R.id.nickName)  TextView nickName;
    @BindView(R.id.chat_no)  TextView chat_no;
    @BindView(R.id.people_introduction)  TextView people_introduction;
    @BindView(R.id.peopleAssistCount)  TextView peopleAssistCount;
    @BindView(R.id.peopleAssist)  ImageView peopleAssist;
    @BindView(R.id.send_message) ImageView send_message;
    @BindView(R.id.send_dynamic) ImageView send_dynamic;
    @BindView(R.id.edit_people_info) ImageView edit_people_info;

//    @BindView(R.id.dynamic_lable) TextView dynamic_lable;
//    @BindView(R.id.info_lable)  TextView info_lable;

//    @BindView(R.id.basic_info_layout) LinearLayout basic_info_layout;
//    @BindView(R.id.location)  TextView location;




    @BindView(R.id.frameLayout) FrameLayout frameLayout;
    @BindView(R.id.tap_dynamic) TextView tap_dynamic;
    @BindView(R.id.tap_extinfo) TextView tap_extinfo;

    List<Fragment> fragmentList = new ArrayList<>();

    /**
     * 用于对Fragment进行管理
     */
    private FragmentManager fragmentManager;

//    @BindView(R.id.recycler_view)  RecyclerView recycler_view;

    private static int RESULT_LOAD_IMAGE = 1;
    ImageLoader imageLoader = new CenterCropImageLoaderImpl();

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
//        StatusBarUtil.setTranslucentStatus(this);
        return R.layout.me_info;
    }


    View.OnClickListener iconClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
//            Intent i = new Intent( Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
//            startActivityForResult(i, RESULT_LOAD_IMAGE);
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

//        ViewGroup.LayoutParams layoutParams = id_header_layout.getLayoutParams();
//        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(layoutParams);
//        lp.setMargins(0,getStatusBarHeight(),0,0);
//        id_header_layout.setLayoutParams(lp);
//
//        meInfoHeader = new MeInfoHeaderView(this,springView);
//        meInfoHeader.setRecycler_view(recycler_view);
//        meInfoHeader.setPresenter(getPresenter());
//        meInfoHeader.icon.setOnClickListener(iconClick);
////        idHeader.setHeaderTitle("");
////        idHeader.setBackgrundColor(0);
//
//        idHeader.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                onBackPressed();
//            }
//        });
//
//        adapter = new MeInfoAdapter(recycler_view);
//
//
//        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity() );
//        layoutManager.setOrientation(OrientationHelper. VERTICAL);
//        recycler_view.setLayoutManager(layoutManager);
//
//        ProxyRecyclerViewAdapter proxyAdapter = new ProxyRecyclerViewAdapter(adapter);
//        proxyAdapter.addHeaderView(meInfoHeader.rootView);
//        recycler_view.setAdapter(proxyAdapter);
////        recyclerView.addItemDecoration( new DividerGridItemDecoration(this ));
////        recycler_view.setItemAnimator( new DefaultItemAnimator());
//        springView.setHeader(new EmptySpringHeader());
////        springView.setHeader(new DefaultHeader(getActivity()));
//        springView.setFooter(new DefaultFooter(getActivity()));
//        springView.setListener(getPresenter());
    }

    @Override
    public void onViewStart() {
//        getPresenter().onRefresh();
    }


    @Override
    public void setViewAttrs(UserInfo resp) {
        imageLoader.loader(resp.getEncodedPrincipal(),icon);
       nickName.setText(resp.getNickName() + "");
       chat_no.setText(getString(R.string.AntsChatId) + ":" + resp.getPeopleNo() + "");
       people_introduction.setText(resp.getIntroduction() + "");
        if (resp.getPeopleAssistCount() > 0) {
           peopleAssist.setImageResource(R.mipmap.ab0);
        }
       peopleAssistCount.setText(resp.getPeopleAssistCount() + "");
//        location.setText("所在地：   " + resp.getLocation() + "");
    }

    @Override
    public void onViewDestroy() {

    }

    @Override
    public void setPullLoadMoreCompleted(int page, List<DynamicResp> list) {
//        springView.onFinishFreshAndLoad();
//        adapter.addDataList(list);
//        adapter.notifyDataSetChanged();
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
    }

    @OnClick(R.id.edit_people_info)
    public void edit_people_info() {
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
