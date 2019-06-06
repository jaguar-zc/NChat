package org.flyants.common.store;

import android.content.Context;

public interface IStore<T> {
    void loadObject(Context context,OnCallback<T> callback);
    void clean();
}
