package org.flyants.book.view.dynamic;

import com.liaoinstan.springview.widget.SpringView;

import org.flyants.book.network.RequestUtils;
import org.flyants.book.network.okhttp.RespCall;
import org.flyants.book.resources.DynamicApis;
import org.flyants.book.utils.Page;
import org.flyants.common.mvp.impl.BasePresenter;

import java.util.ArrayList;
import java.util.List;

class DynamicListPrecenter extends BasePresenter<DynamicListView,UIDynamicListView>  implements SpringView.OnFreshListener{


    DynamicApis dynamicApis ;

    int page = 1;


    public DynamicListPrecenter(DynamicListView t, UIDynamicListView uiDynamicListView) {
        super(t, uiDynamicListView);
    }

    @Override
    public void onViewInit() {
        dynamicApis = RequestUtils.build(DynamicApis.class);
    }

    @Override
    public void onViewStart() {
        onRefresh();
    }

    public void onLoadList(){
        dynamicApis.getDynamicListByFriend(page).enqueue(new RespCall<Page<DynamicResp>>() {
            @Override
            public void onResp(Page<DynamicResp> resp) {
                page++;
//                uiView.setPullLoadMoreCompleted(page,resp.getRows());
                for (int i = 0; i < 10; i++) {
                    DynamicResp dynamicResp = new DynamicResp();
                    dynamicResp.setEncodedPrincipal("http://flyants.oss-cn-shanghai.aliyuncs.com/conversation/1ef897ba-3472-4928-814f-e468681504b7.jpg");
                    dynamicResp.setCommentsCount(1);
                    dynamicResp.setVisibility(DynamicVisibility.ALL);
                    dynamicResp.setNickName("哇哈哈");
                    dynamicResp.setText("i你哥哥格局积分非法违法飞飞哥哥哥哥纷纷个愤愤愤愤愤愤愤愤愤愤愤愤愤愤愤愤愤愤水水水水水水水水水水水水水古风哥哥哥哥哥哥哥哥哥哥哥哥哥哥哥哥哥");
                    List<String> images = new ArrayList<>();
                    images.add("http://flyants.oss-cn-shanghai.aliyuncs.com/conversation/1ef897ba-3472-4928-814f-e468681504b7.jpg");
                    images.add("http://flyants.oss-cn-shanghai.aliyuncs.com/conversation/1ef897ba-3472-4928-814f-e468681504b7.jpg");
                    images.add("http://flyants.oss-cn-shanghai.aliyuncs.com/conversation/1ef897ba-3472-4928-814f-e468681504b7.jpg");
                    images.add("http://flyants.oss-cn-shanghai.aliyuncs.com/conversation/1ef897ba-3472-4928-814f-e468681504b7.jpg");
                    images.add("http://flyants.oss-cn-shanghai.aliyuncs.com/conversation/1ef897ba-3472-4928-814f-e468681504b7.jpg");
                    images.add("http://flyants.oss-cn-shanghai.aliyuncs.com/conversation/1ef897ba-3472-4928-814f-e468681504b7.jpg");
                    images.add("http://flyants.oss-cn-shanghai.aliyuncs.com/conversation/1ef897ba-3472-4928-814f-e468681504b7.jpg");
                    images.add("http://flyants.oss-cn-shanghai.aliyuncs.com/conversation/1ef897ba-3472-4928-814f-e468681504b7.jpg");
                    images.add("http://flyants.oss-cn-shanghai.aliyuncs.com/conversation/1ef897ba-3472-4928-814f-e468681504b7.jpg");
                    dynamicResp.setImages(images);
                    resp.getRows().add(dynamicResp);
                }
                uiView.setPullLoadMoreCompleted(page,resp.getRows());

            }
        });
    }

    @Override
    public void onRefresh() {
        page = 1;
        onLoadList();
    }

    @Override
    public void onLoadmore() {
        onLoadList();
    }

    @Override
    public void onViewDestroy() {

    }
}
