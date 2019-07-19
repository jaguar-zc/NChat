package org.flyants.component.gallery;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.recyclerview.widget.RecyclerView;

import org.flyants.common.view.BaseRecyclerAdapter;
import org.flyants.common.view.RecyclerHolder;
import org.flyants.component.R;
import org.flyants.component.imageloader.ImageLoader;
import org.flyants.component.spi.ServiceLoadeerUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

class GalleryAdapter extends BaseRecyclerAdapter<MediaBean> implements BaseRecyclerAdapter.OnItemClickListener {

    ImageLoader imageLoader;
    private Collection<MediaBean> list = new ArrayList<>();
    private OnSelectedCount onSelectedCount;
    private int MAX_SELECTED_VALUE = 9;
    private int top = 0;

    public void setOnSelectedCount(OnSelectedCount onSelectedCount) {
        this.onSelectedCount = onSelectedCount;
    }

    public void setMAX_SELECTED_VALUE(int MAX_SELECTED_VALUE) {
        this.MAX_SELECTED_VALUE = MAX_SELECTED_VALUE;
    }

    public GalleryAdapter(RecyclerView v, Collection<MediaBean> datas) {
        this(v, datas, R.layout.gallery_item);
        setOnItemClickListener(this);
        imageLoader = ServiceLoadeerUtils.loaderImageLoader();
    }

    @Override
    public void convert(RecyclerHolder holder, MediaBean item, int position, boolean isScrolling) {
        imageLoader.loader(cxt, item.getPath(), (ImageView) holder.getView(R.id.icon));
        item.setPosition(position);
        if (item.getSelectIndex() == null || item.getSelectIndex() == 0) {
            LinearLayout view = holder.getView(R.id.text_index_layout);
            view.setBackgroundResource(R.drawable.gallery_unselected);
            holder.setText(R.id.text_index, "");
        } else {
            LinearLayout view = holder.getView(R.id.text_index_layout);
            view.setBackgroundResource(R.drawable.gallery_selected);
            holder.setText(R.id.text_index, item.getSelectIndex() + "");
        }
    }

    public GalleryAdapter(RecyclerView v, Collection<MediaBean> datas, int itemLayoutId) {
        super(v, datas, itemLayoutId);
        this.list = datas;
    }

    @Override
    public void onItemClick(View view, Object data, int position) {
        MediaBean mediaBean = (MediaBean) data;
        if (mediaBean.getSelectIndex() > 0) {
            top--;
            Integer selectIndexTemp = mediaBean.getSelectIndex();
            mediaBean.setSelectIndex(0);
            notifyItemChanged(position);
            //将 selectIndexTemp 之上的选项全部减1 刷新
            for (MediaBean bean : list) {
                if (bean.getSelectIndex() > selectIndexTemp) {
                    bean.setSelectIndex(bean.getSelectIndex() - 1);
                    notifyItemChanged(bean.getPosition());
                }
            }
        } else {
            if (top >= MAX_SELECTED_VALUE) {
                return;
            }
            top++;
            mediaBean.setSelectIndex(top);
            notifyItemChanged(position);
        }
        if (onSelectedCount != null) {
            onSelectedCount.onSelectedCount(top, MAX_SELECTED_VALUE);
        }
    }

    public List<MediaBean> getSelectedItem() {
        List<MediaBean> beanList = new ArrayList<>();
        for (MediaBean mediaBean : this.list) {
            if (mediaBean.getSelectIndex() > 0) {
                beanList.add(mediaBean);
            }
        }
        return beanList;
    }
}