package org.flyants.book.view.setting.addmetype;

import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

import org.flyants.book.R;
import org.flyants.book.custom.Header;
import org.flyants.book.dto.PeopleAppConfig;
import org.flyants.book.view.my.UserInfo;
import org.flyants.common.mvp.impl.BaseActivity;

import butterknife.BindView;
import butterknife.OnCheckedChanged;

public class AddMeMethodView extends BaseActivity<AddMeMethodPrecenter> implements UIAddMeMethodView {

    @BindView(R.id.idHeader)
    Header idHeader;
    @BindView(R.id.me_phone_lable)
    TextView me_phone_lable;
    @BindView(R.id.me_phone)
    Switch me_phone;
    @BindView(R.id.chat_no_lable)
    TextView chat_no_lable;
    @BindView(R.id.chat_no)
    Switch chat_no;
    @BindView(R.id.me_qrcode)
    Switch me_qrcode;

    @Override
    public AddMeMethodPrecenter buildPresenter() {
        return new AddMeMethodPrecenter(this, this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.add_me_method;
    }

    @Override
    public void onViewInit() {
        idHeader.setHeaderTitle("添加我的方式");
    }

    @Override
    public void setViewAttrsConfig(PeopleAppConfig appConfig) {
        me_phone.setChecked(appConfig.getUsePhonePlusMe() == 1);
        chat_no.setChecked(appConfig.getUseChatNoPlusMe() == 1);
        me_qrcode.setChecked(appConfig.getUseQrCodePlusMe() == 1);
    }

    @Override
    public void setViewAttrsUserInfo(UserInfo userInfo) {
        me_phone_lable.setText("手机号:" + userInfo.getPhone());
        chat_no_lable.setText(getString(R.string.AntsChatId) + ":" + userInfo.getPeopleNo());
    }

    @OnCheckedChanged(R.id.me_phone)
    public void onChangePhone(CompoundButton buttonView, boolean isChecked) {
        getPresenter().setChangePhone(isChecked);
    }

    @OnCheckedChanged(R.id.chat_no)
    public void onChangeChatNo(CompoundButton buttonView, boolean isChecked) {
        getPresenter().setChangeChatNo(isChecked);
    }

    @OnCheckedChanged(R.id.me_qrcode)
    public void onChangeQrCode(CompoundButton buttonView, boolean isChecked) {
        getPresenter().setChangeQrCode(isChecked);
    }

    @Override
    public void onViewStart() {

    }

    @Override
    public void onViewDestroy() {

    }
}
