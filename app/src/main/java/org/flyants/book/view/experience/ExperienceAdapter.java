package org.flyants.book.view.experience;

import android.support.v7.widget.RecyclerView;

import org.flyants.book.R;
import org.flyants.book.network.image.ImageLoader;
import org.flyants.book.network.image.glide.CenterCropImageLoaderImpl;
import org.flyants.book.view.base.BaseRecyclerAdapter;
import org.flyants.book.view.base.RecyclerHolder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ExperienceAdapter extends BaseRecyclerAdapter<ConversationDto> {

    ImageLoader imageLoader = new CenterCropImageLoaderImpl();


    static List<ConversationDto>   lists = new ArrayList<ConversationDto>(){
        public List<ConversationDto> $(){
            for (int i = 0; i < 10; i++) {
                this.add(new ConversationDto());
            }
            return this;
        }
    }.$();




    public ExperienceAdapter(RecyclerView recyclerView) {
        this(recyclerView, lists, R.layout.experience_item);
    }

    @Override
    public void convert(RecyclerHolder holder, ConversationDto item, int position, boolean isScrolling) {
//        imageLoader.loader(item.getIcon(),holder.getView(R.id.icon));
//        holder.setText(R.id.username,item.getUsername());
//        holder.setText(R.id.time_str,item.getTimeStr());
//        holder.setText(R.id.last_msg,item.getLastMsg());
    }

    public ExperienceAdapter(RecyclerView v, Collection<ConversationDto> datas, int itemLayoutId) {
        super(v, datas, itemLayoutId);
    }


}
