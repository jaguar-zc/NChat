package org.flyants.book.view.conversation.window;

import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;

import org.flyants.book.R;
import org.flyants.book.custom.Header;
import org.flyants.book.view.conversation.ConversationResp;
import org.flyants.book.view.my.UserInfo;
import org.flyants.common.mvp.impl.BaseActivity;
import org.flyants.common.utils.KeyboardUtils;

import java.util.List;

import butterknife.BindView;

import static android.text.InputType.TYPE_TEXT_FLAG_MULTI_LINE;
import static androidx.recyclerview.widget.RecyclerView.VERTICAL;

public class ConversationWindowView extends BaseActivity<ConversationWindowPrecenter> implements UIConversationWindowView {

    public static final String PARAM_NAME = "ConversationId";

    @BindView(R.id.idHeader) Header idHeader;
    @BindView(R.id.recycler_view)
    RecyclerView recycler_view;
    @BindView(R.id.input_message) EditText input_message;

    ConversationWindowAdapter conversationWindowAdapter ;

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
        input_message.setInputType(TYPE_TEXT_FLAG_MULTI_LINE);
        input_message.setSingleLine(false);
        input_message.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEND) {
                    getPresenter().sendMessage(input_message.getText().toString());
                    return true;
                }
                return false;
            }
        });
    }


    @Override
    public void loadUserInfoComplete(UserInfo info) {
        conversationWindowAdapter = new ConversationWindowAdapter(info,this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(VERTICAL);
        recycler_view.setLayoutManager(layoutManager);
        recycler_view.setAdapter(conversationWindowAdapter);
        recycler_view.setItemAnimator( new DefaultItemAnimator());
    }

    @Override
    public void publicMessageSuccess() {
        input_message.setText("");
        KeyboardUtils.hideKeyboard(input_message);
    }

    @Override
    public void setPullLoadMoreCompleted(int i, List<MessageResp> rows) {
        conversationWindowAdapter.refresh(rows);
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
