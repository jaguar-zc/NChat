package org.flyants.book.custom;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.flyants.book.R;

public class Header extends LinearLayout {

    private TextView headerTitle;
    private ImageView headerLeft;
    private LinearLayout headerRight;
    private LinearLayout container;


    public Header(Context context,  @Nullable AttributeSet attrs) {
        super(context, attrs);
        // 加载布局
        LayoutInflater.from(context).inflate(R.layout.header, this);
        headerTitle = findViewById(R.id.header_title);
        headerLeft = findViewById(R.id.header_left);
        headerRight = findViewById(R.id.header_right);
        container = findViewById(R.id.container);
        headerTitle.setText(R.string.app_name);
        headerLeft.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(context instanceof Activity){
                    ((Activity)context).finish();
                }
            }
        });
    }

    public void hideHeaderLeft(){
        headerLeft.setVisibility(View.INVISIBLE);
        headerLeft.setOnClickListener(null);
    }

    public void setHeaderBackgroundAlpha(int alpha){
        container.getBackground().setAlpha(alpha);
    }



    public void setBackColorWhite(){
        headerLeft.setImageResource(R.mipmap.ahv);
    }


    public void setHeaderLeft(int res){
        headerLeft.setImageResource(res);
    }


    public void setTitleColor(int resColor){
        headerTitle.setTextColor(getResources().getColor(resColor));
    }

    public void setBackgrundColor(int resColor){
        if(resColor == 0){
            container.setBackgroundResource(R.color.transparent);
        }else {
            container.setBackgroundColor(getResources().getColor(resColor));
        }
    }

    public void setHeaderRight(View view){
        headerRight.addView(view);
    }

    public void setHeaderRightParams(ViewGroup.LayoutParams params){
        headerRight.setLayoutParams(params);
    }


    public void setHeaderTitle(String title){
        headerTitle.setText(title);
    }


    public void setOnLeftClick(OnClickListener click){
        headerLeft.setOnClickListener(click);
    }
}
