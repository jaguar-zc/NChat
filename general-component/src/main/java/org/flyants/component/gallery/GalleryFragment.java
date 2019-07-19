package org.flyants.component.gallery;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.flyants.common.view.GridItemDecoration;
import org.flyants.component.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GalleryFragment extends Fragment implements View.OnClickListener, DevicePhotoUtils.OnPhotoListenner {

    RecyclerView recyclerView;
    LinearLayout idHeaderLayout;
    TextView idHeaderCompile;
    ImageView idHeaderBack;
    TextView idHeaderTitle;
    //    Spinner spinner;
    OnGallerylistener onGallerylistener;

    int selectCount;
    GalleryAdapter adapter;
    //    ArrayList<String> spinnerDataList = new ArrayList<>();
    List<MediaBean> mediaDataList = new ArrayList<>();

    private Boolean showHeader = true;

    public void setOnGallerylistener(OnGallerylistener onGallerylistener) {
        this.onGallerylistener = onGallerylistener;
    }

    public void setShowHeader(Boolean showHeader) {
        this.showHeader = showHeader;
    }

    public void setSelectCount(int selectCount) {
        this.selectCount = selectCount;
    }

    public int getLayoutId() {
        return R.layout.gallery;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutId(), container, false);
        recyclerView = view.findViewById(R.id.recycler_view);
        idHeaderLayout = view.findViewById(R.id.idHeaderLayout);
        idHeaderBack = view.findViewById(R.id.idHeaderBack);
        idHeaderCompile = view.findViewById(R.id.idHeaderCompile);
        idHeaderTitle = view.findViewById(R.id.idHeaderTitle);
//        spinner = view.findViewById(R.id.spinner);
        idHeaderBack.setOnClickListener(this);
        idHeaderCompile.setOnClickListener(this);
        if(!showHeader){
            idHeaderLayout.setVisibility(View.GONE);
        }
        DevicePhotoUtils.getAllPhotoInfo(getActivity(), this);
        return view;
    }



    @Override
    public void onStart() {
        super.onStart();
        Log.d("GALLETY","start");
    }

    @Override
    public void callback(List<MediaBean> mediaBeen, final HashMap<String, List<MediaBean>> allPhotosTemp) {
        mediaDataList.clear();
//        spinnerDataList.clear();
//        spinnerDataList.add("所有照片");
//        spinnerDataList.addAll(allPhotosTemp.keySet());
        for (Map.Entry<String, List<MediaBean>> stringListEntry : allPhotosTemp.entrySet()) {
            mediaDataList.addAll(stringListEntry.getValue());
        }

//        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item,spinnerDataList);  //创建一个数组适配器
//        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);     //设置下拉列表框的下拉选项样式
//        spinner.setAdapter(arrayAdapter);
//        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                String s = spinnerDataList.get(position);
//                if("所有照片".equals(s)){
//                    adapter.refresh(mediaDataList);
//                }else{
//                    List<MediaBean> mediaBeans = allPhotosTemp.get(s);
//                    adapter.refresh(mediaBeans);
//                }
//                adapter.notifyDataSetChanged();
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });
        adapter = new GalleryAdapter(recyclerView, mediaDataList);
        adapter.setMAX_SELECTED_VALUE(selectCount);
        adapter.setOnSelectedCount(new OnSelectedCount() {
            @Override
            public void onSelectedCount(int selectCount, int maxCount) {
                idHeaderTitle.setText(String.format("已选[%s/%s]", selectCount, maxCount));
            }
        });
        // 竖直方向的网格样式，每行四个Item
        GridLayoutManager mLayoutManager = new GridLayoutManager(getContext(), 4, RecyclerView.VERTICAL, false);
        recyclerView.addItemDecoration(new GridItemDecoration(getContext()));
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.idHeaderBack) {
            if (onGallerylistener != null) {
                onGallerylistener.close();
            }
            return;
        }

        if (v.getId() == R.id.idHeaderCompile) {
            if (onGallerylistener != null) {
                onGallerylistener.selected(adapter.getSelectedItem());
            }
            return;
        }
    }

    public List<String> getSelectedItem(){
        ArrayList<String> stringList = new ArrayList<>();
        for (MediaBean bean : adapter.getSelectedItem()) {
            stringList.add(bean.getPath());
        }
        return stringList;
    }


}
