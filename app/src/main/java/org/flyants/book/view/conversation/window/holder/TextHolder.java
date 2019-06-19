package org.flyants.book.view.conversation.window.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TextHolder extends RecyclerView.ViewHolder {

    private LinearLayout containerView;
    private TextView content;
    private ImageView icon;

    public LinearLayout getContainerView() {
        return containerView;
    }

    public TextView getContent() {
        return content;
    }

    public ImageView getIcon() {
        return icon;
    }

    public TextHolder(@NonNull View itemView) {
        super(itemView);
    }

    public TextHolder(@NonNull View itemView, TextView content, ImageView icon) {
        super(itemView);
        this.content = content;
        this.icon = icon;
    }

    public TextHolder(@NonNull View itemView, LinearLayout containerView, TextView content, ImageView icon) {
        super(itemView);
        this.containerView = containerView;
        this.content = content;
        this.icon = icon;
    }
}
