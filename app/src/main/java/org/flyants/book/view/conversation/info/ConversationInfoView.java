package org.flyants.book.view.conversation.info;

import android.widget.CompoundButton;

import org.flyants.book.R;
import org.flyants.book.custom.Header;
import org.flyants.common.mvp.impl.BaseActivity;

import java.util.Map;

import butterknife.BindView;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;

public class ConversationInfoView extends BaseActivity<ConversationInfoPrecenter> implements UIConversationInfoView {

    @BindView(R.id.idHeader)  Header header;






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

    @Override
    public void setVeiwAttrs(Map<String, Object> resp) {

    }

    @OnCheckedChanged(R.id.item_message_top)
    public void onChangeitem_message_top(CompoundButton buttonView, boolean isChecked) {
//        getPresenter().setChangePhone(isChecked);
    }

    @OnCheckedChanged(R.id.item_message_miandarao)
    public void onChangeitem_message_miandarao(CompoundButton buttonView, boolean isChecked) {
//        getPresenter().setChangePhone(isChecked);
    }

    @Override
    public void onViewStart() {

    }

    @Override
    public void onViewDestroy() {

    }
}
