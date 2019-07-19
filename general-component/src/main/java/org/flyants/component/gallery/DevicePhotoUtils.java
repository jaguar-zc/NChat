
package org.flyants.component.gallery;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class DevicePhotoUtils {

    public interface OnPhotoListenner{
        public void callback(List<MediaBean> mediaBeen, HashMap<String, List<MediaBean>> allPhotosTemp);
    }

    public static String buildTempImagePath(Context context){
        return context.getApplicationContext().getCacheDir()+"/"+ UUID.randomUUID().toString() +".jpg";
    }


    /**
     * 读取手机中所有图片信息
     */
    public static void getAllPhotoInfo( final Activity context, final OnPhotoListenner onPhotoListenner) {
        new Thread(new Runnable() {
            @Override
            public void run() {
               final List<MediaBean> mediaBeen = new ArrayList<>();
               final HashMap<String,List<MediaBean>> allPhotosTemp = new HashMap<>();//所有照片
                Uri mImageUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                String[] projImage = { MediaStore.Images.Media._ID
                        , MediaStore.Images.Media.DATA
                        ,MediaStore.Images.Media.SIZE
                        ,MediaStore.Images.Media.DISPLAY_NAME};
                Cursor mCursor = context.getContentResolver().query(mImageUri,
                        projImage,
                        MediaStore.Images.Media.MIME_TYPE + "=? or " + MediaStore.Images.Media.MIME_TYPE + "=?",
                        new String[]{"image/jpeg", "image/png"},
                        MediaStore.Images.Media.DATE_MODIFIED+" desc");

                if(mCursor!=null){
                    while (mCursor.moveToNext()) {
                        // 获取图片的路径
                        String path = mCursor.getString(mCursor.getColumnIndex(MediaStore.Images.Media.DATA));
                        int size = mCursor.getInt(mCursor.getColumnIndex(MediaStore.Images.Media.SIZE))/1024;
                        String displayName = mCursor.getString(mCursor.getColumnIndex(MediaStore.Images.Media.DISPLAY_NAME));
                        //用于展示相册初始化界面
                        mediaBeen.add(new MediaBean(MediaBean.Type.Image,path,size,displayName));
                        // 获取该图片的父路径名
                        String dirPath = new File(path).getParentFile().getAbsolutePath();
                        //存储对应关系
                        if (allPhotosTemp.containsKey(dirPath)) {
                            List<MediaBean> data = allPhotosTemp.get(dirPath);
                            data.add(new MediaBean(MediaBean.Type.Image,path,size,displayName));
                            continue;
                        } else {
                            List<MediaBean> data = new ArrayList<>();
                            data.add(new MediaBean(MediaBean.Type.Image,path,size,displayName));
                            allPhotosTemp.put(dirPath,data);
                        }
                    }
                    mCursor.close();
                }
                //更新界面
                context.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //...
                        onPhotoListenner.callback(mediaBeen,allPhotosTemp);

                    }
                });
            }
        }).start();
    }
}
