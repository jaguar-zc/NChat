package org.flyants.component.alert;

import android.content.Context;
import android.view.View;

import org.flyants.component.R;
import org.flyants.component.dialog.AlertComponentDialog;

public class AlertUtils {


    /**
     * 提示对话框
     *
     * @param context
     */
    public static void tipClick(Context context, String content, View.OnClickListener onClickListener) {

        AlertComponentDialog.Builder builder = new AlertComponentDialog.Builder(context, R.style.AppDialogStyle);
        builder.setContentView(R.layout.ui_ok_and_cancel_dialog_layout);
        builder.setText(R.id.ui_dialog_left_btn,"取消");
        builder.setText(R.id.ui_dialog_right_btn,"确定");
        builder.setText(R.id.ui_dialog_title_tv,"提示");
        builder.setText(R.id.ui_dialog_content_tv,content);
        final AlertComponentDialog dialog = builder.show();
        builder.setOnClickLisenter(R.id.ui_dialog_right_btn,onClickListener);
        builder.setOnClickLisenter(R.id.ui_dialog_left_btn, new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   dialog.dismiss();
               }
         });


    }
}
