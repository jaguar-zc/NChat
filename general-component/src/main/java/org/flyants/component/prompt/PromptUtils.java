package org.flyants.component.prompt;

import android.content.Context;
import android.view.View;

import org.flyants.component.R;
import org.flyants.component.dialog.AlertComponentDialog;

public class PromptUtils {

    /**
     * 输入对话框
     *
     * @param context
     */
    public static void tipClick(Context context, String content, final OnCallback onClickListener) {
        final AlertComponentDialog dialog = new AlertComponentDialog.Builder(context, R.style.AppDialogStyle)
                .setContentView(R.layout.prompt_dialog_layout)
                .setText(R.id.ui_dialog_left_btn, "取消")
                .setText(R.id.ui_dialog_right_btn, "确定")
                .setText(R.id.ui_dialog_title_tv, "提示")
                .setVisible(R.id.ui_dialog_title_tv, true)
                .setText(R.id.ui_dialog_content_tv, content)
                .show();


        dialog.setOnClickLisenter(R.id.ui_dialog_right_btn, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = dialog.getText(R.id.ui_dialog_content_tv);
                if(onClickListener != null){
                    Boolean callback = onClickListener.callback(text);
                    if(callback){
                        dialog.dismiss();
                    }
                }
            }
        });
        dialog.setOnClickLisenter(R.id.ui_dialog_left_btn, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
    }

    public interface OnCallback{
        public Boolean callback(String content);
    }
}
