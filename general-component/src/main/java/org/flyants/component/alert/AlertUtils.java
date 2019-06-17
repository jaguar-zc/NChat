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
        final AlertComponentDialog dialog = new AlertComponentDialog.Builder(context, R.style.AppDialogStyle)
                .setContentView(R.layout.ui_ok_and_cancel_dialog_layout)
                .setText(R.id.ui_dialog_left_btn, "取消")
                .setText(R.id.ui_dialog_right_btn, "确定")
                .setText(R.id.ui_dialog_title_tv, "提示")
                .setText(R.id.ui_dialog_content_tv, content)
                .show();

        dialog.setOnClickLisenter(R.id.ui_dialog_right_btn, onClickListener);
        dialog.setOnClickLisenter(R.id.ui_dialog_left_btn, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
    }
}
