package org.flyants.book.view.firends.list;

import android.view.View;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import org.flyants.book.R;
import org.flyants.book.network.image.glide.IconImageLoaderImpl;
import org.flyants.book.view.base.BaseRecyclerAdapter;
import org.flyants.book.view.base.RecyclerHolder;
import org.flyants.book.view.conversation.user.MessageUserSimpleInfo;
import org.flyants.component.imageloader.ImageLoader;

import java.util.ArrayList;
import java.util.Collection;

class FirendsListAdapter extends BaseRecyclerAdapter<MessageUserSimpleInfo> {

    private ImageLoader imageLoader = new IconImageLoaderImpl();
    UIFirendsListView uiFirendsListView;

    public FirendsListAdapter(RecyclerView recyclerView,UIFirendsListView uiFirendsListView) {
        this(recyclerView, new ArrayList<>(), R.layout.firends_item);
        this.uiFirendsListView = uiFirendsListView;
    }

    @Override
    public void convert(RecyclerHolder holder, MessageUserSimpleInfo item, int position, boolean isScrolling) {
        ImageView icon = (ImageView) holder.getView(R.id.icon)   ;
        imageLoader.loader(cxt,item.getEncodedPrincipal(),icon);
        holder.setText(R.id.name,item.getNickName());

        View view = holder.getView(R.id.to);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uiFirendsListView.toConversationWindow(item);
            }
        });
    }

    public FirendsListAdapter(RecyclerView v, Collection<MessageUserSimpleInfo> datas, int itemLayoutId) {
        super(v, datas, itemLayoutId);
    }

}
