package org.flyants.book.view.photoalbum;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.PersistableBundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.jph.takephoto.app.TakePhoto;
import com.jph.takephoto.app.TakePhotoImpl;
import com.jph.takephoto.model.CropOptions;
import com.jph.takephoto.model.InvokeParam;
import com.jph.takephoto.model.TContextWrap;
import com.jph.takephoto.model.TResult;
import com.jph.takephoto.permission.InvokeListener;
import com.jph.takephoto.permission.PermissionManager;
import com.jph.takephoto.permission.TakePhotoInvocationHandler;

import org.flyants.book.R;
import org.flyants.common.mvp.impl.BaseActivity;

import java.io.File;

import butterknife.BindView;
import butterknife.OnClick;
//      https://github.com/crazycodeboy/TakePhoto/blob/master/simple/src/main/java/org/devio/simple/ResultActivity.java

    /**
     * - 支持通过相机拍照获取图片
     * - 支持从相册选择图片
     * - 支持从文件选择图片
     * - 支持多图选择
     * - 支持批量图片裁切
     * - 支持批量图片压缩
     * - 支持对图片进行压缩
     * - 支持对图片进行裁剪
     * - 支持对裁剪及压缩参数自定义
     * - 提供自带裁剪工具(可选)
     * - 支持智能选取及裁剪异常处理
     * - 支持因拍照Activity被回收后的自动恢复
     * Author: crazycodeboy
     * Date: 2016/9/21 0007 20:10
     * Version:4.0.0
     * 技术博文：http://www.devio.org
     * GitHub:https://github.com/crazycodeboy
     * Email:crazycodeboy@gmail.com
     */
    public class SimplePhotoAlbumView extends BaseActivity<PhotoAlbumPrecenter>  implements UIPhotoAlbumView,TakePhoto.TakeResultListener, InvokeListener {

        private static final String TAG = SimplePhotoAlbumView.class.getName();
        private TakePhoto takePhoto;
        private InvokeParam invokeParam;


        @BindView (R.id.image_view) ImageView image_view;
        @BindView (R.id.take_from_camera) Button take_from_camera;
        @BindView (R.id.take_from_galley) Button take_from_galley;
        @BindView (R.id.turn_to_another_activity) Button turn_to_another_activity;

        @Override
        public PhotoAlbumPrecenter buildPresenter() {
            return new PhotoAlbumPrecenter(this,this);
        }

        @Override
        public int getLayoutId() {
            return R.layout.simple_photo_album;
        }


        @OnClick(R.id.take_from_camera)
        public void take_from_camera(){
            //相机获取
            getTakePhoto().onPickFromCapture(getImageCropUri());
        }

        //获得照片的输出保存Uri
        private Uri getImageCropUri() {
            File file=new File(Environment.getExternalStorageDirectory(), "/temp/"+System.currentTimeMillis() + ".jpg");
            if (!file.getParentFile().exists())file.getParentFile().mkdirs();
            return Uri.fromFile(file);
        }

        @OnClick(R.id.take_from_galley)
        public void take_from_galley(){
            getTakePhoto().onPickFromCapture(getImageCropUri());
        }

        @OnClick(R.id.turn_to_another_activity)
        public void turn_to_another_activity(){
            CropOptions cropOptions=new CropOptions.Builder().setAspectX(1).setAspectY(1).setWithOwnCrop(true).create();

            getTakePhoto().onPickMultipleWithCrop(9,cropOptions);
        }

        @OnClick(R.id.take_from_camera_cort)
        public void take_from_camera_cort(){
            CropOptions cropOptions=new CropOptions.Builder().setAspectX(1).setAspectY(1).setWithOwnCrop(true).create();
            getTakePhoto().onPickFromCaptureWithCrop(getImageCropUri(),cropOptions);
        }

        @OnClick(R.id.take_from_galley_cort)
        public void take_from_galley_cort(){
            CropOptions cropOptions=new CropOptions.Builder().setAspectX(1).setAspectY(1).setWithOwnCrop(true).create();
            getTakePhoto().onPickFromGalleryWithCrop(getImageCropUri(),cropOptions);
        }

        @OnClick(R.id.turn_to_another_activity_cort)
        public void turn_to_another_activity_cort(){
            CropOptions cropOptions=new CropOptions.Builder().setAspectX(1).setAspectY(1).setWithOwnCrop(true).create();
            getTakePhoto().onPickMultipleWithCrop(9,cropOptions);
        }

        @Override
        public void onViewInit() {

        }

        @Override
        public void onViewStart() {

        }

        @Override
        public void onViewDestroy() {

        }

        /**
         *  获取TakePhoto实例
         * @return
         */
        public TakePhoto getTakePhoto(){
            if (takePhoto==null){
                takePhoto= (TakePhoto) TakePhotoInvocationHandler.of(this).bind(new TakePhotoImpl(this,this));
            }
            return takePhoto;
        }

        @Override
        public void takeSuccess(TResult result) {
            String iconPath = result.getImage().getOriginalPath();
            //Toast显示图片路径
            Toast.makeText(this, "imagePath:" + iconPath, Toast.LENGTH_SHORT).show();
            //Google Glide库 用于加载图片资源
            Glide.with(this).load(iconPath).into(image_view);
        }

        @Override
        public void takeFail(TResult result, String msg) {

        }

        @Override
        public void takeCancel() {

        }

        @Override
        public PermissionManager.TPermissionType invoke(InvokeParam invokeParam) {
            PermissionManager.TPermissionType type=PermissionManager.checkPermission(TContextWrap.of(this),invokeParam.getMethod());
            if(PermissionManager.TPermissionType.WAIT.equals(type)){
                this.invokeParam=invokeParam;
            }
            return type;
        }

        @Override
        public void onCreate( Bundle savedInstanceState,PersistableBundle persistentState) {
            getTakePhoto().onCreate(savedInstanceState);
            super.onCreate(savedInstanceState, persistentState);
        }

        @Override
        protected void onSaveInstanceState(Bundle outState) {
            getTakePhoto().onSaveInstanceState(outState);
            super.onSaveInstanceState(outState);
        }

        @Override
        protected void onActivityResult(int requestCode, int resultCode, Intent data) {
            getTakePhoto().onActivityResult(requestCode, resultCode, data);
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
