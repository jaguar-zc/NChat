package org.flyants.book.view.conversation.window;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.apache.commons.lang3.StringUtils;
import org.flyants.book.R;
import org.flyants.book.network.image.ImageLoader;
import org.flyants.book.network.image.glide.CenterCropImageLoaderImpl;
import org.flyants.book.utils.LogUtils;
import org.flyants.book.view.conversation.window.holder.TextHolder;
import org.flyants.book.view.my.UserInfo;

import java.util.ArrayList;
import java.util.List;

public class ConversationWindowAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    UserInfo userInfo;
    List<MessageResp> messageRespList = new ArrayList<>();

    Context mContext;

    public ConversationWindowAdapter(UserInfo userInfo, Context mContext) {
        this.userInfo = userInfo;
        this.mContext = mContext;
    }

    private ImageLoader imageLoader = new CenterCropImageLoaderImpl();

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LogUtils.d("Type:"+viewType);
        if(viewType == 0){
            View item = LayoutInflater.from(mContext).inflate(R.layout.conversation_window_text_left , parent ,false);
            LogUtils.d("aaa","onCreateViewHolder————"+viewType);
            LinearLayout containerView = item.findViewById(R.id.containerView);
            TextView content = item.findViewById(R.id.item_content);
            ImageView item_icon = item.findViewById(R.id.item_icon);
            return new TextHolder(item,containerView,content,item_icon);
        }else if(viewType == 1){
            View item = LayoutInflater.from(mContext).inflate(R.layout.conversation_window_text_right , parent ,false);
            LogUtils.d("aaa","onCreateViewHolder————"+viewType);
            LinearLayout containerView = item.findViewById(R.id.containerView);
            TextView content = item.findViewById(R.id.item_content);
            ImageView item_icon = item.findViewById(R.id.item_icon);
            return new TextHolder(item,containerView,content,item_icon);
        }

        return null;
    }

    public Boolean isRight(MessageResp messageResp) {
        return StringUtils.equals(messageResp.getMessageUserId(),userInfo.getMessageUserId());
    }

    @Override
    public int getItemViewType(int position) {
        MessageResp messageResp = messageRespList.get(position);
        return isRight(messageResp) ?1:0;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof  TextHolder){
            MessageResp mData = messageRespList.get(position);
            ((TextHolder) holder).getContent().setText(mData.getBody());
            ((TextHolder) holder).getContainerView().setBackgroundColor(mContext.getResources().getColor(R.color.windowBackground));
//            ((TextHolder) holder).content.setText(mData.getBody());
        }
    }

    @Override
    public int getItemCount() {
        return messageRespList.size();
    }

    public int addItem(MessageResp lastMessage){
        messageRespList.add(lastMessage);
        int size = messageRespList.size();
        notifyItemInserted(size);
        return size;
    }

    public void addAll(List<MessageResp> rows) {
        messageRespList.clear();
        messageRespList.addAll(rows);
        notifyDataSetChanged();
    }
}
