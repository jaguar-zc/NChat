package org.flyants.book.store;

import org.flyants.common.store.IStore;

import java.util.ArrayList;
import java.util.List;

public class StoreManager {
    List<IStore> iStoreList = new ArrayList<>();

    private static StoreManager me = new StoreManager();

    public static StoreManager getInstance(){
        return me;
    }

    public void register(IStore iStore){
        iStoreList.add(iStore);
    }

    public void clean(){
        for (IStore iStore : iStoreList) {
            iStore.clean();
        }
    }



}
