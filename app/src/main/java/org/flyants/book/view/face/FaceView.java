package org.flyants.book.view.face;

import org.flyants.book.R;
import org.flyants.book.custom.Header;
import org.flyants.common.mvp.impl.BaseActivity;

import butterknife.BindView;

public class FaceView extends BaseActivity<FacePrecenter> implements UIFaceView{

    @BindView(R.id.idHeader)
    Header idHeader;
    @Override
    public FacePrecenter buildPresenter() {
        return new FacePrecenter(this,this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.face;
    }

    @Override
    public void onViewInit() {
        idHeader.setHeaderTitle("表情");
    }

    @Override
    public void onViewStart() {

    }

    @Override
    public void onViewDestroy() {

    }

    @Override
    public void setVeiwAttrs(Object resp) {

    }
}
