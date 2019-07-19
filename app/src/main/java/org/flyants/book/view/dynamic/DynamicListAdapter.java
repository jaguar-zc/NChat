package org.flyants.book.view.dynamic;

import androidx.recyclerview.widget.RecyclerView;

import org.flyants.book.R;
import org.flyants.book.custom.NineGridDynamicImageListLayout;
import org.flyants.book.network.image.glide.IconImageLoaderImpl;
import org.flyants.book.view.base.BaseRecyclerAdapter;
import org.flyants.book.view.base.RecyclerHolder;
import org.flyants.component.imageloader.ImageLoader;

import java.util.ArrayList;
import java.util.Collection;

class DynamicListAdapter  extends BaseRecyclerAdapter<DynamicResp> {

    ImageLoader imageLoader = new IconImageLoaderImpl();


    public DynamicListAdapter(RecyclerView recyclerView) {
        this(recyclerView, new ArrayList<>(), R.layout.dynamic_item);
    }

    @Override
    public void convert(RecyclerHolder holder, DynamicResp item, int position, boolean isScrolling) {
        imageLoader.loader(cxt,item.getEncodedPrincipal(), holder.getView(R.id.icon));
        holder.setText(R.id.nickname, item.getNickName());
        holder.setText(R.id.showTyoe, item.getVisibility().name());
        holder.setText(R.id.text_content, item.getText());
        holder.setText(R.id.comments_count, item.getCommentsCount()+"");
        NineGridDynamicImageListLayout layout_nine_grid = holder.getView(R.id.layout_nine_grid);
        layout_nine_grid.setIsShowAll(false); //当传入的图片数超过9张时，是否全部显示
        layout_nine_grid.setSpacing(5); //动态设置图片之间的间隔
        layout_nine_grid.setUrlList(item.getImages());
    }

    public DynamicListAdapter(RecyclerView v, Collection<DynamicResp> datas, int itemLayoutId) {
        super(v, datas, itemLayoutId);
    }

}