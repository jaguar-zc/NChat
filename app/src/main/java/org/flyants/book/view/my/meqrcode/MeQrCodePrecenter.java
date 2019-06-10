package org.flyants.book.view.my.meqrcode;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;

import com.google.zxing.WriterException;
import com.google.zxing.encoding.EncodingHandler;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.flyants.book.NChatApplication;
import org.flyants.book.network.RequestUtils;
import org.flyants.book.resources.Apis;
import org.flyants.book.utils.SharedPreferencesHelper;
import org.flyants.common.store.OnCallback;
import org.flyants.book.store.UserStore;
import org.flyants.book.view.my.UserInfo;
import org.flyants.common.mvp.impl.BasePresenter;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.text.MessageFormat;
import java.util.Date;
import java.util.Random;

class MeQrCodePrecenter extends BasePresenter<MeQrCodeView, UIMeQrCodeView> {

    private Apis apis;

    public MeQrCodePrecenter(MeQrCodeView t, UIMeQrCodeView uiMeQrCodeView) {
        super(t, uiMeQrCodeView);
    }

    @Override
    public void onViewInit() {
        apis = RequestUtils.build(Apis.class);
    }

    @Override
    public void onViewStart() {
        UserStore.getInstence().loadObject(context, new OnCallback<UserInfo>() {
            @Override
            public void call(UserInfo userInfo) {
                uiView.setViewAttrs(userInfo);
                createQrCode(userInfo);
            }
        });
    }


    public void createQrCode(UserInfo userInfo) {
        String key = "qrcode-" + userInfo.getPeopleNo();
        String sharedPreference = (String) SharedPreferencesHelper.$().getSharedPreference(key, null);
        String path = null;
        if (sharedPreference != null) {
            File qrcode = new File(NChatApplication.getFlyantsApplication().getCacheDir(), sharedPreference);
            if (qrcode.exists()) {
                path = qrcode.getAbsolutePath();
                uiView.setViewQrcode(path);
                return;
            }
        }

        if (path == null) {
            try {
                Bitmap mBitmap = EncodingHandler.createQRCode(userInfo.getPeopleNo(), 200);
                path = saveBitmap(mBitmap,userInfo);
                SharedPreferencesHelper.$().put(key, path);
                uiView.setViewQrcode(path);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    public String saveBitmap(Bitmap bitmap,UserInfo userInfo) {
        String filename = userInfo.getPeopleNo() + ".png";
        File file = new File(NChatApplication.getFlyantsApplication().getCacheDir(), filename);
        try (FileOutputStream out = new FileOutputStream(file)){
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, out);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return file.getAbsolutePath();
    }

    @Override
    public void onViewDestroy() {

    }
}
