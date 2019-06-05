package org.flyants.component.wheel;

import android.app.Activity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.zyyoona7.wheel.WheelView;

import org.flyants.component.R;
import org.flyants.component.dialog.AlertComponentDialog;

import java.util.List;

public class SelectedViewUtils {


    public static void show(final Activity activity, List<Object> list,final OnSelectedItem onSelectedItem){
        View inflate = LayoutInflater.from(activity).inflate(R.layout.wheel_selected, null,false);
        final AlertComponentDialog alertDialog = new AlertComponentDialog.Builder(activity)
                .setContentView(inflate)
                .setFromBottom(true)
                .show();

        Window window = alertDialog.getWindow();
        window.setGravity(Gravity.BOTTOM);
//        window.setWindowAnimations(R.style.dialog_animation);
        window.getDecorView().setPadding(0, 0, 0, 0);
        WindowManager.LayoutParams lp = window.getAttributes();
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        window.setAttributes(lp);

        final WheelView wheelview = inflate.findViewById(R.id.wheelview);
        wheelview.setTextSize(18,true);
        wheelview.setData(list);

        View cancel = inflate.findViewById(R.id.cancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });
        final View selected = inflate.findViewById(R.id.selected);
        selected.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onSelectedItem.onSelected( wheelview.getSelectedItemPosition());
                alertDialog.dismiss();
            }
        });
    }
}
