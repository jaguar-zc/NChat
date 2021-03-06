package org.flyants.book.view.my.editinfo;

import android.Manifest;
import android.content.Intent;
import android.net.Uri;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import org.flyants.book.R;
import org.flyants.book.custom.Header;
import org.flyants.book.network.RequestUtils;
import org.flyants.book.network.image.glide.IconImageLoaderImpl;
import org.flyants.book.resources.Constants;
import org.flyants.book.resources.StaticApis;
import org.flyants.book.utils.LogUtils;
import org.flyants.book.utils.ToastUtils;
import org.flyants.book.view.gallery.GalleryView;
import org.flyants.book.view.my.UserInfo;
import org.flyants.common.mvp.impl.BaseActivity;
import org.flyants.component.alert.AlertUtils;
import org.flyants.component.gallery.DevicePhotoUtils;
import org.flyants.component.imageloader.ImageLoader;
import org.flyants.component.prompt.PromptUtils;
import org.flyants.component.selected.OnSelectedItem;
import org.flyants.component.selected.SelectedViewUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import chihane.jdaddressselector.BottomDialog;
import chihane.jdaddressselector.OnAddressSelectedListener;
import chihane.jdaddressselector.model.City;
import chihane.jdaddressselector.model.County;
import chihane.jdaddressselector.model.Province;
import chihane.jdaddressselector.model.Street;
import me.kareluo.imaging.IMGEditActivity;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Multipart;

import static android.Manifest.permission.READ_EXTERNAL_STORAGE;
import static android.Manifest.permission.RECORD_AUDIO;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

public class EditUserInfoView extends BaseActivity<EditUserInfoPrencenter> implements UIEditUserInfoView {



    @BindView(R.id.idHeader)
    Header header;
    @BindView(R.id.cover_bg_layout)
    RelativeLayout cover_bg_layout;
    @BindView(R.id.icon)
    ImageView icon;
    @BindView(R.id.open_image)
    ImageView open_image;
    @BindView(R.id.replace_bg)
    TextView replace_bg;

    @BindView(R.id.name_layout)
    LinearLayout name_layout;
    @BindView(R.id.name_text)
    TextView name_text;

    @BindView(R.id.introduction_layout)
    LinearLayout introduction_layout;
    @BindView(R.id.introduction_text)
    TextView introduction_text;

    @BindView(R.id.chatno_layout)
    LinearLayout chatno_layout;
    @BindView(R.id.chatno_text)
    TextView chatno_text;

    @BindView(R.id.sex_layout)
    LinearLayout sex_layout;
    @BindView(R.id.sex_text)
    TextView sex_text;

    @BindView(R.id.location_layout)
    LinearLayout location_layout;
    @BindView(R.id.location_text)
    TextView location_text;

    ImageLoader imageLoader = new IconImageLoaderImpl();

    List<Object> listNames = new ArrayList<>(PeopleSex.listNames());

    @Override
    public List<String> applyPermission() {
        return Arrays.asList(READ_EXTERNAL_STORAGE,WRITE_EXTERNAL_STORAGE,RECORD_AUDIO);
    }

