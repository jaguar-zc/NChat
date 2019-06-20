package org.flyants.common.store;

import android.content.Context;

public interface IStore<P,T> {
    void loadObject(Context context,OnCallback<T> callback);
    void loadObject(Context context,P param,OnCallback<T> callback);
    void clean();
}
