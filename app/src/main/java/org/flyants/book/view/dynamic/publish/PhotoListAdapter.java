package org.flyants.book.view.dynamic.publish;

import android.widget.LinearLayout;

import androidx.recyclerview.widget.RecyclerView;

import org.flyants.book.R;
import org.flyants.book.network.image.ImageLoader;
import org.flyants.book.network.image.glide.ImageLoaderImpl;
import org.flyants.book.utils.MediaBean;
import org.flyants.book.view.base.BaseRecyclerAdapter;
import org.flyants.book.view.base.RecyclerHolder;

import java.util.ArrayList;
import java.util.Collection;

class PhotoListAdapter   extends BaseRecyclerAdapter<MediaBean> {

    ImageLoader imageLoader = new ImageLoaderImpl();


    public PhotoListAdapter(RecyclerView recyclerView) {
        this(recyclerView, new ArrayList<>(), R.layout.photo_list_item);
    }

    @Override
    public void convert(RecyclerHolder holder, MediaBean item, int position, boolean isScrolling) {
        imageLoader.loader(cxt,item.getPath(), holder.getView(R.id.icon));
        if(item.getSelectIndex() == null || item.getSelectIndex() == 0){
            LinearLayout view = holder.getView(R.id.text_index_layout);
            view.setBackgroundResource(R.drawable.photo_unselected);
            holder.setText(R.id.text_index,"");
        }else{
            LinearLayout view = holder.getView(R.id.text_index_layout);
            view.setBackgroundResource(R.drawable.photo_selected);
            holder.setText(R.id.text_index,item.getSelectIndex()+"");
        }
    }

    public PhotoListAdapter(RecyclerView v, Collection<MediaBean> datas, int itemLayoutId) {
        super(v, datas, itemLayoutId);
    }

}