package org.flyants.book.view.my;

import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;

import org.flyants.book.R;
import org.flyants.book.network.image.ImageLoader;
import org.flyants.book.network.image.glide.ImageLoaderImpl;
import org.flyants.book.view.base.BaseRecyclerAdapter;
import org.flyants.book.view.base.RecyclerHolder;

import java.util.Collection;
import java.util.List;

public class MyViewAdapter extends BaseRecyclerAdapter<WorksModel> {

    ImageLoader imageLoader = new ImageLoaderImpl();

    public MyViewAdapter(RecyclerView v, Collection<WorksModel> datas, int itemLayoutId) {
        super(v, datas, itemLayoutId);
    }

    public MyViewAdapter(RecyclerView rv, List<WorksModel> worksModelList, MyView myView) {
        this(rv,worksModelList, R.layout.works_item);
    }

    @Override
    public void convert(RecyclerHolder holder, WorksModel item, int position, boolean isScrolling) {
        ImageView view = holder.getView(R.id.item_image);
        imageLoader.loader(item.getIcon(),view);
        holder.setText(R.id.item_text,item.getTitle());
    }
}
