package org.flyants.book.view.my.meinfo;

import android.support.v7.widget.RecyclerView;

import org.flyants.book.R;
import org.flyants.book.network.image.ImageLoader;
import org.flyants.book.network.image.glide.CenterCropImageLoaderImpl;
import org.flyants.book.view.base.BaseRecyclerAdapter;
import org.flyants.book.view.base.RecyclerHolder;
import org.flyants.book.view.dynamic.DynamicResp;

import java.util.Collection;

class MeInfoAdapter  extends BaseRecyclerAdapter<DynamicResp> {

    ImageLoader imageLoader = new CenterCropImageLoaderImpl();


//    static List<DynamicResp> lists = new ArrayList<DynamicResp>() {
//        public List<DynamicResp> $() {
//            for (int i = 0; i < 10; i++) {
//                this.add(new DynamicResp());
//            }
//            return this;
//        }
//    }.$();


    public MeInfoAdapter(RecyclerView recyclerView) {
        this(recyclerView, null, R.layout.dynamic_item);
    }

    @Override
    public void convert(RecyclerHolder holder, DynamicResp item, int position, boolean isScrolling) {
//        imageLoader.loader(item.getIcon(),holder.getView(R.id.icon));
//        holder.setText(R.id.username,item.getUsername());
//        holder.setText(R.id.time_str,item.getTimeStr());
//        holder.setText(R.id.last_msg,item.getLastMsg());
    }

    public MeInfoAdapter(RecyclerView v, Collection<DynamicResp> datas, int itemLayoutId) {
        super(v, datas, itemLayoutId);
    }
}