package org.flyants.book.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.flyants.book.R;

public class NavigationView extends LinearLayout {

    Object[][] tabs = {{"消息", R.mipmap.aei, R.mipmap.aeh}, {"动态", R.mipmap.adt, R.mipmap.adr}, {"我的", R.mipmap.ael, R.mipmap.aej}};

    private Integer selectedIndex = 0;

    private OnNavigationViewClickListener onNavigationViewClickListener;

    private LinearLayout containerView;

    private LinearLayout nav_item_1;
    private ImageView nav_item_1_img;
    private TextView nav_item_1_tag;

    private LinearLayout nav_item_2;
    private ImageView nav_item_2_img;
    private TextView nav_item_2_tag;


    private LinearLayout nav_item_3;
    private ImageView nav_item_3_img;
    private TextView nav_item_3_tag;

    public NavigationView(Context context, AttributeSet attrs) {
        super(context, attrs);
        // 加载布局
        LayoutInflater.from(context).inflate(R.layout.navigation_view, this);
        containerView = findViewById(R.id.containerView);
        nav_item_1 = findViewById(R.id.nav_item_1);
        nav_item_1_img = findViewById(R.id.nav_item_1_img);
        nav_item_1_tag = findViewById(R.id.nav_item_1_tag);

        nav_item_2 = findViewById(R.id.nav_item_2);
        nav_item_2_img = findViewById(R.id.nav_item_2_img);
        nav_item_2_tag = findViewById(R.id.nav_item_2_tag);

        nav_item_3 = findViewById(R.id.nav_item_3);
        nav_item_3_img = findViewById(R.id.nav_item_3_img);
        nav_item_3_tag = findViewById(R.id.nav_item_3_tag);

        nav_item_1_tag.setText((String) tabs[0][0]);
        nav_item_2_tag.setText((String) tabs[1][0]);
        nav_item_3_tag.setText((String) tabs[2][0]);

        nav_item_1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                setSelectedIndex(0);
                if (onNavigationViewClickListener != null) {
                    onNavigationViewClickListener.onNavigationViewClickListener(0);
                }
            }
        });
        nav_item_2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                setSelectedIndex(1);
                if (onNavigationViewClickListener != null) {
                    onNavigationViewClickListener.onNavigationViewClickListener(1);
                }
            }
        });

        nav_item_3.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                setSelectedIndex(2);
                if (onNavigationViewClickListener != null) {
                    onNavigationViewClickListener.onNavigationViewClickListener(2);
                }
            }
        });
        refresh();
    }

    public void refresh() {
        nav_item_1_img.setImageResource(selectedIndex == 0 ? (int) tabs[0][1] : (int) tabs[0][2]);
        nav_item_2_img.setImageResource(selectedIndex == 1 ? (int) tabs[1][1] : (int) tabs[1][2]);
        nav_item_3_img.setImageResource(selectedIndex == 2 ? (int) tabs[2][1] : (int) tabs[2][2]);
    }

    public void setOnNavigationViewClickListener(OnNavigationViewClickListener onNavigationViewClickListener) {
        this.onNavigationViewClickListener = onNavigationViewClickListener;
    }

    public void setSelectedIndex(Integer selectedIndex) {
        this.selectedIndex = selectedIndex;
        refresh();
    }

    public interface OnNavigationViewClickListener {
        void onNavigationViewClickListener(int tab);
    }

}
