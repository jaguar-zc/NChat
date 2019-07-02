package org.flyants.book.view.area;

import androidx.recyclerview.widget.RecyclerView;

import org.flyants.book.R;
import org.flyants.book.view.base.BaseRecyclerAdapter;
import org.flyants.book.view.base.RecyclerHolder;

import java.util.ArrayList;
import java.util.Collection;

public class AreaAdapter extends BaseRecyclerAdapter<Provinces> {

    public AreaAdapter(RecyclerView recyclerView) {
        this(recyclerView, new ArrayList<>(), R.layout.area_item);
    }

    @Override
    public void convert(RecyclerHolder holder, Provinces item, int position, boolean isScrolling) {
        holder.setText(R.id.name,item.getName());
    }

    public AreaAdapter(RecyclerView v, Collection<Provinces> datas, int itemLayoutId) {
        super(v, datas, itemLayoutId);
    }

}
