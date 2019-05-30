package org.flyants.book.utils;

import com.maning.mndialoglibrary.MToast;

import org.flyants.book.NChatApplication;

public abstract class ToastUtils {


    public static void show(String str){
        MToast.makeTextShort(NChatApplication.getFlyantsApplication(), str);

//        Toast.makeText(DuomiApplication.getDuomiApplication(),str,Toast.LENGTH_LONG).show();
//        Toast toast = new Toast(DuomiApplication.getDuomiApplication());
//        toast.setGravity(Gravity.CENTER, 0, 0);
//        toast.setDuration(Toast.LENGTH_LONG);
//        toast.setText(str);
//        toast.show();
    }
}