    @Override
    public EditUserInfoPrencenter buildPresenter() {
        return new EditUserInfoPrencenter(this, this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.edit_user_info;
    }

    @Override
    public void onViewInit() {
        header.setHeaderTitle("编辑个人资料");
    }

    @Override
    public void onViewStart() {

    }

    @Override
    public void onViewDestroy() {

    }


    @OnClick(R.id.open_image)
    public void OnClickOpenImage() {
        Intent intent = new Intent(this, GalleryView.class);
        startActivityForResult(intent, Constants.GALLERY_VIEW);
    }


    @OnClick(R.id.name_layout)
    public void OnClickname_layout() {
        PromptUtils.tipClick(this, name_text.getText().toString(), new PromptUtils.OnCallback() {
            @Override
            public Boolean callback(String content) {
                if (content.length() > 0) {
                    name_text.setText(content);
                    getPresenter().updateNickName(content);
                }
                return true;
            }
        });
    }

    @OnClick(R.id.introduction_layout)
    public void OnClickintroduction_layout() {
        PromptUtils.tipClick(this, introduction_text.getText().toString(), new PromptUtils.OnCallback() {
            @Override
            public Boolean callback(String content) {
                if (content.length() > 0) {
                    introduction_text.setText(content);
                    getPresenter().updateIntroduction(content);
                }
                return true;
            }
        });
    }

    @OnClick(R.id.chatno_layout)
    public void OnClickchatno_layout() {
//        ToastUtils.show("不可以修改");
        AlertUtils.tipClick(this, "不可以修改", null);
    }

    @OnClick(R.id.sex_layout)
    public void OnClicksex_layout() {
        SelectedViewUtils.show(this, listNames, new OnSelectedItem() {
            @Override
            public void onSelected(int index) {
                PeopleSex sex = PeopleSex.nameOfPeopleSex(listNames.get(index).toString());
                sex_text.setText(sex.getName());
                getPresenter().updateSex(sex.getValue());
            }
        });
    }

    @OnClick(R.id.location_layout)
    public void OnClicklocation_layout() {
//        Intent intent = new Intent(this, AreaView.class);
//        startActivityForResult(intent,100);
        BottomDialog dialog = new BottomDialog(getActivity());
        dialog.setOnAddressSelectedListener(new OnAddressSelectedListener() {
            @Override
            public void onAddressSelected(Province province, City city, County county, Street street) {
                StringBuffer locatoin = new StringBuffer();
                locatoin.append(province != null ? province.name + " " : "");
                locatoin.append(city != null ? city.name + " " : "");
                locatoin.append(county != null ? county.name + " " : "");
                locatoin.append(street != null ? street.name : "");
                location_text.setText(locatoin.toString());
                getPresenter().updateLocation(province,city,county,street);
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    @Override
    public void setVeiwAttrs(UserInfo resp) {
        imageLoader.loader(resp.getEncodedPrincipal(), icon);
        name_text.setText(resp.getNickName());
        introduction_text.setText(resp.getIntroduction() == null ? "" : resp.getIntroduction());
        chatno_text.setText(resp.getPeopleNo() == null ? "" : resp.getPeopleNo());
        sex_text.setText(PeopleSex.valueOfPeopleSex(resp.getSex()).getName());
        location_text.setText(resp.getLocation() == null ? "" : resp.getLocation());
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode ==  Constants.GALLERY_VIEW && resultCode == RESULT_OK){
            ArrayList<String> imageList = data.getStringArrayListExtra("imageList");
            LogUtils.d("imageList:"+imageList.size());
            if(imageList.size() > 0){
                LogUtils.d("imageList:"+imageList.get(0));
                startImageClip(imageList.get(0));
            }
            return;
        }

        if(requestCode ==  Constants.REQ_IMAGE_EDIT && resultCode == RESULT_OK){
            imageLoader.loader(buildTempImagePath,icon);
            uploadFiles();
        }
    }

    public void uploadFiles(){
        StaticApis staticApis = RequestUtils.build(StaticApis.class);
        File file = new File(buildTempImagePath);
        RequestBody requestBody = RequestBody.create(MediaType.parse("multipart/form-data"),file);
        MultipartBody.Part filePart = MultipartBody.Part.createFormData("file",file.getName(),requestBody);
        staticApis.upload(filePart).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    try {
                        String logoPath = response.body().string();
                        imageLoader.loader(logoPath,icon);
                        getPresenter().updateLogo(logoPath);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                ToastUtils.show("上传文件失败");
            }
        });
    }

    String buildTempImagePath;
    public void startImageClip(String path){
        buildTempImagePath = DevicePhotoUtils.buildTempImagePath(this);
        Intent intent = new Intent(this,IMGEditActivity.class);
        intent.putExtra(IMGEditActivity.EXTRA_IMAGE_URI, Uri.fromFile(new File(path)));
        intent.putExtra(IMGEditActivity.EXTRA_IMAGE_SAVE_PATH,buildTempImagePath);
        startActivityForResult( intent,  Constants.REQ_IMAGE_EDIT );
    }
}
