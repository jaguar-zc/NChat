package org.flyants.book.view.conversation.info;

import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

import org.flyants.book.R;
import org.flyants.book.custom.Header;
import org.flyants.book.network.image.glide.IconImageLoaderImpl;
import org.flyants.book.view.conversation.ConversationResp;
import org.flyants.common.mvp.impl.BaseActivity;
import org.flyants.component.imageloader.ImageLoader;
import org.flyants.component.spi.ServiceLoadeerUtils;

import java.util.Map;

import butterknife.BindView;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;

public class ConversationInfoView extends BaseActivity<ConversationInfoPrecenter> implements UIConversationInfoView {

    @BindView(R.id.idHeader)  Header header;
    @BindView(R.id.item_query_chat_content) LinearLayout item_query_chat_content;
    @BindView(R.id.item_add_user_to_group) ImageView item_add_user_to_group;
    @BindView(R.id.logo1) ImageView logo1;
    @BindView(R.id.user1)  TextView user1;

    ImageLoader imageLoader = new IconImageLoaderImpl();

    @BindView(R.id.item_message_top)  Switch item_message_top;
    @BindView(R.id.item_message_miandarao)  Switch item_message_miandarao;

    @BindView(R.id.item_setting_background) LinearLayout item_setting_background;
    @BindView(R.id.item_chean_chat_record) LinearLayout item_chean_chat_record;

    @Override
    public ConversationInfoPrecenter buildPresenter() {
        return new ConversationInfoPrecenter(this,this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.comversation_info;
    }

    @Override
    public void onViewInit() {
        header.setHeaderTitle("");
    }

    @Override
    public void setVeiwAttrs(ConversationResp resp) {
        header.setHeaderTitle(resp.getName());
        user1.setText(resp.getName());
        imageLoader.loader(resp.getIcon(),logo1);
        item_message_top.setChecked(resp.getTop()==1);
        item_message_miandarao.setChecked(resp.getDontDisturb()==1);
    }


    @OnClick(R.id.item_add_user_to_group)
    public void onClickitem_add_user_to_group(){

    }


    @OnClick(R.id.item_query_chat_content)
    public void onClickitem_query_chat_content(){

    }

    @OnClick(R.id.item_setting_background)
    public void onClickitem_setting_background(){

    }

    @OnClick(R.id.item_chean_chat_record)
    public void onClickitem_chean_chat_record(){

    }



    @OnCheckedChanged(R.id.item_message_top)
    public void onChangeitem_message_top(CompoundButton buttonView, boolean isChecked) {
        getPresenter().setMessageTop(isChecked);
    }

    @OnCheckedChanged(R.id.item_message_miandarao)
    public void onChangeitem_message_miandarao(CompoundButton buttonView, boolean isChecked) {
//        getPresenter().setChangePhone(isChecked);
        getPresenter().setDontDisturb(isChecked);
    }

    @Override
    public void onViewStart() {

    }

    @Override
    public void onViewDestroy() {

    }
}
