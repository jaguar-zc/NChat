package org.flyants.book.view.conversation.window;

import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.liaoinstan.springview.widget.SpringView;

import org.flyants.book.R;
import org.flyants.book.custom.Header;
import org.flyants.book.view.conversation.ConversationResp;
import org.flyants.common.mvp.impl.BaseActivity;

import butterknife.BindView;

public class ConversationWindowView extends BaseActivity<ConversationWindowPrecenter> implements UIConversationWindowView {

    public static final String PARAM_NAME = "ConversationId";



    @BindView(R.id.idHeader) Header idHeader;
    @BindView(R.id.recycler_view) RecyclerView recycler_view;


    public int getStatusBarColor(){
        return R.color.windowBackground;
    }


    @Override
    public ConversationWindowPrecenter buildPresenter() {
        return new ConversationWindowPrecenter(this,this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.conversation_window;
    }

    @Override
    public void onViewInit() {
        ImageView right = new ImageView(this);
        right.setImageResource(R.mipmap.a26);
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams( ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        int pxDimension = (int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_PX, 30,this.getResources().getDisplayMetrics());
        right.setLayoutParams(params);
        right.setPadding(pxDimension,pxDimension,pxDimension,pxDimension);
        idHeader.setHeaderRight(right);
        idHeader.setBackgrundColor(getStatusBarColor());
    }

    @Override
    public void onViewStart() {

    }

    @Override
    public void onViewDestroy() {

    }

    @Override
    public void setVeiwAttrs(ConversationResp resp) {
        idHeader.setHeaderTitle(resp.getName());
    }
}
