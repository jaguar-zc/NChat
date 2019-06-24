package org.flyants.book.view.conversation;

import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import org.apache.commons.lang3.StringUtils;
import org.flyants.book.R;
import org.flyants.book.network.image.ImageLoader;
import org.flyants.book.network.image.glide.CenterCropImageLoaderImpl;
import org.flyants.book.utils.ConversationTimeUtils;
import org.flyants.book.view.base.BaseRecyclerAdapter;
import org.flyants.book.view.base.RecyclerHolder;

import java.util.ArrayList;
import java.util.Collection;

public class ConversationAdapter extends BaseRecyclerAdapter<ConversationResp> {

    private ImageLoader imageLoader = new CenterCropImageLoaderImpl();

    public ConversationAdapter(RecyclerView recyclerView) {
        this(recyclerView, new ArrayList<>(), R.layout.conversation_item);
    }

    @Override
    public void convert(RecyclerHolder holder, ConversationResp item, int position, boolean isScrolling) {
        ImageView icon = (ImageView) holder.getView(R.id.icon)   ;
        imageLoader.loader(cxt,item.getIcon(),icon);
        holder.setText(R.id.name,item.getName());
        if(item.getLastMessage() != null){
            holder.setText(R.id.time, ConversationTimeUtils.toDateStr((Long.valueOf(item.getLastMessage().getSendTime()))));
            if(StringUtils.equals(item.getLastMessage().getMessageType(),"TEXT")){
                String body = item.getLastMessage().getBody();
                if(body.length()>15){
                    body = body.substring(0,15)+"...";
                }
                holder.setText(R.id.msg,body);
            }else if(StringUtils.equals(item.getLastMessage().getMessageType(),"IMAGE")){
                holder.setText(R.id.msg,"图片");
            }

        }
    }

    public ConversationAdapter(RecyclerView v, Collection<ConversationResp> datas, int itemLayoutId) {
        super(v, datas, itemLayoutId);
    }


}
