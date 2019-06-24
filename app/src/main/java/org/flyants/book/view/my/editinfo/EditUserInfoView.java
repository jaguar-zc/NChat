package org.flyants.book.view.my.editinfo;

import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.flyants.book.R;
import org.flyants.book.custom.Header;
import org.flyants.book.network.image.ImageLoader;
import org.flyants.book.network.image.glide.IconImageLoaderImpl;
import org.flyants.book.view.my.UserInfo;
import org.flyants.common.mvp.impl.BaseActivity;
import org.flyants.component.alert.AlertUtils;
import org.flyants.component.prompt.PromptUtils;
import org.flyants.component.selected.OnSelectedItem;
import org.flyants.component.selected.SelectedViewUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class EditUserInfoView extends BaseActivity<EditUserInfoPrencenter> implements UIEditUserInfoView {

    @BindView(R.id.idHeader)
    Header header;
    @BindView(R.id.cover_bg_layout)
    RelativeLayout cover_bg_layout;
    @BindView(R.id.icon)
    ImageView icon;
    @BindView(R.id.replace_bg)
    TextView replace_bg;

    @BindView(R.id.name_layout)
    LinearLayout name_layout;
    @BindView(R.id.name_text)
    TextView name_text;

    @BindView(R.id.introduction_layout)
    LinearLayout introduction_layout;
    @BindView(R.id.introduction_text)
    TextView introduction_text;

    @BindView(R.id.chatno_layout)
    LinearLayout chatno_layout;
    @BindView(R.id.chatno_text)
    TextView chatno_text;

    @BindView(R.id.sex_layout)
    LinearLayout sex_layout;
    @BindView(R.id.sex_text)
    TextView sex_text;

    @BindView(R.id.location_layout)
    LinearLayout location_layout;
    @BindView(R.id.location_text)
    TextView location_text;


    ImageLoader imageLoader = new IconImageLoaderImpl();

    List<Object> listNames = new ArrayList<>(PeopleSex.listNames());

    @Override
    public EditUserInfoPrencenter buildPresenter() {
        return new EditUserInfoPrencenter(this, this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.edit_user_info;
    }

    @Override
    public void onViewInit() {
        header.setHeaderTitle("编辑个人资料");
    }

    @Override
    public void onViewStart() {

    }

    @Override
    public void onViewDestroy() {

    }


    @OnClick(R.id.name_layout)
    public void OnClickname_layout() {
        PromptUtils.tipClick(this, name_text.getText().toString(), new PromptUtils.OnCallback() {
            @Override
            public Boolean callback(String content) {
                if (content.length() > 0) {
                    name_text.setText(content);
                    getPresenter().updateNickName(content);
                }
                return true;
            }
        });
    }

    @OnClick(R.id.introduction_layout)
    public void OnClickintroduction_layout() {
        PromptUtils.tipClick(this, introduction_text.getText().toString(), new PromptUtils.OnCallback() {
            @Override
            public Boolean callback(String content) {
                if (content.length() > 0) {
                    introduction_text.setText(content);
                    getPresenter().updateIntroduction(content);
                }
                return true;
            }
        });
    }

    @OnClick(R.id.chatno_layout)
    public void OnClickchatno_layout() {
//        ToastUtils.show("不可以修改");
        AlertUtils.tipClick(this, "不可以修改", null);
    }

    @OnClick(R.id.sex_layout)
    public void OnClicksex_layout() {
        SelectedViewUtils.show(this, listNames, new OnSelectedItem() {
            @Override
            public void onSelected(int index) {
                PeopleSex sex = PeopleSex.nameOfPeopleSex(listNames.get(index).toString());
                sex_text.setText(sex.getName());
                getPresenter().updateSex(sex.getValue());
            }
        });
    }

    @OnClick(R.id.location_layout)
    public void OnClicklocation_layout() {

    }

    @Override
    public void setVeiwAttrs(UserInfo resp) {
        imageLoader.loader(resp.getEncodedPrincipal(), icon);
        name_text.setText(resp.getNickName());
        introduction_text.setText(resp.getIntroduction() == null ? "" : resp.getIntroduction());
        chatno_text.setText(resp.getPeopleNo() == null ? "" : resp.getPeopleNo());
        sex_text.setText(PeopleSex.valueOfPeopleSex(resp.getSex()).getName());
        location_text.setText(resp.getLocation() == null ? "" : resp.getLocation());
    }
}
